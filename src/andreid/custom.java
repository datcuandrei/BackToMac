/*
 * custom.java
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
import java.io.File;

public class custom {
    JFrame custom = new JFrame("Custom OS Image");
    JPanel customIntroduction = new JPanel();

    public JPanel getCustomIntroduction() {
        JTextPane title = new JTextPane();
        title.setContentType("text/html");
        title.setText("<html><head></head><body><div align=\"center\"><h1>Before continuing</h1><h2>Please read the following instructions carefully.</h2></div></body></html>");
        title.setEditable(false);

        JTextPane customText = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(customText);
        customText.setContentType("text/html");
        customText.setText("<html><head></head><body><div align=\"center\"><p>• BackToMac will give the best results if ran natively(either installed on your system,or through a live distro). <br>Running the program through a VM will most likely result in a non-working USB installation.</p><p>• If you haven't inserted your USB drive,it would be a good time to do so.</p><p>• Format the USB drive.I recommend you format it as NTFS with the partition table set as GPT. <br>BackToMac will automatically change the file system to the one required once the flashing process begins.(HFS+)</p><p>• After you hit the \"Proceed\" button,BackToMac will let you browse for an OS image to choose.<br>BackToMac currently supports iso's and cdr's.</p><p>• After you choose your custom OS image,BackToMac will show you a list of connected USB devices.</p><p>If you don't know which one is your USB <b>disk</b>,open a new terminal window and use <b>lsblk</b>.</p> <img alt=\"Drive label example\" src=\"https://raw.githubusercontent.com/datcuandrei/BackToMac/master/resources/lsblk.jpg\"><p>As you can see,in my case <b>sdc</b> is the label of my USB drive.Note that the label is <b>disk</b> and not the <b>part</b>.</p><p>• The process will take a a long time,so let the program run.It will let you know when it is done.</p><p>• BackToMac will safely unmount your drive and ask you if you want to delete the OS image after the process is done.</p></div></body></html>");
        customText.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton proceed = new JButton("Proceed");
        proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String path;
                JFileChooser browseLocation = new JFileChooser();
                browseLocation.setDialogTitle("Browse...");
                browseLocation.setFileSelectionMode(JFileChooser.OPEN_DIALOG);
                if (browseLocation.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    path = browseLocation.getSelectedFile().getAbsolutePath();
                    flash flashingProcess = new flash();
                    flashingProcess.getFlashing(path,null);
                }
            }
        });

        customIntroduction.add(title);
        customIntroduction.add(scrollPane);
        customIntroduction.add(proceed);

        return customIntroduction;
    }

    public JFrame getCustom() {
        custom.setLocationRelativeTo(null);
        custom.setLayout(new FlowLayout(FlowLayout.CENTER));
        custom.setContentPane(new custom().getCustomIntroduction());
        custom.setSize(810,640);
        custom.setVisible(true);
        custom.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        return custom;
    }
}
