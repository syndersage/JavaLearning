package com.randomtasks.swing.buttons;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ButtonSwingDemo implements ActionListener {
    private static int buttonsPressed = 0;
    private synchronized static void changeButtonPresses(boolean add) {
        buttonsPressed += add ? 1 : -1;
    }

    public static int getButtonsPressed() {
        return buttonsPressed;
    }

    JLabel jLabel;
    ButtonSwingDemo() {
        JFrame jFrame = new JFrame("Button app");
        jFrame.setLayout(new FlowLayout());
        jFrame.setSize(450, 200);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jLabel = new JLabel("Text for button app");
        jLabel.setSize(255, 50);
        jFrame.add(jLabel);
        JButton jButton1 = new JButton("BUTTON1");
        JButton jButton2 = new JButton("BUTTON2");
        jButton1.setPreferredSize(new Dimension(200, 50));
        jFrame.add(jButton1, BorderLayout.NORTH);
        jButton1.addActionListener(this);
        jButton2.setPreferredSize(new Dimension(200, 50));
        jFrame.add(jButton2, BorderLayout.SOUTH);
        jButton2.addActionListener(this);
        jFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("BUTTON1"))
            jLabel.setText("top button pressed!");
        else if (e.getActionCommand().equals("BUTTON2")) {
            jLabel.setText("bottom button pressed!");
        }
        new Thread(() -> {
            ButtonSwingDemo.changeButtonPresses(true);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }
            ButtonSwingDemo.changeButtonPresses(false);
            if (getButtonsPressed() == 0) jLabel.setText("press any button!");
        }).start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(ButtonSwingDemo::new);
    }
}