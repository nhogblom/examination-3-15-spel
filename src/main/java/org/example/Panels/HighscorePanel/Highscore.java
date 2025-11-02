package org.example.Panels.HighscorePanel;

import java.io.Serializable;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Highscore implements Serializable {

    private final static long serialVersionUID = 1L;

    private String name;
    private int turns;
    private static ArrayList<Highscore> highscoresList = new ArrayList<>();
    private int gameSize;
    private final int maxHighscores = 5;

    public Highscore() {}

    //TODO add time for the time it took to clear game

    public Highscore(String name, int turns) {
        this.name = name;
        this.turns = turns;
        highscoresList.add(this);
        sortArrayListByTurns();
        if(highscoresList.size() > maxHighscores) {
            removeElementsOutsideOfHighscore();
        }
    }

    public void removeElementsOutsideOfHighscore(){
        highscoresList.remove(maxHighscores);
    }

    public void sortArrayListByTurns(){
        Collections.sort(highscoresList, new sortByTurns());
    }

    public String getName() {
        return name;
    }

    public void addHighscoreToList() {
        highscoresList.add(this);
    }

    public static ArrayList<Highscore> getHighscoresList() {
        return highscoresList;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }
}

class sortByTurns implements Comparator<Highscore> {
    @Override
    public int compare(Highscore h1, Highscore h2) {
            return h1.getTurns() - h2.getTurns();
    }
}

