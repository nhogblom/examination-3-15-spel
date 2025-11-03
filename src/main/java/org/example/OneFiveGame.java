package org.example;

import org.example.Enums.Difficulty;

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
    private int moveCounter = 0;
    private String difficulty;
    private List<Change> changes = new ArrayList<>();

    public String getDifficulty() {
        return difficulty;
    }

    public OneFiveGame(String username, int gameBoardSizeX, int gameBoardSizeY, String difficulty) {
        if (username.equals("Demo")) {
            this.isDemo = true;
        }
        this.username = username;
        this.gameBoardSizeX = gameBoardSizeX;
        this.gameBoardSizeY = gameBoardSizeY;
        this.difficulty = difficulty;
        this.amountOfBoardTiles = gameBoardSizeX * gameBoardSizeY;
        createGameBoard();
    }


    public void createGameBoard() {
        if (isDemo) {
            // one move to win demo.
            gameBoardSizeX = 4;
            gameBoardSizeY = 4;
            amountOfBoardTiles = gameBoardSizeX * gameBoardSizeY;
            gameBoard.add(1);
            gameBoard.add(2);
            gameBoard.add(3);
            gameBoard.add(4);
            gameBoard.add(5);
            gameBoard.add(6);
            gameBoard.add(7);
            gameBoard.add(8);
            gameBoard.add(9);
            gameBoard.add(10);
            gameBoard.add(11);
            gameBoard.add(12);
            gameBoard.add(13);
            gameBoard.add(14);
            gameBoard.add(0);
            gameBoard.add(15);
        } else {
            for (int i = 0; i < amountOfBoardTiles; i++) {
                gameBoard.add(i);
            }
            do {
                Collections.shuffle(gameBoard);
            } while (!isSolvable(gameBoard));
        }
        System.out.println(isSolvable(gameBoard));
    }

    public void move(int numberToMove) {
        int whereToMove = isMovePossibleAndWhereTo(numberToMove);
        int whereWeAreMovingFrom = gameBoard.indexOf(numberToMove);

        if (whereToMove != -1) {
            //If double move to the right is possible
            if (whereToMove - 2 == whereWeAreMovingFrom && !difficulty.equals("Easy")) {
                IO.println("hamnar i move right double");
                int midNumber = gameBoard.get(whereWeAreMovingFrom + 1);
                gameBoard.set(whereWeAreMovingFrom + 1, numberToMove);
                gameBoard.set(whereToMove, midNumber);
                gameBoard.set(whereWeAreMovingFrom, 0);
                moveCounter += 2;

                //If double move to the left is possible
            } else if (whereToMove + 2 == whereWeAreMovingFrom && !difficulty.equals("Easy")) {
                IO.println("hamnar i move left double");
                int midNumber = gameBoard.get(whereWeAreMovingFrom - 1);
                gameBoard.set(whereWeAreMovingFrom - 1, numberToMove);
                gameBoard.set(whereToMove, midNumber);
                gameBoard.set(whereWeAreMovingFrom, 0);
                moveCounter += 2;

                //If double move down is possible
            } else if (whereToMove - gameBoardSizeX * 2 == whereWeAreMovingFrom && !difficulty.equals("Easy")) {
                IO.println("hamnar i move down double");
                int midNumber = gameBoard.get(whereWeAreMovingFrom + gameBoardSizeX);
                gameBoard.set(whereWeAreMovingFrom + gameBoardSizeX, numberToMove);
                gameBoard.set(whereToMove, midNumber);
                gameBoard.set(whereWeAreMovingFrom, 0);
                moveCounter += 2;
            }
            // if double move up is possible
            else if (whereToMove + gameBoardSizeX * 2 == whereWeAreMovingFrom && !difficulty.equals("Easy")) {
                IO.println("hamnar i move up double");
                int midNumber = gameBoard.get(whereWeAreMovingFrom - gameBoardSizeX);
                gameBoard.set(whereWeAreMovingFrom - gameBoardSizeX, numberToMove);
                gameBoard.set(whereToMove, midNumber);
                gameBoard.set(whereWeAreMovingFrom, 0);
                moveCounter += 2;
            } else {
                IO.println("vi är på rätt ställe men det blir fel ändå");
                gameBoard.set(whereToMove, numberToMove);
                gameBoard.set(whereWeAreMovingFrom, 0);
                moveCounter++;
                setIfGameIsWon();
            }
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


    private List<Change> isMovePossibleAndWhereTo(int numberToMove) {
        List<Change> changes = new ArrayList<>();
        // index of the number that we want to move.
        int numberToMoveIndex = gameBoard.indexOf(numberToMove);
        // index of the empty field.
        int indexOfZero = indexOfZero();
        // row & col number of the number we want to move
        int numberRow = numberToMoveIndex / gameBoardSizeX;
        int numberCol = numberToMoveIndex % gameBoardSizeX;

        IO.print("Number to move: " + numberToMoveIndex + "\nNumberrow: " + numberRow + "\nNumberCol: " + numberCol + "\nIndexOfZero: " + indexOfZero);

        // check if movement to the left is possible if the tile is empty.

        int numberOfMoves;
        for (int i = 1; i <= 2; i++) {
            numberOfMoves = i;
        if (numberCol - numberOfMoves >= 0) {
            int targetIndexWest = ((numberRow * gameBoardSizeX) + numberCol - numberOfMoves);
            if (targetIndexWest == indexOfZero) {
                if (numberOfMoves == 1){
                    changes.add(new Change(numberToMoveIndex,indexOfZero));
                    changes.add(new Change(indexOfZero,numberToMoveIndex));
                }else if(numberOfMoves == 2){
                    int midTileIndex = gameBoard.get(targetIndexWest + 1);
                    changes.add(new Change(indexOfZero,midTileIndex));
                    changes.add(new Change(indexOfZero,numberToMoveIndex));
                    changes.add(new Change(indexOfZero,numberToMoveIndex));

                }
                return targetIndexWest;
            }
        }

        // check if movement to the right..
        if (numberCol + numberOfMoves <= gameBoardSizeX - 1) {
            int targetIndexEast = ((numberRow * gameBoardSizeX) + numberCol + numberOfMoves);
            if (targetIndexEast == indexOfZero) {
                // add changes appropriate for a one or two move change.
                return targetIndexEast;
            }
        }

        // check if movement up is possible....~
        if (numberRow - numberOfMoves >= 0) {
            int targetIndexNorth = (numberToMoveIndex - gameBoardSizeX * numberOfMoves);
            if (targetIndexNorth == indexOfZero) {
                // add changes appropriate for a one or two move change.
                return targetIndexNorth;
            }
        }

        // check if movment down...
        if (numberRow + numberOfMoves <= gameBoardSizeY - 1) {
            int targetIndexSouth = (numberToMoveIndex + gameBoardSizeX * numberOfMoves);
            if (targetIndexSouth == indexOfZero) {
                // add changes appropriate for a one or two move change.
                return targetIndexSouth;
            }
        }
        }

        // if no movement was possible return -1
        IO.println("no movement possible");
        return changes
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

    public int getMoveCounter() {
        return moveCounter;
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

    private boolean isSolvable(List<Integer> gameBoard) {
        int inversions = 0;
        boolean evenColumns = gameBoardSizeX % 2 == 0;
        int rowOfZeroFromTheBottom = gameBoardSizeY - (gameBoard.indexOf(0) / gameBoardSizeX);
        boolean zeroIsOnAUnevenRowFromTheBottom = rowOfZeroFromTheBottom % 2 == 1;

        // räkna antalet inversions
        for (int i = 0; i < gameBoard.size(); i++) {
            for (int j = i + 1; j < gameBoard.size(); j++) {
                if (gameBoard.get(i) != 0 && gameBoard.get(j) != 0 && gameBoard.get(i) > gameBoard.get(j)) {
                    inversions++;
                }
            }
        }

        // beroende på spelets antal av kolumner samt position av 0 samt antalet av inversions kontrollera om spelet är lösbart~
        boolean inversionsEven = inversions % 2 == 0;
        if (!evenColumns && inversionsEven) {
            return true;
        } else if (evenColumns && zeroIsOnAUnevenRowFromTheBottom && inversionsEven) {
            return true;
        } else if (evenColumns && !zeroIsOnAUnevenRowFromTheBottom && !inversionsEven) {
            return true;
        } else {
            return false;
        }
    }
}

