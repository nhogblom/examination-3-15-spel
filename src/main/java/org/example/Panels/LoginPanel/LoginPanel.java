package org.example.Panels.LoginPanel;

import org.example.Enums.Difficulty;
import org.example.GUI;
import org.example.OneFiveGame;
import org.example.Panels.GameBoardPanel.GameBoardPanel;
import org.example.Panels.StartPanel.StartPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginPanel extends JPanel {
    GUI gui;
    JPanel inputPanel = new JPanel();
    JPanel footerPanel = new JPanel();
    JLabel titleLabel = new JLabel("<html><h1>Starting up a new game!</h1></html>");
    JLabel usernameLabel = new JLabel("Enter your username:");
    JTextField usernameField = new JTextField(15);
    JLabel footerSignature = new JLabel("Ivan & Niklas 2025");

    JPanel difficultyButtonPanel = new JPanel();
    JButton easyDifficultyButton = new JButton(Difficulty.EASY.getDescription());
    JButton MediumDifficultyButton = new JButton(Difficulty.MEDIUM.getDescription());
    JButton HardDifficultyButton = new JButton(Difficulty.HARD.getDescription());

    JButton backButton = new JButton("Back");

    public LoginPanel(GUI gui) {
        this.gui = gui;
        setLayout(new GridLayout(5,1));
        setVisible(true);

        difficultyButtonPanel.setLayout(new GridLayout(1, 3));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add(titleLabel);
        add(inputPanel);
        inputPanel.setLayout(new GridLayout(1,2));
        inputPanel.add(usernameLabel);
        inputPanel.add(usernameField);
        add(difficultyButtonPanel);
        difficultyButtonPanel.add(easyDifficultyButton);
        difficultyButtonPanel.add(MediumDifficultyButton);
        difficultyButtonPanel.add(HardDifficultyButton);

        add(backButton);
        backButton.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.setContentPane(new StartPanel(this.gui));
            frame.revalidate();
            frame.repaint();
        });

        add(footerPanel);
        footerPanel.add(footerSignature);
        footerSignature.setHorizontalAlignment(JLabel.CENTER);

        ActionListener difficultyButtonListener = e -> {
            JButton clickedButton = (JButton) e.getSource();
            if(usernameField.getText().isEmpty()){
                JOptionPane.showMessageDialog(this, "Please enter your username!");
            }else{
                difficultyButtonActionPerformed(usernameField.getText(),clickedButton.getText());
            }
        };

        easyDifficultyButton.addActionListener(difficultyButtonListener);
        MediumDifficultyButton.addActionListener(difficultyButtonListener);
        HardDifficultyButton.addActionListener(difficultyButtonListener);

    }

    private void difficultyButtonActionPerformed(String username, String difficulty) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        OneFiveGame ofg;

        if(difficulty.equals(Difficulty.EASY.getDescription())){
            ofg = new OneFiveGame(username, Difficulty.EASY.getxRows(), Difficulty.EASY.getyRows(),Difficulty.EASY);
        }else if(difficulty.equals(Difficulty.MEDIUM.getDescription())){
            ofg = new OneFiveGame(username,Difficulty.MEDIUM.getxRows(), Difficulty.MEDIUM.getyRows(),Difficulty.MEDIUM);
        }else {
            ofg = new OneFiveGame(username,Difficulty.HARD.getxRows(), Difficulty.HARD.getyRows(),Difficulty.HARD);
        }
            GameBoardPanel gameBoardPanel = new GameBoardPanel(ofg, gui, this);
            frame.add(gameBoardPanel);
            frame.setContentPane(gameBoardPanel);
            frame.revalidate();
            frame.repaint();
        }

}

