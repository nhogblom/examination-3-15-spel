package org.example.Panels.StartPanel;

import org.example.Panels.StartPanel.ButtonActionListener.HighscoreButtonActionListener;
import org.example.Panels.StartPanel.ButtonActionListener.startButtonActionListener;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    JPanel headerPanel = new JPanel();
    JPanel optionsPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JLabel titleLabel = new JLabel("<html><h1>Welcome to our board game!</h1></html>");
    JButton startButton = new JButton("Start new game");
    JButton highscoreButton = new JButton("High Scores");
    JButton settingsButton = new JButton("Settings");
    JButton exitButton = new JButton("Exit");
    JLabel footerSignature = new JLabel("Ivan & Niklas 2025");


    public StartPanel() {
    setLayout(new BorderLayout());
    setVisible(true);
    add(headerPanel,BorderLayout.NORTH);
    add(optionsPanel,BorderLayout.CENTER);
    add(footerPanel,BorderLayout.SOUTH);

    optionsPanel.setLayout(new GridLayout(4, 1));
    headerPanel.add(titleLabel);
    optionsPanel.add(startButton);
    optionsPanel.add(highscoreButton);
    optionsPanel.add(settingsButton);
    optionsPanel.add(exitButton);
    exitButton.addActionListener(e -> System.exit(0));
    footerPanel.add(footerSignature);

    startButton.addActionListener(new startButtonActionListener(this));
    highscoreButton.addActionListener(new HighscoreButtonActionListener(this));


    }


}
