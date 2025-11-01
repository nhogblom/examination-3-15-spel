package org.example.Panels.loginPanel.buttonActionListeners;

import org.example.OneFiveGame;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


//TODO remove class, not used.
public class GoButtonActionListener implements ActionListener {
    JPanel jp;
    JTextField username;
    JTextField gridSizeX;
    JTextField gridSizeY;
    OneFiveGame ofg;

    public GoButtonActionListener(JPanel jp, JTextField username, JTextField gridSizeX, JTextField gridSizeY) {
        this.jp = jp;
        this.username = username;
        this.gridSizeX = gridSizeX;
        this.gridSizeY = gridSizeY;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jp);

        try {

            String userNameString = username.getText();
            int gridSizeXInt = Integer.parseInt(gridSizeX.getText());
            int gridSizeYInt = Integer.parseInt(gridSizeY.getText());

            this.ofg = new OneFiveGame(userNameString, gridSizeXInt, gridSizeYInt);
            jp.setVisible(false);
//
////            GameBoardPanel gameBoardPanel = new GameBoardPanel(ofg);
//            frame.add(gameBoardPanel);
//            frame.revalidate();
//            frame.repaint();
        }
        catch (Exception error) {
            //doing nothing
        }
    }

}
