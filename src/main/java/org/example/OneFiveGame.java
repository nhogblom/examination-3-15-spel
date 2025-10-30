package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OneFiveGame {
    private List<Integer> gameBoard = new ArrayList<>();
    private int gameBoardSizeX;
    private int gameBoardSizeY;
    private int amountOfBoardTiles;
    private boolean isDemo = false;
    private boolean currentGameWon = false;
    private String username;


    public OneFiveGame(String username, int gameBoardSizeX, int gameBoardSizeY) {
        this.username = username;
        this.gameBoardSizeX = gameBoardSizeX;
        this.gameBoardSizeY = gameBoardSizeY;
        this.amountOfBoardTiles = gameBoardSizeX * gameBoardSizeY;
        createGameBoard();
    }

    public OneFiveGame(boolean isDemo) {
        this.isDemo = isDemo;
        createGameBoard();
    }

    public void createGameBoard() {
        if (isDemo) {
            // one move to win demo.
            gameBoardSizeX = 2;
            gameBoardSizeY = 2;
            amountOfBoardTiles = gameBoardSizeX * gameBoardSizeY;
            gameBoard.add(1);
            gameBoard.add(0);
            gameBoard.add(3);
            gameBoard.add(2);
        } else {
            for (int i = 0; i < amountOfBoardTiles; i++) {
                gameBoard.add(i);
            }
            Collections.shuffle(gameBoard);
        }
    }

    public void move(int numberToMove) {
        int whereToMove = isMovePossibleAndWhereTo(numberToMove);
        int whereWeAreMovingFrom = gameBoard.indexOf(numberToMove);
        if (whereToMove != -1) {
            gameBoard.set(whereToMove, numberToMove);
            gameBoard.set(whereWeAreMovingFrom, 0);
            setIfGameIsWon();
        }
    }

    private void setIfGameIsWon() {
        if (gameBoard.getLast() == 0) {
            for (int i = 0; i < gameBoard.size(); i++) {
                if (gameBoard.get(i) == 0) {
                    this.currentGameWon = true;
                } else if (gameBoard.get(i) != (i + 1)) {
                    this.currentGameWon = false;
                    break;
                }
            }
        }
    }

    public boolean isCurrentGameWon() {
        return currentGameWon;
    }

    private int isMovePossibleAndWhereTo(int numberToMove) {
        // index of the number that we want to move.
        int numberToMoveIndex = gameBoard.indexOf(numberToMove);
        // index of the empty field.
        int indexOfZero = indexOfZero();
        // row & col number of the number we want to move
        int numberRow = numberToMoveIndex / gameBoardSizeX;
        int numberCol = numberToMoveIndex % gameBoardSizeX;

        // check if movement to the left is possible if the tile is empty.
        if (numberCol - 1 >= 0) {
            int indexWest = ((numberRow * gameBoardSizeX) + numberCol - 1);
            if (indexWest == indexOfZero) {
                return indexWest;
            }
        }

        // check if movement to the right..
        if (numberCol + 1 <= gameBoardSizeX - 1) {
            int indexEast = ((numberRow * gameBoardSizeX) + numberCol + 1);
            if (indexEast == indexOfZero) {
                return indexEast;
            }
        }

        // check if movement up is possible....~
        if (numberRow - 1 >= 0) {
            int indexNorth = (numberToMoveIndex - gameBoardSizeX);
            if (indexNorth == indexOfZero) {
                return indexNorth;
            }
        }

        // check if movment down...
        if (numberRow + 1 <= gameBoardSizeY - 1) {
            int indexSouth = (numberToMoveIndex + gameBoardSizeX);
            if (indexSouth == indexOfZero) {
                return indexSouth;
            }
        }

        // if no movement was possible return -1
        return -1;
    }

    private int indexOfZero() {
        return gameBoard.indexOf(0);
    }

    public List<Integer> getGameBoard() {
        return gameBoard;
    }

    public int getGameBoardSizeX() {
        return gameBoardSizeX;
    }

    public int getGameBoardSizeY() {
        return gameBoardSizeY;
    }

    public String getUsername() {
        return username;
    }

    public void printGameBoardToTerminal() {
        for (int i = 0; i < gameBoardSizeY; i++) {
            for (int j = 0; j < gameBoard.size() / gameBoardSizeX; j++) {
                System.out.print("[" + gameBoard.get((i * gameBoardSizeX) + j) + "]");
            }
            System.out.println("\n");
        }
    }

    public void getTerminalPickFromUser() {
        String tokenToMove = IO.readln("Skriv in den siffra du vill flytta: ");
        int tokenToMoveInt = Integer.parseInt(tokenToMove);
        move(tokenToMoveInt);
    }

}
