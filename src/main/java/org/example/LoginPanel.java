package org.example;

import javax.swing.*;
import java.awt.*;

public class LoginPanel extends JPanel {
    JPanel headerPanel = new JPanel();
    JPanel inputPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JLabel titleLabel = new JLabel("<html><h1>Starting up a new game!</h1></html>");
    JLabel usernameLabel = new JLabel("Enter your username:");
    JTextField usernameField = new JTextField();
    JLabel gridSizeXLabel = new JLabel("Gridsize rows: ");
    JLabel gridSizeYLabel = new JLabel("Gridsize rows: ");
    JTextField gridSizeX = new JTextField();JTextField gridSizeY = new JTextField();
    JLabel footerSignature = new JLabel("Ivan & Niklas 2025");
    JButton goButton = new JButton("Go");


    public LoginPanel() {
        setLayout(new BorderLayout());
        setVisible(true);
        add(headerPanel,BorderLayout.NORTH);
        add(inputPanel,BorderLayout.CENTER);
        add(footerPanel,BorderLayout.SOUTH);
        headerPanel.add(titleLabel);
        inputPanel.setLayout(new GridLayout(4,2));
        inputPanel.add(usernameLabel);
        inputPanel.add(usernameField);
        inputPanel.add(gridSizeXLabel);
        inputPanel.add(gridSizeX);
        inputPanel.add(gridSizeYLabel);
        inputPanel.add(gridSizeY);
        footerPanel.setLayout(new GridLayout(2,1));
        footerPanel.add(goButton);
        footerPanel.add(footerSignature);
        footerSignature.setHorizontalAlignment(JLabel.CENTER);
    }
}

