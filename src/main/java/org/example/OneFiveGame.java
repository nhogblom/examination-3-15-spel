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
    private int moveCounter = 0;
    private String difficulty;

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
        List<Change> changes = getChangesToMove(numberToMove);

        for (int i = 0; i < changes.size(); i++) {
            gameBoard.set(changes.get(i).getFrom(), changes.get(i).getTo());
        }
        if (changes.size() == 3) {
            moveCounter += 2;
        }else if (changes.size() == 2) {
            moveCounter++;
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


private List<Change> getChangesToMove(int numberToMove) {
    List<Change> changes = new ArrayList<>();
    // index of the number that we want to move.
    int numberToMoveIndex = gameBoard.indexOf(numberToMove);
    // index of the empty field.
    int indexOfZero = indexOfZero();
    // row & col number of the number we want to move
    int numberRow = numberToMoveIndex / gameBoardSizeX;
    int numberCol = numberToMoveIndex % gameBoardSizeX;


    int numberOfMoves = 0;
    int directionalOffset = 0;
    int directionalOffsetToMidTileFromZero = 0;

    for (int i = 1; i <= 2 && directionalOffset == 0; i++) {
        numberOfMoves = i;

        // west possible
        if (numberCol - numberOfMoves >= 0) {
            int targetIndexWest = ((numberRow * gameBoardSizeX) + numberCol - numberOfMoves);
            if (targetIndexWest == indexOfZero) {
                directionalOffset = -1 * numberOfMoves;
                directionalOffsetToMidTileFromZero = +1;
                i = 100;
            }
        }

        // right possible
        if (numberCol + numberOfMoves <= gameBoardSizeX - 1) {
            int targetIndexEast = ((numberRow * gameBoardSizeX) + numberCol + numberOfMoves);
            if (targetIndexEast == indexOfZero) {
                directionalOffset = 1 * numberOfMoves;
                directionalOffsetToMidTileFromZero = -1;
            }
        }

        // north possible
        if (numberRow - numberOfMoves >= 0) {
            int targetIndexNorth = (numberToMoveIndex - gameBoardSizeX * numberOfMoves);
            if (targetIndexNorth == indexOfZero) {
                directionalOffset = -gameBoardSizeX * numberOfMoves;
                directionalOffsetToMidTileFromZero = 1 * gameBoardSizeX;
            }
        }

        // south possible
        if (numberRow + numberOfMoves <= gameBoardSizeY - 1) {
            int targetIndexSouth = (numberToMoveIndex + gameBoardSizeX * numberOfMoves);
            if (targetIndexSouth == indexOfZero) {
                directionalOffset = gameBoardSizeX * numberOfMoves;
                directionalOffsetToMidTileFromZero = -1 * gameBoardSizeX;
            }
        }
    }

    // create moves based on directional offsets
    if (directionalOffset != 0) {
        if (numberOfMoves == 1) {
            changes.add(new Change(numberToMoveIndex, 0));
            changes.add(new Change(indexOfZero, numberToMove));
        } else if (numberOfMoves == 2) {
            int midTileIndex = indexOfZero + directionalOffsetToMidTileFromZero;
            int midTileValue = gameBoard.get(midTileIndex);
            changes.add(new Change(midTileIndex, gameBoard.get(numberToMoveIndex)));
            changes.add(new Change(indexOfZero, midTileValue));
            changes.add(new Change(numberToMoveIndex, 0));
        }
    }
    return changes;
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

