package org.example.Panels.HighscorePanel;

import javax.swing.*;
import java.awt.*;
import java.sql.Time;
import java.util.ArrayList;

public class HighscorePanel extends JPanel {

    JPanel labelPanel = new JPanel();
    JLabel highscoreLabel = new JLabel("Highscore");
    JLabel descriptionLabel = new JLabel("Name \tTurns\ttime");

    JPanel highscorePanel = new JPanel();

    JPanel buttonPanel = new JPanel();
    JButton backButton = new JButton("Back");



    HighscorePanel() {

        ArrayList<Highscore> hlist = new ArrayList<Highscore>();
        //TODO just for testing, remove
        Highscore h1 = new Highscore("Ivan",10);
        Highscore h2 = new Highscore("Niklas",5);
        Highscore h3 = new Highscore("Peter",12);
        Highscore h4 = new Highscore("Pelle",15);
        hlist.add(h1);
        hlist.add(h2);
        hlist.add(h3);
        hlist.add(h4);


        setLayout(new BorderLayout());

        add(labelPanel,BorderLayout.NORTH);
        labelPanel.setLayout(new GridLayout(2,1));
        labelPanel.add(highscoreLabel);
        labelPanel.add(descriptionLabel);
        highscoreLabel.setHorizontalAlignment(JLabel.CENTER);
        descriptionLabel.setHorizontalAlignment(JLabel.CENTER);

        add(highscorePanel,BorderLayout.CENTER);
        highscorePanel.setLayout(new GridLayout(10,3));
        //TODO ändra så att det blir antalet size of Highscore objects istället för hårdkod
        for(Highscore highscore : hlist){
            highscorePanel.add(new JLabel(highscore.getName() + "\t" + highscore.getTurns()));
        }

        add(buttonPanel,BorderLayout.SOUTH);
        buttonPanel.add(backButton);

    }

}
