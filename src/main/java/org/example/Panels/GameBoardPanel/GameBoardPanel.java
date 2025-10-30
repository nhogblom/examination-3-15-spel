package org.example.Panels.GameBoardPanel;

import org.example.OneFiveGame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
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
    //todo se till att width och height blir korrekt
    JLabel winningPicture = new JLabel(new ImageIcon(new ImageIcon("src/main/resources/win.png").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT)));
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
        newGameButton.addActionListener(e -> { newGame(); });
        buttonPanel.add(closeButton);
        closeButton.addActionListener(e -> {
            System.exit(0);
        });

        //Spelet Grid CENTER
        add(gameBoardPanel, BorderLayout.CENTER);

        //todo se till att användardata sätter spelets storlek
//        gameBoardPanel.setLayout(new GridLayout(4, 4));
        gameBoardPanel.setLayout(new GridLayout(2, 2));

        // display game
        printGameBoard();
    }

    public void newGame() {
        gameBoardPanel.removeAll();
        GameBoardPanel.gameButtons.clear();
        gameBoardPanel.setVisible(true);
        // todo ändra så att den tar input från gui för att skapa rätt storlek av spelet.
        // todo se även till att användardata så som användarnamn förs vidare till det nya spelet.
        ofg = new OneFiveGame(2, 2);
        printGameBoard();
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


    public void printGameBoard() {
        List<Integer> gameBoard = ofg.getGameBoard();
        for (int i = 0; i < gameBoard.size(); i++) {
            JButton curButton;
            if (gameBoard.get(i) == 0) {
                curButton = new JButton("");
            }else {
                curButton = new JButton(String.valueOf(gameBoard.get(i)));
                curButton.addActionListener(e -> {
                    moveAndRepaint(Integer.parseInt(curButton.getText()));
                });
            }
            gameBoardPanel.add(curButton);
        }
    }


    private void moveAndRepaint(int number) {
        ofg.move(number);
        gameBoardPanel.removeAll();
        GameBoardPanel.gameButtons.clear();
        printGameBoard();
        gameBoardPanel.revalidate();
        gameBoardPanel.repaint();
        if (ofg.isCurrentGameWon()) {
            printWinningScreen();
        }
    }

    public void printWinningScreen(){
        gameBoardPanel.setVisible(false);
        // sätter en vinstskärm
        add(winningPicture, BorderLayout.CENTER);
        winningPicture.setVisible(true);
        revalidate();
        repaint();
    }

}
