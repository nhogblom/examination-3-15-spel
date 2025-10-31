package org.example;


import org.example.Panels.StartPanel.StartPanel;

import javax.swing.*;

public class GUI extends JFrame {
    JFrame frame = new JFrame();
    StartPanel StartPanel = new StartPanel();

    GUI() {
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(StartPanel);
        StartPanel.setVisible(true);
    }
}