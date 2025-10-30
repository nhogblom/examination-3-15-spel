package org.example.Panels.GameBoardPanel.ButtonActionListeners;
import org.example.Panels.GameBoardPanel.GameBoardPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewGameButtonActionListener implements ActionListener {

    JPanel gameBoardPanel;

    public NewGameButtonActionListener(JPanel gameBoardPanel) {
        this.gameBoardPanel = gameBoardPanel;
    }

    //TODO ta bort hårdkodade 15 och få in så den använder samma inställningar som från login screen.
    @Override
    public void actionPerformed(ActionEvent e) {
//        GameBoardPanel gbp = (GameBoardPanel) gameBoardPanel.getParent();
//        gameBoardPanel.removeAll();
//        GameBoardPanel.gameButtons.clear();
//        gbp.createJButtonArrayList(15);
//        gbp.randomizeButtons(GameBoardPanel.gameButtons);
//        gbp.printGameBoardButtons(GameBoardPanel.gameButtons);
//        gameBoardPanel.revalidate();
//        gameBoardPanel.repaint();
    }
}
