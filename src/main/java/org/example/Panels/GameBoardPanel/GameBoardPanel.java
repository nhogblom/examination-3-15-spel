package org.example.Panels.GameBoardPanel;

import org.example.GUI;
import org.example.OneFiveGame;
import org.example.Panels.HighscorePanel.Highscore;
import org.example.Panels.LoginPanel.LoginPanel;

import javax.swing.*;
import java.awt.*;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameBoardPanel extends JPanel {
    OneFiveGame ofg;
    JLabel welcomeLabel = new JLabel("Welcome to the game");
    JButton closeButton = new JButton("Close");
    JButton newGameButton = new JButton("New Game");
    JButton backButton = new JButton("Back");
    JPanel buttonPanel = new JPanel();
    JPanel gameBoardPanel = new JPanel();
    //win.png original size 768x768
    JLabel winningPicture = new JLabel(new ImageIcon(new ImageIcon("src/main/resources/win.png").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT)));
    JLabel moveCountLabel = new JLabel();
    JLabel timeLabel = new JLabel("Time: 00:00:10");
    public static ArrayList<JButton> gameButtons = new ArrayList<>();
    GUI gui;
    GameTimer gameTimer = new GameTimer(timeLabel);
    LocalTime elapsedTime;

    public GameBoardPanel(OneFiveGame ofg, GUI gui, LoginPanel previousPanel) {
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

        buttonPanel.add(backButton);
        backButton.addActionListener(e -> {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            frame.setContentPane(previousPanel);
            frame.revalidate();
            frame.repaint();
        });

        buttonPanel.add(closeButton);
        buttonPanel.add(timeLabel);
        closeButton.addActionListener(e -> gui.closeProgram());

        //Spelet Grid CENTER
        add(gameBoardPanel, BorderLayout.CENTER);

        gameBoardPanel.setLayout(new GridLayout(ofg.getGameBoardSizeX(), ofg.getGameBoardSizeY()));


        gameTimer.start();

        // display game
        printGameBoard();
    }

    private void newGame() {
        gameBoardPanel.removeAll();
        GameBoardPanel.gameButtons.clear();
        gameBoardPanel.setVisible(true);
        moveCountLabel.setText("");
        ofg = new OneFiveGame(ofg.getUsername(), ofg.getGameBoardSizeX(), ofg.getGameBoardSizeY(),ofg.getDifficulty());
        printGameBoard();
        gameBoardPanel.revalidate();
        gameBoardPanel.repaint();

        gameTimer.interrupt();
        gameTimer = new GameTimer(timeLabel);
        timeLabel.setText("Time: 00:00:00");
        gameTimer.start();
    }


    private void printGameBoard() {
        List<Integer> gameBoard = ofg.getGameBoard();
        for (int i = 0; i < gameBoard.size(); i++) {
            JButton curButton;
            if (gameBoard.get(i) == 0) {
                curButton = new JButton("");
            } else {
                curButton = new JButton(String.valueOf(gameBoard.get(i)));
                if (!ofg.isGameWon()) {
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

        ofg.moveNumber(number);
        gameBoardPanel.removeAll();
        GameBoardPanel.gameButtons.clear();
        printGameBoard();
        moveCountLabel.setText("Moves: " + String.valueOf(ofg.getMoveCounter()));
        gameBoardPanel.revalidate();
        gameBoardPanel.repaint();
        if (ofg.isGameWon()) {
            elapsedTime = gameTimer.getGameTime();
            gameTimer.interrupt();
            partyColorCelebration();
        }
    }

    private void addNewHighScore() {
        if (!ofg.getUsername().equalsIgnoreCase("Demo")){
            new Highscore(ofg.getUsername(), ofg.getMoveCounter(),ofg.getDifficulty(),elapsedTime);
        }
    }

    private void printWinningScreenAndSetHighScore() {
        // show winning screen and set hightscore.
        addNewHighScore();
        gameBoardPanel.setVisible(false);
        add(winningPicture, BorderLayout.CENTER);
        winningPicture.setVisible(true);
        revalidate();
        repaint();
    }

    private Color randomColor() {
        Random r = new Random();
        return new Color(r.nextInt(256), r.nextInt(256), r.nextInt(256));
    }

    private void partyColorCelebration() {
        final int maxTicks = 20;   // antal gånger
        final int[] ticks = {0};   // räknare

        Timer t = new Timer(300, e -> {
            // Change color of all game buttons
            for (JButton b : gameButtons) {
                b.setOpaque(true);
                b.setContentAreaFilled(true);
                b.setBackground(randomColor());
            }

            ticks[0]++;

            // Stop when max ticks are achieved.
            if (ticks[0] >= maxTicks) {
                ((Timer) e.getSource()).stop();
                printWinningScreenAndSetHighScore();
            }
        });

        t.setInitialDelay(0);
        t.start();
    }

}

