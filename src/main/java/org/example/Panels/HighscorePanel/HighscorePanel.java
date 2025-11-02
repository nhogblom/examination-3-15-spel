package org.example.Panels.HighscorePanel;

import org.example.Panels.HighscorePanel.ButtonActionListener.BackButtonActionListener;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;

public class HighscorePanel extends JPanel {

    JPanel previousPanel;
    JLabel highscoreLabel = new JLabel("Highscore");
    JTextArea highScoreTextArea = new JTextArea();

    JPanel buttonPanel = new JPanel();
    JButton backButton = new JButton("Back");

    public HighscorePanel(JPanel previousPanel) {
        this.previousPanel = previousPanel;
        ArrayList<Highscore> hlistEasy = Highscore.getHighscoresList();
        
        setLayout(new BorderLayout());

        add(highscoreLabel,BorderLayout.NORTH);
        highscoreLabel.setHorizontalAlignment(SwingConstants.CENTER);


        StringBuilder textAreaTextSb = new StringBuilder();
        textAreaTextSb.append("Name").append("\t".repeat(2))
                .append("Turns").append("\t".repeat(2))
                .append("Time").append("\t".repeat(2)).append("\n");

        for(Highscore highscore : hlistEasy){
            textAreaTextSb.append(highscore.getName()).append("\t".repeat(2))
                    .append(highscore.getTurns()).append("\t".repeat(2))
                    .append("12:30").append("\t".repeat(2)).append("\n");
        }

        highScoreTextArea.setText(textAreaTextSb.toString());
        highScoreTextArea.setEditable(false);
        highScoreTextArea.setOpaque(false);
        highScoreTextArea.setBackground(new Color(0,0,0,0));
        add(highScoreTextArea,BorderLayout.CENTER);

        add(buttonPanel,BorderLayout.SOUTH);
        buttonPanel.add(backButton);
        backButton.addActionListener(new BackButtonActionListener(this.previousPanel));

    }

}
