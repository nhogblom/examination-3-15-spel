package org.example.Panels.HighscorePanel;

import org.example.Enums.Difficulty;
import org.example.Panels.HighscorePanel.ButtonActionListener.BackButtonActionListener;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;

public class HighscorePanel extends JPanel {

    JPanel previousPanel;
    JLabel highscoreLabel = new JLabel("Highscore (Easy)");
    JLabel highscoreLabelMedium = new JLabel("Highscore (Medium)");
    JLabel highscoreLabelHard = new JLabel("Highscore (Hard)");
    JTextArea highScoreTextArea = new JTextArea();
    JTextArea highScoreTextAreaMedium = new JTextArea();
    JTextArea highScoreTextAreaHard = new JTextArea();

    JPanel buttonPanel = new JPanel();
    JButton backButton = new JButton("Back");

    public HighscorePanel(JPanel previousPanel) {
        this.previousPanel = previousPanel;
        ArrayList<Highscore> hlistEasy = Highscore.getHighscoresList();
        ArrayList<Highscore> hlistMedium = Highscore.getHighscoresListMedium();
        ArrayList<Highscore> hlistHard = Highscore.getHighscoresListHard();

        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(previousPanel);
        setLayout(new GridLayout(0,1,0,0));
        frame.setSize(500,750);

        add(highscoreLabel);
        highscoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        highScoreTextArea.setText(getHighscoreEntriesForDifferentDifficulty(hlistEasy));
        highScoreTextArea.setEditable(false);
        highScoreTextArea.setOpaque(false);
        highScoreTextArea.setBackground(new Color(0,0,0,0));
        highScoreTextArea.setBorder(BorderFactory.createEmptyBorder());
        add(highScoreTextArea);



        add(highscoreLabelMedium);
        highscoreLabelMedium.setHorizontalAlignment(SwingConstants.CENTER);
        highScoreTextAreaMedium.setText(getHighscoreEntriesForDifferentDifficulty(hlistMedium));
        highScoreTextAreaMedium.setEditable(false);
        highScoreTextAreaMedium.setOpaque(false);
        highScoreTextAreaMedium.setBackground(new Color(0,0,0,0));
        add(highScoreTextAreaMedium);

        add(highscoreLabelHard);
        highscoreLabelHard.setHorizontalAlignment(SwingConstants.CENTER);
        highScoreTextAreaHard.setText(getHighscoreEntriesForDifferentDifficulty(hlistHard));
        highScoreTextAreaHard.setEditable(false);
        highScoreTextAreaHard.setOpaque(false);
        highScoreTextAreaHard.setBackground(new Color(0,0,0,0));
        add(highScoreTextAreaHard);

        add(buttonPanel);
        buttonPanel.add(backButton);
        backButton.addActionListener(new BackButtonActionListener(this.previousPanel));
    }

    private String getHighscoreEntriesForDifferentDifficulty(ArrayList<Highscore> highscoreList) {
        StringBuilder textAreaTextSb = new StringBuilder();
        textAreaTextSb.setLength(0);
        textAreaTextSb.append("Name").append("\t".repeat(2))
                .append("Turns").append("\t".repeat(2))
                .append("Time").append("\t".repeat(2)).append("\n");

        for(Highscore highscore : highscoreList){
            textAreaTextSb.append(highscore.getName()).append("\t".repeat(2))
                    .append(highscore.getTurns()).append("\t".repeat(2))
                    .append("12:30").append("\t".repeat(2)).append("\n");
        }
        return textAreaTextSb.toString();
    }


}
