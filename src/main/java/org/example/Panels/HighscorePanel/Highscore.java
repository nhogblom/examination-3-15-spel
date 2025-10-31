package org.example.Panels.HighscorePanel;

import java.sql.Time;
import java.util.ArrayList;

public class Highscore {

    private String name;
    private int turns;
    private static ArrayList<Highscore> highscoresList = new ArrayList<>();

    public Highscore() {}

    //TODO add time for the time it took to clear game

    public Highscore(String name, int turns) {
        this.name = name;
        this.turns = turns;
        highscoresList.add(this);
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
