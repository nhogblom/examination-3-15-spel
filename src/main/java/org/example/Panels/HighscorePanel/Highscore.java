package org.example.Panels.HighscorePanel;

import java.sql.Time;

public class Highscore {

    private String name;
    private int turns;

    public Highscore() {}

    //TODO add time for the time it took to clear game

    public Highscore(String name, int turns) {
        this.name = name;
        this.turns = turns;
    }

    public String getName() {
        return name;
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
