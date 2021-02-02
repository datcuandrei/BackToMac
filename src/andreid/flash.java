/*
 * flash.java
 *
 * Copyright 2020-2021 Andrei Datcu <@datcuandrei>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 *
 */

package andreid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class flash {
    JFrame flashing;

    public void setFlashing(JFrame flashing) {
        this.flashing = flashing;
    }

    public JFrame getFlashing(String flashingFile, File downloadOutput) {
        String fileToFlash = flashingFile;
        File output = downloadOutput;

        JFrame flashUSB = new JFrame("BackToMac - USB flash");
        flashUSB.setLocationRelativeTo(null);
        flashUSB.setVisible(true);
        flashUSB.setLayout(new FlowLayout(FlowLayout.CENTER));
        flashUSB.setSize(430,250);
        JTextPane text1 = new JTextPane();
        text1.setContentType("text/html");
        text1.setText("<html><head></head><body><div align=\"center\"><h1>Let's create the bootable USB!</h1><h3>While the USB will be flashed,please don't let the<br/>computer enter sleep/stand-by mode.</h3><h3>When the flashing process has finished,the program will<br/>close this window and take you to the finish screen!</h3></div></body></html>");
        text1.setEditable(false);


        File usbs = new File("/dev/");
        String[] getUSBs = usbs.list(new FilenameFilter() {
            @Override
            public boolean accept(File usbs, String stick) {
                return stick.toLowerCase().startsWith("sd");
            }
        });

        JComboBox comboBox = new JComboBox(getUSBs);
        JButton flashIt = new JButton("Start");
        flashUSB.add(text1);
        flashUSB.add(comboBox);
        flashUSB.add(flashIt);
        SwingUtilities.updateComponentTreeUI(flashUSB);

        flashIt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                flashUSB.setVisible(false);
                String USB = String.valueOf(comboBox.getSelectedItem());
                flashing = new JFrame("Flashing USB in progress..");
                flashing.setLocationRelativeTo(null);
                flashing.setLayout(new FlowLayout(FlowLayout.CENTER));
                flashing.setSize(490,230);
                JTextPane text2 = new JTextPane();
                text2.setContentType("text/html");
                text2.setText("<html><head></head><body><div align=\"center\"><h1>Flashing in progress...</h1><h3>Don't let the computer enter sleep/stand-by mode.</h3><h3>When the flashing process has ended,the program will<br/>close this window and take you to the finish screen.</h3></div></body></html>");
                text2.setEditable(false);
                JLabel statusLabel = new JLabel();
                JProgressBar indefprog = new JProgressBar();
                JButton cancel = new JButton("Cancel");
                indefprog.setIndeterminate(true);
                indefprog.setVisible(true);
                indefprog.setPreferredSize(new Dimension(400,3));
                flashing.add(text2);
                flashing.add(indefprog);
                flashing.add(statusLabel);
                flashing.add(cancel);
                flashing.setVisible(true);

                // Delete request frame :

                JFrame requestDelete = new JFrame("Delete downloaded files.");
                requestDelete.setSize(265,110);
                requestDelete.setLocationRelativeTo(null);
                requestDelete.setLayout(new FlowLayout(FlowLayout.CENTER));
                JLabel message = new JLabel("Do you want to delete downloaded files?");
                JButton requestYes = new JButton("Yes");
                JButton requestNo = new JButton("No");

                requestDelete.add(message);
                requestDelete.add(requestYes);
                requestDelete.add(requestNo);

                // Flashing thread (at this point I've lost my sanity.)
                    Thread flashThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                                System.out.println("USB : " + USB);
                                System.out.println("File : " + fileToFlash);

                                System.out.println("Flashing in progress...");
                                String[] flashScript = {"/bin/bash","-c","sudo dd if="+fileToFlash+" of=/dev/"+USB};
                                try {
                                    Process dd = Runtime.getRuntime().exec(flashScript);
                                    dd.waitFor();
                                } catch (InterruptedException | IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    Thread finishFlash = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                flashThread.join();
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Flashed successfully!");
                            System.out.println("Safely ejecting the USB...");
                            String[] ejectScript = {"/bin/bash","-c","eject /dev/"+USB};
                            try {
                                Process eject = Runtime.getRuntime().exec(ejectScript);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            System.out.println("Ejected successfully!");
                            if(output.toString() != null){
                                requestDelete.setVisible(true);
                                requestYes.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        System.out.println("Deleting downloaded files...");
                                        String[] removeScript = {"/bin/bash","-c","sudo rm "+fileToFlash+" && sudo rm "+output.toString()};
                                        try {
                                            Process remove = Runtime.getRuntime().exec(removeScript);
                                            JOptionPane.showMessageDialog(null, "<html><head></head><body><div align=\"center\"><h1>Flashed successfully!</h1><h3>The drive is now ready!</h3><h3>You can now restart your Mac and boot from the drive.<br/>Thank you for using BackToMac!</h3></div></body></html>", "Done!",JOptionPane.PLAIN_MESSAGE);
                                        } catch (IOException e) {
                                            e.printStackTrace();
                                        }
                                        System.out.println("Files deleted successfully!");
                                    }
                                });

                                requestNo.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent actionEvent) {
                                        requestDelete.setVisible(false);
                                        JOptionPane.showMessageDialog(null, "<html><head></head><body><div align=\"center\"><h1>Flashed successfully!</h1><h3>The drive is now ready!</h3><h3>You can now restart your Mac and boot from the drive.<br/>Thank you for using BackToMac!</h3></div></body></html>", "Done!",JOptionPane.PLAIN_MESSAGE);
                                    }
                                });
                            }else{
                                requestDelete.setVisible(false);
                                JOptionPane.showMessageDialog(null, "<html><head></head><body><div align=\"center\"><h1>Flashed successfully!</h1><h3>The drive is now ready!</h3><h3>You can now restart your Mac and boot from the drive.<br/>Thank you for using BackToMac!</h3></div></body></html>", "Done!",JOptionPane.PLAIN_MESSAGE);
                            }
                            flashing.setVisible(false);
                        }
                    });
                flashThread.start();
                cancel.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel the flashing process?\nCancelling will make the USB drive unrecognizable and will need to be reformatted.", "Warning!",
                                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                            flashThread.stop();
                            flashing.setVisible(false);
                            System.out.println("The operation has been cancelled.");
                            JOptionPane.showMessageDialog(null, "The flashing process was cancelled succesfully.", "Operation cancelled",JOptionPane.WARNING_MESSAGE);
                            System.exit(0);
                        } else {
                            System.out.println("Operation will continue...");
                        }
                    }
                });
                finishFlash.start();
            }
        });
        return flashing;
    }
}
