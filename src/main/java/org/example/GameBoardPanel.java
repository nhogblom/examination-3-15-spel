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
    ArrayList<JButton> gameButtons = createJButtonArrayList(15);

    GameBoardPanel(){
        setLayout(new BorderLayout());
        setVisible(true);

        //Text NORTH
        add(welcomeLabel,BorderLayout.NORTH);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        //Knappar
        add(buttonPanel,BorderLayout.SOUTH);
        buttonPanel.add(newGameButton);
        newGameButton.addActionListener(new NewGameButtonActionListener(gameBoardPanel));


        buttonPanel.add(closeButton);



        //Spelet Grid CENTER
        add(gameBoardPanel,BorderLayout.CENTER);
        gameBoardPanel.setLayout(new GridLayout(4,4));

        //Skapar spel knappar, randomizear dom och skriver ut.
        //TODO storleken ska komma från input i Login Panel sen.

        gameButtons = randomizeButtons(gameButtons);
        printGameBoardButtons(gameButtons);
        IO.println("Arrayer är lika (spelet är vunnet) = " + checkIfGameIsWon(gameButtons));
        for(JButton button : gameButtons){
            IO.print(" " + button.getText());
        }

    }

    private boolean checkIfGameIsWon(ArrayList<JButton> gameButtons){
        //TODO storleken ska komma från input i Login Panel.
        ArrayList<JButton> gameIsWonGameButtonsSort = createJButtonArrayList(15);
        int index = 0;
        for(JButton button : gameIsWonGameButtonsSort){
            if(!(button.getText().equals(gameButtons.get(index).getText()))){
                return false;
            }
            index++;
        }
        return true;
    }

    protected ArrayList<JButton> createJButtonArrayList(int numberOfGameButtons){
        ArrayList<JButton> gameButtons = new ArrayList<>();
        for(int i = 0; i < numberOfGameButtons; i++){
            gameButtons.add(new JButton(String.valueOf(i+1)));
        }
        return gameButtons;
    }

    protected void printGameBoardButtons(ArrayList<JButton> gameButtons){
        for(JButton button : gameButtons){
            gameBoardPanel.add(button);
        }
        gameBoardPanel.revalidate();
        gameBoardPanel.repaint();
    }

    protected ArrayList<JButton> randomizeButtons(ArrayList<JButton> buttons){
         Collections.shuffle(buttons);
         return buttons;
    }

    public ArrayList<JButton> getGameButtons() {
        return gameButtons;
    }

    public void setGameButtons(ArrayList<JButton> gameButtons) {
        this.gameButtons = gameButtons;
    }
}
