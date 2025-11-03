package org.example.Panels.StartPanel;

import org.example.GUI;
import org.example.Panels.StartPanel.ButtonActionListener.HighscoreButtonActionListener;
import org.example.Panels.StartPanel.ButtonActionListener.startButtonActionListener;

import javax.swing.*;
import java.awt.*;

public class StartPanel extends JPanel {
    GUI gui;
    JPanel headerPanel = new JPanel();
    JPanel optionsPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JLabel titleLabel = new JLabel("<html><h1>Welcome to our board game!</h1></html>");
    JButton startButton = new JButton("Start new game");
    JButton highscoreButton = new JButton("High Scores");
    JButton exitButton = new JButton("Exit");
    JLabel footerSignature = new JLabel("Ivan & Niklas 2025");


    public StartPanel(GUI gui) {
    this.gui = gui;
    setLayout(new BorderLayout());
    setVisible(true);
    add(headerPanel,BorderLayout.NORTH);
    add(optionsPanel,BorderLayout.CENTER);
    add(footerPanel,BorderLayout.SOUTH);

    optionsPanel.setLayout(new GridLayout(4, 1));
    headerPanel.add(titleLabel);
    optionsPanel.add(startButton);
    optionsPanel.add(highscoreButton);
    optionsPanel.add(exitButton);
    exitButton.addActionListener(e -> gui.closeProgram());
    footerPanel.add(footerSignature);
    startButton.addActionListener(new startButtonActionListener(this,gui));
    highscoreButton.addActionListener(new HighscoreButtonActionListener(this));

    }

    public GUI getGui() {
        return gui;
    }

    public void setGui(GUI gui) {
        this.gui = gui;
    }
}
