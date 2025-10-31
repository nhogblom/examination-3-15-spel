package org.example.FileOperations;

import org.example.Panels.HighscorePanel.Highscore;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Serialization{

    ArrayList<Highscore> hlist = Highscore.getHighscoresList();

    public void Serialize(){


        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("highscores.txt"))) {
            int count = hlist.size();
            oos.writeInt(count);
            for(Highscore h : hlist){
                oos.writeObject(h);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void deserialize(String fileName){

        if(doesFileExist(fileName)){
            try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
                int count = ois.readInt();
                for(int i = 0; i < count; i++) {
                    Highscore highscore = (Highscore) ois.readObject();
                    highscore.addHighscoreToList();
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }

    }
    private boolean doesFileExist(String fileName){
        Path pathToFile = Paths.get(fileName);
        return Files.exists(pathToFile);
    }

}
