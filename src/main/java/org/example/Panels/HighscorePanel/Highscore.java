package org.example.Panels.HighscorePanel;

import org.example.Enums.Difficulty;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Highscore implements Serializable {

    private final static long serialVersionUID = 1L;

    private final String name;
    private final int turns;
    private static ArrayList<Highscore> highscoresList = new ArrayList<>();
    private static ArrayList<Highscore> highscoresListMedium = new ArrayList<>();
    private static ArrayList<Highscore> highscoresListHard = new ArrayList<>();
    private final int maxHighscores = 5;
    private final LocalTime completionTime;


    public Highscore(String name, int turns, Difficulty Difficulty, LocalTime completionTime) {
        this.name = name;
        this.turns = turns;
        this.completionTime = completionTime;

        switch (Difficulty.getDescription()) {
            case "Easy" -> addToArrayList(highscoresList);
            case "Medium" -> addToArrayList(highscoresListMedium);
            case "Hard" -> addToArrayList(highscoresListHard);
        }
    }

    public LocalTime getCompletionTime() {
        return completionTime;
    }

    private void addToArrayList(ArrayList<Highscore> arrayListToAddTo) {
        arrayListToAddTo.add(this);
        sortArrayListByTurns(arrayListToAddTo);
        if (arrayListToAddTo.size() > maxHighscores) {
            removeElementsOutsideOfHighscore();
        }
    }

    public void removeElementsOutsideOfHighscore() {
        highscoresList.remove(maxHighscores);
    }

    public void sortArrayListByTurns(ArrayList<Highscore> hlist) {
        Collections.sort(hlist, new SortByTurns());
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

    public static ArrayList<Highscore> getHighscoresListMedium() {
        return highscoresListMedium;
    }

    public static ArrayList<Highscore> getHighscoresListHard() {
        return highscoresListHard;
    }

    public static ArrayList<Highscore> getHighscoresList() {
        return highscoresList;
    }

    public int getTurns() {
        return turns;
    }
}

class SortByTurns implements Comparator<Highscore> {
    @Override
    public int compare(Highscore h1, Highscore h2) {
        if(h1.getTurns() == h2.getTurns()){
            return h1.getCompletionTime().compareTo(h2.getCompletionTime());
        }
        return h1.getTurns() - h2.getTurns();
    }
}

