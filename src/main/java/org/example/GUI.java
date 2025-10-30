package org.example;

import org.example.Panels.GameBoardPanel.GameBoardPanel;
import org.example.Panels.LoginPanel.LoginPanel;

import javax.swing.*;

public class GUI extends JFrame {

    JFrame frame = new JFrame();
    LoginPanel loginPanel = new LoginPanel();

    //endast för test
    GameBoardPanel gameBoardPanel = new GameBoardPanel();


    GUI() {
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        //frame.add(loginPanel);
        //loginPanel.setVisible(true);
        frame.add(gameBoardPanel);
        gameBoardPanel.setVisible(true);

    }
}