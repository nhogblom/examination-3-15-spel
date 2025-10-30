package org.example.Panels.GameBoardPanel;

import org.example.OneFiveGame;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class GameBoardPanel extends JPanel {
    OneFiveGame ofg;
    JLabel welcomeLabel = new JLabel("Welcome to the game");
    JButton closeButton = new JButton("Close");
    JButton newGameButton = new JButton("New Game");
    JPanel buttonPanel = new JPanel();
    JPanel gameBoardPanel = new JPanel();
    //todo se till att width och height blir korrekt, orignal bilden är 768x768~
    JLabel winningPicture = new JLabel(new ImageIcon(new ImageIcon("src/main/resources/win.png").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT)));
    public static ArrayList<JButton> gameButtons = new ArrayList<>();



    public GameBoardPanel(OneFiveGame ofg) {
        this.ofg = ofg;
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


        gameBoardPanel.setLayout(new GridLayout(ofg.getGameBoardSizeX(), ofg.getGameBoardSizeY()));

        // display game
        printGameBoard();
    }

    private void newGame() {
        gameBoardPanel.removeAll();
        GameBoardPanel.gameButtons.clear();
        gameBoardPanel.setVisible(true);
        // todo ändra så att den tar input från gui för att skapa rätt storlek av spelet.
        // todo se även till att användardata så som användarnamn förs vidare till det nya spelet.
        ofg = new OneFiveGame("användarnamn",2, 2);
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


    private void printGameBoard() {
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

    private void printWinningScreen(){
        gameBoardPanel.setVisible(false);
        // sätter en vinstskärm
        add(winningPicture, BorderLayout.CENTER);
        winningPicture.setVisible(true);
        revalidate();
        repaint();
    }

}
