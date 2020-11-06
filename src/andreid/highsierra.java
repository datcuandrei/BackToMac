/*
 * highsierra.java
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

public class highsierra {
    JFrame highSierra = new JFrame("Install macOS High Sierra");
    JPanel introduction = new JPanel();

    public void setIntroduction(JPanel introduction) {
        this.introduction = introduction;
    }

    public void setHighSierra(JFrame highSierra) {
        this.highSierra = highSierra;
    }

    public JPanel getIntroduction() {
        JTextPane title = new JTextPane();
        title.setContentType("text/html");
        title.setText("<html><head></head><body><div align=\"center\"><h1>Before continuing</h1><h2>Please read the following instructions carefully.</h2></div></body></html>");
        title.setEditable(false);

        JTextPane text = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(text);
        text.setContentType("text/html");
        text.setText("<html><head></head><body><div align=\"center\"><p>• BackToMac will give the best results if ran natively(either installed on your system,or through a live distro).<br/>Running the program through a VM will most likely result in a non-working USB installation.</p><p>• If you haven't inserted your USB drive,it would be a good time to do so.</p><p>• Format the USB drive.I recommended you format it as NTFS with the partition table set as GPT.<br/>BackToMac will automatically change the file system to the one required once the flashing process begins.(HFS+)</p><p>• BackToMac will start downloading the version of macOS you have requested after you hit the \"Proceed\" button.</p><p>The OS will be patched to work both on officially supported Macs and unsupported Macs,thanks to <b>dosdude1</b>(See \"Attribution\" for more info.)</p><p>• After the download has been finished,BackToMac will show you a list of connected USB devices.</p><p>If you don't know which one is your USB <b>disk</b>,open a new terminal window and use <b>lsblk</b>.</p><img alt=\"Drive label example\" src=\"https://raw.githubusercontent.com/datcuandrei/BackToMac/master/resources/lsblk.jpg\"><p>As you can see,in my case <b>sdc</b> is the label of my USB drive.Note that the label is <b>disk</b> and not the <b>part</b>.</p><p>• The process will take a a long time,so let the program run.It will let you know when it is done.</p><p>• BackToMac will safely unmount your drive and ask you if you want to delete the OS image after the process is done.</p></div></body></html>");
        text.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton proceed = new JButton("Proceed");
        proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String hsURL = "http://www.mediafire.com/file/amhg0isydeye16m/HighSierraInstallerPatched.iso.cdr/file";
                File output = new File("/var/tmp/HighSierraInstallerPatched.iso.txt");
                String OS = "HighSierraInstallerPatched.iso.cdr";
                String OSlocal = "/var/tmp/HighSierraInstallerPatched.iso.cdr";
                double OSsize = 8.6;

                new Thread(new download(hsURL,output,OS,OSlocal,OSsize)).start();

            }
        });

        introduction.add(title);
        introduction.add(scrollPane);
        introduction.add(proceed);

        return introduction;
    }

    public JFrame getHighSierra() {
        highSierra.setLocationRelativeTo(null);
        highSierra.setLayout(new FlowLayout(FlowLayout.CENTER));
        highSierra.setContentPane(new highsierra().getIntroduction());
        highSierra.setSize(810,570);
        highSierra.setVisible(true);
        highSierra.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        return highSierra;
    }
}
