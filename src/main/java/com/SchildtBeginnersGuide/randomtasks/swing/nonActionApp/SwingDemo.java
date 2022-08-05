package com.SchildtBeginnersGuide.randomtasks.swing.nonActionApp;

import javax.swing.*;

public class SwingDemo {
    SwingDemo() {
        JFrame jFrame = new JFrame("Simple frame");
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(200, 100);
        JLabel jLabel = new JLabel("First GUI program with Swing!");
        jFrame.add(jLabel);
        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SwingDemo();
            }
        });
    }
}
