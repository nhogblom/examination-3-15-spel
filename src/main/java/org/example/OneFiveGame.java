package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OneFiveGame {
    List<Integer> GameBoard = new ArrayList<Integer>();
    int gameBoardSizeX;
    int gameBoardSizeY;

    public OneFiveGame(int gameBoardSizeX, int gameBoardSizeY) {
        this.gameBoardSizeX = gameBoardSizeX;
        this.gameBoardSizeY = gameBoardSizeY;
        int xyValue = gameBoardSizeX * gameBoardSizeY;

        for (int i = 0; i < xyValue; i++) {
            GameBoard.add(i);
        }
        Collections.shuffle(GameBoard);
        System.out.println(GameBoard.toString());
        System.out.println(GameBoard.size());
        isMovable(12);
    }

    // falsk triggar true ifall objectToMove är det objektet mest east av en rad och 0 är nästa i listan men mest west~
    public boolean isMovable(int objectToMove) {
        int objectToMoveIndex = GameBoard.indexOf(objectToMove);
        System.out.println("objectToMoveIndex: " + objectToMoveIndex);
        int objectRow = objectToMoveIndex / gameBoardSizeX;
        int objectCol = objectToMoveIndex % gameBoardSizeX;
        System.out.println("objectRow: " + (objectRow + 1) + ", objectCol: " + (objectCol + 1));
        boolean north, south, east, west;
        if (objectCol - 1 >= 0) {
            if (GameBoard.get(((objectRow) * 4) + objectCol - 1).equals(0)) {
                west = true;
            } else {
                west = false;
            }
        } else {
            west = false;
        }
        if (objectRow - 1 >= 0) {
            if (GameBoard.get(objectToMoveIndex - gameBoardSizeX).equals(0)) {
                north = true;
            } else {
                north = false;
            }
        } else {
            north = false;
        }
        if (objectRow + 1 <= gameBoardSizeY-1) {
            if (GameBoard.get(objectToMoveIndex + gameBoardSizeX).equals(0)) {
                south = true;
            } else {
                south = false;
            }
        } else {
            south = false;
        }
        if (objectCol + 1 <= gameBoardSizeX-1) {
            if (GameBoard.get((objectRow * 4) + objectCol + 1).equals(0)) {
                east = true;
            } else {
                east = false;
            }
        } else {
            east = false;
        }
        System.out.println("north: " + north);
        System.out.println("east: " + east);
        System.out.println("south: " + south);
        System.out.println("west: " + west);
        printGameBoardToTerminal();
        return true;
    }

    public void printGameBoardToTerminal() {
        for (int i = 0; i < gameBoardSizeY; i++) {
            for (int j = 0; j < GameBoard.size() / 4; j++) {
                System.out.print("[" + GameBoard.get((i * 4) + j) + "]");
            }
            System.out.println("\n");
        }
    }


    static void main() {
        OneFiveGame oneFiveGame = new OneFiveGame(4, 4);
    }
}
