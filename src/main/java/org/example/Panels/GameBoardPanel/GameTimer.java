package org.example.Panels.GameBoardPanel;

import javax.swing.*;
import java.time.LocalTime;

public class GameTimer extends Thread{
    int seconds;
    JLabel timeLabel;

    LocalTime gameTime;

    public GameTimer(JLabel timeLabel){
        this.timeLabel = timeLabel;
        gameTime = LocalTime.of(0,0,0);
    }

    public LocalTime getGameTime() {
        return gameTime;
    }

    public void run(){
        while(!Thread.interrupted()){
            try{
                seconds++;
                gameTime = gameTime.plusSeconds(1);
                timeLabel.setText("Time: " + gameTime.toString());
                Thread.sleep(1000);
            }catch(InterruptedException e){
                return;
            }
        }

    }

}
