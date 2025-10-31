package org.example.Panels.HighscorePanel;

import org.example.Panels.HighscorePanel.ButtonActionListener.BackButtonActionListener;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;

public class HighscorePanel extends JPanel {

    JLabel highscoreLabel = new JLabel("Highscore");
    JTextArea highScoreTextArea = new JTextArea();

    JPanel buttonPanel = new JPanel();
    JButton backButton = new JButton("Back");



    public HighscorePanel() {

        ArrayList<Highscore> hlist = new ArrayList<Highscore>();
        //TODO just for testing, remove denna lista borde finnas i OneFiveGame..
        // Vid vunnet game lägger den till en entry och sedan håller den koll på via serialisering och de serial
        Highscore h1 = new Highscore("Ivan",10);
        Highscore h2 = new Highscore("Niklas",5);
        Highscore h3 = new Highscore("Peter",12);
        Highscore h4 = new Highscore("Pelle",15);
        hlist.add(h1);
        hlist.add(h2);
        hlist.add(h3);
        hlist.add(h4);


        setLayout(new BorderLayout());

        add(highscoreLabel,BorderLayout.NORTH);
        highscoreLabel.setHorizontalAlignment(SwingConstants.CENTER);

        //TODO GÖRA EN TEXT AREA FÖR HIGHSCORE OCH GÖRA DEN TRANSPARENT

        StringBuilder textAreaTextSb = new StringBuilder();
        textAreaTextSb.append("Name").append("\t".repeat(2))
                .append("Turns").append("\t".repeat(2))
                .append("Time").append("\t".repeat(2)).append("\n");

        for(Highscore highscore : hlist){
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
        backButton.addActionListener(new BackButtonActionListener(this));



    }

}
