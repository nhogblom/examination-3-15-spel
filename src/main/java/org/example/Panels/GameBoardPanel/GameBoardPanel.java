package org.example.Panels.GameBoardPanel;

import org.example.OneFiveGame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class GameBoardPanel extends JPanel {

    // todo ändra så att den tar input från gui för att skapa rätt storlek av spelet.
//    OneFiveGame ofg = new OneFiveGame(4, 4);
    OneFiveGame ofg = new OneFiveGame(true);

    JLabel welcomeLabel = new JLabel("Welcome to the game");
    JButton closeButton = new JButton("Close");
    JButton newGameButton = new JButton("New Game");
    JPanel buttonPanel = new JPanel();
    JPanel gameBoardPanel = new JPanel();
    JLabel winningPicture = new JLabel(new ImageIcon("src/main/resources/win.png"));
    public static ArrayList<JButton> gameButtons = new ArrayList<>();

    public GameBoardPanel() {
        setLayout(new BorderLayout());
        setVisible(true);

        //Text NORTH
        add(welcomeLabel, BorderLayout.NORTH);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        //Knappar
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(newGameButton);
        // ändrade från listener class till lambda
//        newGameButton.addActionListener(new NewGameButtonActionListener(gameBoardPanel));
        newGameButton.addActionListener(e -> {
            newGame();
        });


        buttonPanel.add(closeButton);
        closeButton.addActionListener(e -> {
            System.exit(0);
        });


        //Spelet Grid CENTER
        add(gameBoardPanel, BorderLayout.CENTER);




//        gameBoardPanel.setLayout(new GridLayout(4, 4));
        gameBoardPanel.setLayout(new GridLayout(2, 2));

        //Skapar spel knappar, randomizear dom och skriver ut.
        //TODO storleken ska komma från input i Login Panel sen.

        //createJButtonArrayList(15);

        printGameBoardButtons();
//        IO.println("Arrayer är lika (spelet är vunnet) = " + checkIfGameIsWon(gameButtons));


    }

    public void newGame() {
        gameBoardPanel.removeAll();
        GameBoardPanel.gameButtons.clear();
        gameBoardPanel.setVisible(true);
        // todo ändra så att den tar input från gui för att skapa rätt storlek av spelet.
        ofg = new OneFiveGame(2, 2);
        printGameBoardButtons();
        gameBoardPanel.revalidate();
        gameBoardPanel.repaint();
    }

    private boolean checkIfGameIsWon(ArrayList<JButton> gameButtons) {
        //TODO storleken ska komma från input i Login Panel.
        ArrayList<JButton> gameIsWonGameButtonsSort = new ArrayList<>();
        for (int i = 0; i < gameButtons.size(); i++) {
            gameIsWonGameButtonsSort.add(new JButton(String.valueOf(i + 1)));
        }
        int index = 0;
        for (JButton button : gameIsWonGameButtonsSort) {
            if (!(button.getText().equals(gameButtons.get(index).getText()))) {
                return false;
            }
            index++;
        }
        return true;
    }


    public void printGameBoardButtons() {
        List<Integer> gameBoard = ofg.getGameBoard();
        for (int i = 0; i < gameBoard.size(); i++) {
            JButton curButton = new JButton(String.valueOf(gameBoard.get(i)));
            if (!ofg.isCurrentGameWon()) {
                curButton.addActionListener(e -> {
                    moveAndRepaint(Integer.parseInt(curButton.getText()));
                });
            }else{
                gameBoardPanel.setVisible(false);
                // sätter en vinstskärm
                add(winningPicture, BorderLayout.CENTER);
                winningPicture.setVisible(true);

            }
            gameBoardPanel.add(curButton);
        }
    }

    private void moveAndRepaint(int number) {
        ofg.move(number);
        gameBoardPanel.removeAll();
        GameBoardPanel.gameButtons.clear();
        printGameBoardButtons();
        gameBoardPanel.revalidate();
        gameBoardPanel.repaint();
        if (ofg.isCurrentGameWon()) {
            System.out.println("GAME IS WON");
        }
    }

}
