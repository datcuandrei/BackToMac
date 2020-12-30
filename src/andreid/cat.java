/*
 * cat.java
 *
 * Copyright 2020 Andrei Datcu <@datcuandrei>
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

public class cat {
    JFrame catalina = new JFrame("Install macOS Catalina");
    JPanel introduction = new JPanel();

    public void setIntroduction(JPanel introduction) {
        this.introduction = introduction;
    }

    public void setCatalina(JFrame catalina) {
        this.catalina = catalina;
    }

    public JPanel getIntroduction() {
        JTextPane title = new JTextPane();
        title.setContentType("text/html");
        title.setText("<html><head></head><body><div align=\"center\"><h1>Before continuing</h1><h2>Please read the following instructions carefully.</h2></div></body></html>");
        title.setEditable(false);

        JTextPane text = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(text);
        text.setContentType("text/html");
        text.setText("<html><head></head><body><div align=\"center\"><p>• BackToMac will give the best results if ran natively(either installed on your system,or through a live distro).<br/>Running the program through a VM will most likely result in a non-working USB installation.</p><p>• If you haven't inserted your USB drive,it would be a good time to do so.</p><p>• Format the USB drive.I recommend you format it as NTFS with the partition table set as GPT.<br/>BackToMac will automatically change the file system to the one required once the flashing process begins.(HFS+)</p><p>• After you hit the \"Proceed\" button,BackToMac will ask you which patcher you want to use.</p><p>The patchers are created for unsupported Macs.<br>If you are on a supported machine,the patcher you choose will not affect the way your Mac works.</p><p>Special thanks go to <b>dosdude1</b> and <b>RMC</b>(See \"Attribution\" for more info.)</p><p>• After the download has been finished,BackToMac will show you a list of connected USB devices.</p><p>If you don't know which one is your USB <b>disk</b>,open a new terminal window and use <b>lsblk</b>.</p><img alt=\"Drive label example\" src=\"https://raw.githubusercontent.com/datcuandrei/BackToMac/master/resources/lsblk.jpg\"><p>As you can see,in my case <b>sdc</b> is the label of my USB drive.Note that the label is <b>disk</b> and not the <b>part</b>.</p><p>• The process will take a a long time,so let the program run.It will let you know when it is done.</p><p>• BackToMac will safely unmount your drive and ask you if you want to delete the OS image after the process is done.</p></div></body></html>");
        text.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton proceed = new JButton("Proceed");
        proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Object options[] = {"RMC Patcher" , "dosdude1 Patcher"};
                int n = JOptionPane.showOptionDialog(null, "What patcher would you like to use?", "Choose patcher", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[1]);
                if(n == JOptionPane.YES_OPTION) {
                    String patcherRMC = "RMC";
                    String hsURLRMC = "https://www.mediafire.com/file/7h88h6y60xon0p4/CatalinaInstallerPatched.cdr.iso/file";
                    File outputRMC = new File("/var/tmp/CatalinaInstallerPatched.cdr.txt");
                    String OSRMC = "CatalinaInstallerPatched.cdr.iso";
                    String OSlocalRMC = "/var/tmp/CatalinaInstallerPatched.cdr.iso";
                    double OSsizeRMC = 9.7;

                    new Thread(new download(hsURLRMC, outputRMC, OSRMC, OSlocalRMC, OSsizeRMC, patcherRMC)).start();
                }
                if (n == JOptionPane.NO_OPTION) {
                    String patcherdosDude1 = "dosDude1";
                    String hsURLdosDude1 = "http://www.mediafire.com/file/v7iigh3hxoom3v6/CatalinaInstallerPatched.iso.cdr/file";
                    File outputdosDude1 = new File("/var/tmp/CatalinaInstallerPatched.iso.txt");
                    String OSdosDude1 = "CatalinaInstallerPatched.iso.cdr";
                    String OSlocaldosDude1 = "/var/tmp/CatalinaInstallerPatched.iso.cdr";
                    double OSsizedosDude1 = 7.07;

                    new Thread(new download(hsURLdosDude1,outputdosDude1,OSdosDude1,OSlocaldosDude1,OSsizedosDude1, patcherdosDude1)).start();
                }
                else {
                    System.out.println("User didn't choose any option.");
                }
            }
        });

        introduction.add(title);
        introduction.add(scrollPane);
        introduction.add(proceed);

        return introduction;
    }

    public JFrame getCatalina() {
        catalina.setLocationRelativeTo(null);
        catalina.setLayout(new FlowLayout(FlowLayout.CENTER));
        catalina.setContentPane(new cat().getIntroduction());
        catalina.setSize(810,640);
        catalina.setVisible(true);
        catalina.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        return catalina;
    }
}
