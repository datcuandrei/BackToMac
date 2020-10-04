/*
    BackToMac

	Module name :
		backtomac.java

	Abstract :
		This is the main class for the program.

	Copyright :
		Andrei Datcu (datcuandrei) 8-September-2020 (last updated : 3-October-2020).
*/

package andreid;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Arrays;

public class backtomac {
    private JButton installMacOSCatalinaButton;
    private JButton installMacOSMojaveButton;
    private JButton installMacOSHighSierraButton;
    private JButton installMacOSSierraButton;
    private JButton reportIssuesButton;
    private JButton authorAndreiDatcuButton;
    private JButton checkForUpdatesButton;
    private JButton attributionButton;
    private JPanel main;

    public backtomac() {
        attributionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame attribution = new JFrame("Attribution");
                attribution.setVisible(true);
                attribution.setSize(550,470);
                attribution.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                attribution.setLocationRelativeTo(null);
                attribution.setLayout(new FlowLayout(FlowLayout.CENTER));

                JTextPane text = new JTextPane();
                text.setContentType("text/html");
                text.setText("<html><head></head><body><div align=\"center\"><h1>BackToMac was made possible thanks to the<br>following technologies and people :</h1><p>• <b>dosdude1</b> - responsible for macOS Patchers.</p><p>• <b>FlatLaf</b> - library responsible for the look and feel.</p><p>• <b>Apache Commons IO</b> - library responsible for downloading files and status.</p><p>• Special thanks to the <b>Unsupported Macs</b> community.</p><br><h2>Links :</h2><p><b>dosdude1</b> : https://www.dosdude1.com/</p><p><b>FlatLaf</b> : https://www.formdev.com/flatlaf/</p><p><b>Apache Commons IO</b> : https://commons.apache.org/proper/commons-io/</p><p><b>Unsupported Macs</b> : https://discord.gg/XbbWAsE</p></div></body></html>");
                text.setEditable(false);

                attribution.add(text);
            }
        });
        installMacOSCatalinaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                cat installCat = new cat();
                installCat.getCatalina();
            }
        });
        checkForUpdatesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String root[] = {"/bin/bash","-c","xdg-open https://github.com/datcuandrei/BackToMac/releases"};
                try {
                    Process p = Runtime.getRuntime().exec(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        reportIssuesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String root[] = {"/bin/bash","-c","xdg-open https://github.com/datcuandrei/BackToMac/issues"};
                try {
                    Process p = Runtime.getRuntime().exec(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        authorAndreiDatcuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String root[] = {"/bin/bash","-c","xdg-open https://github.com/datcuandrei/"};
                try {
                    Process p = Runtime.getRuntime().exec(root);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        installMacOSMojaveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                mojave installMojave = new mojave();
                installMojave.getMojave();
            }
        });
        installMacOSHighSierraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                highsierra installHighSierra = new highsierra();
                installHighSierra.getHighSierra();
            }
        });
        installMacOSSierraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sierra installSierra = new sierra();
                installSierra.getSierra();
            }
        });
    }

    public static void main(String args[]) throws UnsupportedLookAndFeelException, IOException {
        UIManager.setLookAndFeel( new FlatLightLaf() ); // for dark mode = FlatDarculaLaf ; for light mode = FlatLightLaf.
        JFrame frame = new JFrame("BackToMac");
        frame.setContentPane(new backtomac().main);
        frame.setVisible(true);
        frame.setResizable(true);
        frame.setSize(900,450);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
    }
}
