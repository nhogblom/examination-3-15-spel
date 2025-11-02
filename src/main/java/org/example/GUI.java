package org.example;


import org.example.FileOperations.Serialization;
import org.example.Panels.StartPanel.StartPanel;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUI extends JFrame {

    JFrame frame = new JFrame();
    StartPanel StartPanel = new StartPanel(this);
    Serialization serializeClass = new Serialization();

    GUI() {
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(StartPanel);
        StartPanel.setVisible(true);

        serializeClass.deserialize();

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                closeProgram();
            }
        });
    }

    public void closeProgram(){
        IO.println("Closing program...");
        serializeClass.Serialize();
        System.exit(0);
    }

}