package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

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
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        //Knappar
        add(buttonPanel,BorderLayout.SOUTH);
        buttonPanel.add(newGameButton);
        buttonPanel.add(closeButton);

        //Spelet Grid CENTER
        add(gameBoardPanel,BorderLayout.CENTER);
        gameBoardPanel.setLayout(new GridLayout(4,4));

        //Skapar spel knappar, randomizear dom och skriver ut.
        //TODO storleken ska komma från input i Login Panel sen.
        ArrayList<JButton> gameButtons = createJButtonArrayList(15);
        gameButtons = randomizeButtons(gameButtons);
        printGameBoardButtons(gameButtons);

    }
    private ArrayList<JButton> createJButtonArrayList(int numberOfGameButtons){
        ArrayList<JButton> gameButtons = new ArrayList<>();
        for(int i = 0; i < numberOfGameButtons; i++){
            gameButtons.add(new JButton(String.valueOf(i+1)));
        }
        return gameButtons;
    }

    private void printGameBoardButtons(ArrayList<JButton> gameButtons){
        for(JButton button : gameButtons){
            gameBoardPanel.add(button);
        }
    }

    private ArrayList<JButton> randomizeButtons(ArrayList<JButton> buttons){
         Collections.shuffle(buttons);
         return buttons;
    }

}
