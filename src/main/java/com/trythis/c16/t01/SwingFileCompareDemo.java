package com.trythis.c16.t01;

import java.io.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.nio.channels.FileChannel;

public class SwingFileCompareDemo implements ActionListener {

    JTextField fileField1;
    JTextField fileField2;
    JLabel file1Label;
    JLabel file2Label;
    JLabel comparisonResult;
    JCheckBox onlyLengthCompare;
    JButton compare;

    SwingFileCompareDemo() {
        JFrame frame = new JFrame("Files comparison app");
        frame.setLayout(new FlowLayout());
        frame.setSize(250, 250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fileField1 = new JTextField(18);
        file1Label = new JLabel("First file:");
        fileField2 = new JTextField(18);
        file2Label = new JLabel("Seconds file:");
        frame.add(file1Label);
        frame.add(fileField1);
        frame.add(file2Label);
        frame.add(fileField2);
        onlyLengthCompare = new JCheckBox("just compare lengths");
        frame.add(onlyLengthCompare);
        compare = new JButton("Compare");
        compare.setSize(250, 50);
        compare.addActionListener(this);
        frame.add(compare);
        frame.add(new JLabel("                                                                         "));
        comparisonResult = new JLabel("Try to compare two files!");
        frame.add(comparisonResult);
        frame.setVisible(true);
    }



    @Override
    public void actionPerformed(ActionEvent e) {
        synchronized (this) {
            try (DataInputStream file1 = new DataInputStream(new FileInputStream(fileField1.getText())); DataInputStream file2 = new DataInputStream(new FileInputStream(fileField2.getText()))) {
                if (onlyLengthCompare.isSelected()) {
                    if (file1.readAllBytes().length == file2.readAllBytes().length) comparisonResult.setText("Files have one length!");
                    else comparisonResult.setText("Files have different lengths");
                }
                else {
                    byte f1, f2;
                    do {
                        f1 = (byte) file1.read();
                        f2 = (byte) file2.read();
                        if (f1 != f2) {
                            comparisonResult.setText("Files are different!");
                            break;
                        }
                    } while (f1 != -1 | f2 != -1);
                    if (f1 == f2) comparisonResult.setText("Files are the same!");
                }
            } catch (FileNotFoundException exception) {
                comparisonResult.setText("File(s) do not exist or specified incorrect!");
            } catch (IOException exception) {
                comparisonResult.setText("File(s) reading error!");
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SwingFileCompareDemo::new);
    }
}
