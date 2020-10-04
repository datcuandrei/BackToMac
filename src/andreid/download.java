/*
    BackToMac

	Module name :
		download.java

	Abstract :
		This class is responsible for downloading the OSes.

	Author :
		Andrei Datcu (datcuandrei) 9-September-2020 (last updated : 4-October-2020).
*/

package andreid;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import javax.swing.*;

public class download implements Runnable{
    String osURL;
    File output;
    String osName;
    String fileToFlash;
    double OSsize;

    public download(String osURL, File output, String osName, String fileToFlash, double OSsize) {
        this.osURL = osURL;
        this.output = output;
        this.osName = osName;
        this.fileToFlash = fileToFlash;
        this.OSsize = OSsize;
    }
    @Override
    public void run() {

        // Frame for downloading progress.

        File pathOS = new File("/var/tmp/"+osName);
        if (pathOS.exists()){
            JOptionPane.showMessageDialog(null, "The OS is already downloaded!\nClick OK to continue", "Download skipped",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("OS already exists on disk!\nSkipping download process...");
            flash flashingProcess = new flash();
            flashingProcess.getFlashing(fileToFlash,output);
        }
        else {
            JFrame downloading = new JFrame("Download in progress..");
            downloading.setLocationRelativeTo(null);
            downloading.setLayout(new FlowLayout(FlowLayout.CENTER));
            downloading.setSize(500, 250);
            JTextPane text = new JTextPane();
            text.setContentType("text/html");
            text.setText("<html><head></head><body><div align=\"center\"><h1>Download started!</h1><h3>Don't let the computer enter sleep/stand-by mode.</h3><h3>When the download has finished,the program will<br/>close this window and take you to the next step.</h3></div></body></html>");
            text.setEditable(false);

            File getDownloadSize = new File(fileToFlash);
            String size = FileUtils.byteCountToDisplaySize(getDownloadSize.length());
            String progressText = "Downloaded : " + size + "/" + OSsize + " GB";
            JLabel progress = new JLabel(progressText);
            JLabel speed = new JLabel("*Download speed may vary depending on your internet connection and location.");
            JButton refresh = new JButton("⟳");
            JButton cancel = new JButton("Cancel");
            JProgressBar progressBar = new JProgressBar();
            progressBar.setVisible(true);
            progressBar.setIndeterminate(true);
            progressBar.setPreferredSize(new Dimension(400,3));
            refresh.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent actionEvent) {
                    System.out.println("refreshing");
                    File refreshFile = new File(fileToFlash);
                    String refreshSize = FileUtils.byteCountToDisplaySize(refreshFile.length());
                    progress.setText("Downloaded : " + refreshSize + "/" + OSsize + " GB");
                    SwingUtilities.updateComponentTreeUI(downloading);
                    System.out.println("refresh done");
                }
            });
            cancel.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (JOptionPane.showConfirmDialog(null, "Are you sure you want to cancel the downloading process?", "Warning!",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        System.out.println("The operation has been cancelled.");
                        downloading.setVisible(false);
                        JOptionPane.showMessageDialog(null, "The downloading process was cancelled succesfully.", "Operation cancelled",JOptionPane.WARNING_MESSAGE);
                        System.exit(0);
                    } else {
                        System.out.println("Operation will continue...");
                    }
                }
            });
            downloading.add(text);
            downloading.add(progressBar);
            downloading.add(progress);
            downloading.add(refresh);
            downloading.add(cancel);
            downloading.add(speed);
            downloading.setVisible(true);
            SwingUtilities.updateComponentTreeUI(downloading);

            // URL fetcher
            System.out.println("Fetching download...");
            URL url = null;
            try {
                url = new URL(osURL);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                FileUtils.copyURLToFile(url, output);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                BufferedReader br = new BufferedReader(new FileReader(output));
            } catch (FileNotFoundException fileNotFoundException) {
                fileNotFoundException.printStackTrace();
            }
            InputStream in = null;
            try {
                in = new URL(osURL).openStream();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            String readHTML = null;
            try {
                readHTML = IOUtils.toString(in);
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            String fetchDownload = readHTML.substring(readHTML.indexOf("http://download"), readHTML.lastIndexOf(osName + "\">"));
            System.out.println("Download fetched!");

            // Downloading OS
            String finalOSDownload = fetchDownload + osName;
            URL downloadOS = null;
            try {
                downloadOS = new URL(finalOSDownload);
            } catch (MalformedURLException malformedURLException) {
                malformedURLException.printStackTrace();
            }
            System.out.println("Downloading OS...");
            try {
                FileUtils.copyURLToFile(downloadOS, pathOS);
            } catch (IOException exception) {
                exception.printStackTrace();
            }
            System.out.println("Download complete!");
            downloading.setVisible(false);

            flash flashingProcess = new flash();
            flashingProcess.getFlashing(fileToFlash, output);
        }
    }
}


