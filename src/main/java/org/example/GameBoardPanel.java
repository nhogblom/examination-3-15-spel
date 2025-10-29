package org.example;

import javax.swing.*;
import java.awt.*;

public class GameBoardPanel extends JPanel {

    JLabel welcomeLabel = new JLabel("Welcome to the game");
    JButton closeButton = new JButton("Close");
    JButton newGameButton = new JButton("New Game");
    JPanel buttonPanel = new JPanel();
    JPanel gameBoardPanel = new JPanel();

    GameBoardPanel(){
        setLayout(new BorderLayout());
        setVisible(true);

        //Text NORTH
        add(welcomeLabel,BorderLayout.NORTH);

        //Knappar
        add(buttonPanel,BorderLayout.SOUTH);
        buttonPanel.add(newGameButton);
        buttonPanel.add(closeButton);

        //Spelet Grid CENTER
        add(gameBoardPanel,BorderLayout.CENTER);
        gameBoardPanel.setLayout(new GridLayout(4,4));
        for(int i = 0; i < 16; i++){
            new JButton(String.valueOf(i+1));
        }






    }


}
