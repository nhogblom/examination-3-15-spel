package org.example;

import javax.swing.*;

public class GUI extends JFrame {

    JFrame frame = new JFrame();
    GameBoardPanel gameBoardPanel = new GameBoardPanel();

    // testar StartPanel
    //StartPanel startPanel = new StartPanel();

    GUI() {

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        frame.add(gameBoardPanel);
        //rame.add(startPanel);
    }

}
