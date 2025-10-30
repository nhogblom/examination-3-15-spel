package org.example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OneFiveGame {
    private List<Integer> GameBoard = new ArrayList<>();
    private int gameBoardSizeX;
    private int gameBoardSizeY;
    private int amountOfBoardTiles;
    private boolean isDemo = false;
    private boolean currentGameWon = false;


    public OneFiveGame(int gameBoardSizeX, int gameBoardSizeY) {
        this.gameBoardSizeX = gameBoardSizeX;
        this.gameBoardSizeY = gameBoardSizeY;
        this.amountOfBoardTiles = gameBoardSizeX * gameBoardSizeY;
        createGameBoard();
    }

    public OneFiveGame(boolean isDemo) {
        this.isDemo = isDemo;
        createGameBoard();
    }

    private void checkIfGameIsWon() {
        if (GameBoard.getLast() == 0) {
            for (int i = 0; i < GameBoard.size(); i++) {
                if (GameBoard.get(i) == 0) {
                    this.currentGameWon = true;
                    System.out.println("Game Won");
                }else if (GameBoard.get(i) != (i+1)) {
                    this.currentGameWon = false;
                    break;
                }
            }
        }
    }

    public void createGameBoard() {
        if (isDemo) {
            // one move to win demo.
            gameBoardSizeX = 2;
            gameBoardSizeY = 2;
            amountOfBoardTiles = gameBoardSizeX * gameBoardSizeY;
            GameBoard.add(1);
            GameBoard.add(0);
            GameBoard.add(3);
            GameBoard.add(2);
        } else {
            for (int i = 0; i < amountOfBoardTiles; i++) {
                GameBoard.add(i);
            }
            Collections.shuffle(GameBoard);
        }
    }

    public void move(int numberToMove) {
        int whereToMove = isMovePossibleAndWhereTo(numberToMove);
        int whereWeAreMovingFrom = GameBoard.indexOf(numberToMove);
        if (whereToMove != -1) {
            GameBoard.set(whereToMove, numberToMove);
            GameBoard.set(whereWeAreMovingFrom, 0);
        }
    }

    private int indexOfZero() {
        return GameBoard.indexOf(0);
    }


    public int isMovePossibleAndWhereTo(int numberToMove) {
        int numberToMoveIndex = GameBoard.indexOf(numberToMove);
        int indexOfZero = indexOfZero();
        int numberRow = numberToMoveIndex / gameBoardSizeX;
        int numberCol = numberToMoveIndex % gameBoardSizeX;
        if (numberCol - 1 >= 0) {
            int indexWest = ((numberRow * gameBoardSizeX) + numberCol - 1);
            if (indexWest == indexOfZero) {
                return indexWest;
            }
        }
        if (numberRow - 1 >= 0) {
            int indexNorth = (numberToMoveIndex - gameBoardSizeX);
            if (indexNorth == indexOfZero) {
                return indexNorth;
            }
        }

        if (numberRow + 1 <= gameBoardSizeY - 1) {
            int indexSouth = (numberToMoveIndex + gameBoardSizeX);
            if (indexSouth == indexOfZero) {
                return indexSouth;
            }
        }
        if (numberCol + 1 <= gameBoardSizeX - 1) {
            int indexEast = ((numberRow * gameBoardSizeX) + numberCol + 1);
            if (indexEast == indexOfZero) {
                return indexEast;
            }
        }
        return -1;
    }


    public void printGameBoardToTerminal() {
        for (int i = 0; i < gameBoardSizeY; i++) {
            for (int j = 0; j < GameBoard.size() / gameBoardSizeX; j++) {
                System.out.print("[" + GameBoard.get((i * gameBoardSizeX) + j) + "]");
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
