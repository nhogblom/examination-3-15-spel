package org.example.Panels.HighscorePanel;

import java.sql.Time;

public class Highscore {

    private String name;
    private int turns;
    private Time time;

    public Highscore() {}

    public Highscore(String name, int turns, Time time) {
        this.name = name;
        this.turns = turns;
        this.time = time;
    }



}
