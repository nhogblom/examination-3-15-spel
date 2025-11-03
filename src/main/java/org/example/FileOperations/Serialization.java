package org.example.FileOperations;

import org.example.Panels.HighscorePanel.Highscore;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Serialization{


    private final String fileNameEasy = "src/main/resources/highscores.txt";
    private final String fileNameMedium = "src/main/resources/highscoresMedium.txt";
    private final String fileNameHard = "src/main/resources/highscoresHard.txt";


    public void Serialize(){
        serializeFunction(Highscore.getHighscoresList(),fileNameEasy);
        serializeFunction(Highscore.getHighscoresListMedium(),fileNameMedium);
        serializeFunction(Highscore.getHighscoresListHard(),fileNameHard);
    }
    private void serializeFunction(ArrayList<Highscore> highscoreList, String fileName) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(highscoreList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deserialize(){
        Highscore.setHighscoresList(deserializeFunction(fileNameEasy));
        Highscore.setHighscoresListMedium(deserializeFunction(fileNameMedium));
        Highscore.setHighscoresListHard(deserializeFunction(fileNameHard));
    }

    private ArrayList<Highscore> deserializeFunction(String fileName){
        ArrayList<Highscore> highscores = new ArrayList<>();
        if(doesFileExist(fileName)){
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
                highscores = ((ArrayList<Highscore>) ois.readObject());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        return highscores;
    }

    private boolean doesFileExist(String fileName){
        Path pathToFile = Paths.get(fileName);
        return Files.exists(pathToFile);
    }

}
