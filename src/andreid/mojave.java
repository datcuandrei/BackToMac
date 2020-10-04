/*
    BackToMac

	Module name :
		mojave.java

	Abstract :
		This class is responsible for downloading and flashing macOS Mojave with dosdude1's patcher included.

	Author :
		Andrei Datcu (datcuandrei) 17-September-2020 (last updated : 21-September-2020).
*/
package andreid;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class mojave {
    JFrame mojave = new JFrame("Install macOS Mojave");
    JPanel introduction = new JPanel();

    public void setIntroduction(JPanel introduction) {
        this.introduction = introduction;
    }

    public void setMojave(JFrame mojave) {
        this.mojave = mojave;
    }

    public JPanel getIntroduction() {
        JTextPane title = new JTextPane();
        title.setContentType("text/html");
        title.setText("<html><head></head><body><div align=\"center\"><h1>Before continuing</h1><h2>Please read the following instructions carefully.</h2></div></body></html>");
        title.setEditable(false);

        JTextPane text = new JTextPane();
        JScrollPane scrollPane = new JScrollPane(text);
        text.setContentType("text/html");
        text.setText("<html><head></head><body><div align=\"center\"><p>• If you haven't inserted your USB drive,it would be a good time to do so.</p><p>• Format the USB drive.(disk,not partitions).<br/>BackToMac will automatically change the file system to the one required.(HFS+)</p><p>• BackToMac will start downloading the version of macOS you have requested after you hit the \"Proceed\" button.</p><p>The OS will be patched to work both on officially supported Macs and unsupported Macs,thanks to <b>dosdude1</b>(See \"Attribution\" for more info.)</p><p>• After the download has been finished,BackToMac will show you a list of connected USB devices.</p><p>If you don't know which one is your USB <b>disk</b>,open a new terminal window and use <b>lsblk</b>.</p><img alt=\"Drive label example\" src=\"https://raw.githubusercontent.com/datcuandrei/BackToMac/master/resources/lsblk.jpg\"><p>As you can see,in my case <b>sdc</b> is the label of my USB drive.Note that the label is <b>disk</b> and not the <b>part</b>.</p><p>• The process will take a a long time,so let the program run.It will let you know when it is done.</p><p>• BackToMac will safely unmount your drive and ask you if you want to delete the OS image after the process is done.</p></div></body></html>");
        text.setEditable(false);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        JButton proceed = new JButton("Proceed");
        proceed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String mojaveURL = "http://www.mediafire.com/file/k10gnwxvgxy29t4/MojaveInstallerPatched.iso.cdr/file";
                File output = new File("/var/tmp/MojaveInstallerPatched.iso.txt");
                String OS = "MojaveInstallerPatched.iso.cdr";
                String OSlocal = "/var/tmp/MojaveInstallerPatched.iso.cdr";
                double OSsize = 8.6;

                new Thread(new download(mojaveURL,output,OS,OSlocal,OSsize)).start();
            }
        });

        introduction.add(title);
        introduction.add(scrollPane);
        introduction.add(proceed);

        return introduction;
    }

    public JFrame getMojave() {
        mojave.setLocationRelativeTo(null);
        mojave.setLayout(new FlowLayout(FlowLayout.CENTER));
        mojave.setContentPane(new mojave().getIntroduction());
        mojave.setSize(900,550);
        mojave.setVisible(true);
        mojave.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        return mojave;
    }
}
