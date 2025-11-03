package org.example.Panels.HighscorePanel;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Highscore implements Serializable {

    private final static long serialVersionUID = 1L;

    private String name;
    private int turns;
    private static ArrayList<Highscore> highscoresList = new ArrayList<>();
    private static ArrayList<Highscore> highscoresListMedium = new ArrayList<>();
    private static ArrayList<Highscore> highscoresListHard = new ArrayList<>();
    private int gameSize;
    private final int maxHighscores = 5;
    private LocalTime completionTime;

    public Highscore() {
    }

    //TODO add time for the time it took to clear game

    public Highscore(String name, int turns, String Difficulty, LocalTime completionTime) {
        this.name = name;
        this.turns = turns;
        this.completionTime = completionTime;

        switch (Difficulty) {
            case "Easy" -> addToArrayList(highscoresList);
            case "Medium" -> addToArrayList(highscoresListMedium);
            case "Hard" -> addToArrayList(highscoresListHard);
        }
    }

    private void addToArrayList(ArrayList<Highscore> arrayListToAddTo) {
        arrayListToAddTo.add(this);
        IO.println("Adding Highscore to List" + arrayListToAddTo);
        sortArrayListByTurns(arrayListToAddTo);
        if (arrayListToAddTo.size() > maxHighscores) {
            removeElementsOutsideOfHighscore();
        }
    }

    public void removeElementsOutsideOfHighscore() {
        highscoresList.remove(maxHighscores);
    }

    public ArrayList<Highscore> sortArrayListByTurns(ArrayList<Highscore> hlist) {
        Collections.sort(hlist, new sortByTurns());
        return hlist;
    }

    public String getName() {
        return name;
    }

    public static void setHighscoresList(ArrayList<Highscore> highscoresList) {
        Highscore.highscoresList = highscoresList;
    }

    public static void setHighscoresListMedium(ArrayList<Highscore> highscoresListMedium) {
        Highscore.highscoresListMedium = highscoresListMedium;
    }

    public static void setHighscoresListHard(ArrayList<Highscore> highscoresListHard) {
        Highscore.highscoresListHard = highscoresListHard;
    }

    public void addHighscoreToList() {
        highscoresList.add(this);
    }

    public static ArrayList<Highscore> getHighscoresListMedium() {
        return highscoresListMedium;
    }

    public static ArrayList<Highscore> getHighscoresListHard() {
        return highscoresListHard;
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

