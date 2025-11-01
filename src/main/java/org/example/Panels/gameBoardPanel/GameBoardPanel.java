package org.example.Panels.gameBoardPanel;

import org.example.GUI;
import org.example.OneFiveGame;
import org.example.Panels.HighscorePanel.Highscore;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoardPanel extends JPanel {
    OneFiveGame ofg;
    JLabel welcomeLabel = new JLabel("Welcome to the game");
    JButton closeButton = new JButton("Close");
    JButton newGameButton = new JButton("New Game");
    JPanel buttonPanel = new JPanel();
    JPanel gameBoardPanel = new JPanel();
    //todo se till att width och height blir korrekt, orignal bilden är 768x768~
    JLabel winningPicture = new JLabel(new ImageIcon(new ImageIcon("src/main/resources/win.png").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT)));
    JLabel moveCountLabel = new JLabel();
    public static ArrayList<JButton> gameButtons = new ArrayList<>();
    GUI gui;


    public GameBoardPanel(OneFiveGame ofg, GUI gui) {
        this.ofg = ofg;
        this.gui = gui;
        setLayout(new BorderLayout());
        setVisible(true);

        //Text NORTH
        add(welcomeLabel, BorderLayout.NORTH);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        //Knappar
        add(buttonPanel, BorderLayout.SOUTH);
        buttonPanel.add(moveCountLabel);
        buttonPanel.add(newGameButton);
        newGameButton.addActionListener(e -> {
            newGame();
        });
        buttonPanel.add(closeButton);

        closeButton.addActionListener(e -> gui.closeProgram());

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
        moveCountLabel.setText("");
        ofg = new OneFiveGame(ofg.getUsername(), ofg.getGameBoardSizeX(), ofg.getGameBoardSizeY());
        printGameBoard();
        gameBoardPanel.revalidate();
        gameBoardPanel.repaint();
    }


    private void printGameBoard() {
        List<Integer> gameBoard = ofg.getGameBoard();
        for (int i = 0; i < gameBoard.size(); i++) {
            JButton curButton;
            if (gameBoard.get(i) == 0) {
                curButton = new JButton("");
            } else {
                curButton = new JButton(String.valueOf(gameBoard.get(i)));
                if (!ofg.isCurrentGameWon()) {
                    curButton.addActionListener(e -> {
                        moveAndRepaint(Integer.parseInt(curButton.getText()));
                    });
                }
            }
            gameButtons.add(curButton);
            gameBoardPanel.add(curButton);
        }
    }


    private void moveAndRepaint(int number) {

        ofg.move(number);
        gameBoardPanel.removeAll();
        GameBoardPanel.gameButtons.clear();
        printGameBoard();
        moveCountLabel.setText("Moves: " + String.valueOf(ofg.getMoveCounter()));
        gameBoardPanel.revalidate();
        gameBoardPanel.repaint();
        if (ofg.isCurrentGameWon()) {
            partyColorCelebration();
        }
    }

    private void addNewHighScore() {
        //TODO här kan man lägga till kontroll ifall det är ny Highscore
        if (!ofg.getUsername().equals("Demo") || ofg.getUsername().isEmpty()){
            new Highscore(ofg.getUsername(), ofg.getMoveCounter());
        }
    }

    private void printWinningScreen() {
        //todo här kan vi lägga till vinster med mera till highscore~


        addNewHighScore();
        gameBoardPanel.setVisible(false);
        // sätter en vinstskärm
        add(winningPicture, BorderLayout.CENTER);
        winningPicture.setVisible(true);
        revalidate();
        repaint();
        //todo ta bort denna och inkludera istället getMoveCounter till lagring av highscore~
        // testar move counter
        System.out.println("Du vann på " + ofg.getMoveCounter() + " steg.");
    }

    private Color randomColor() {
        Random rng = new Random();
        return new Color(rng.nextInt(256), rng.nextInt(256), rng.nextInt(256));
    }

    private void partyColorCelebration() {
        final int maxTicks = 20;   // antal gånger
        final int[] ticks = {0};   // räknare

        Timer t = new Timer(300, e -> {
            // Byt färg på alla knappar
            for (JButton b : gameButtons) {
                b.setOpaque(true);
                b.setContentAreaFilled(true);
                b.setBackground(randomColor());
            }

            ticks[0]++;

            // När vi nått max, stoppa timern och byt skärm till vinstskärmen.
            if (ticks[0] >= maxTicks) {
                ((Timer) e.getSource()).stop();
                printWinningScreen();
            }
        });

        t.setInitialDelay(0);
        t.start();
    }

}

