package org.example.Panels.StartPanel.ButtonActionListener;

import org.example.Panels.GameBoardPanel.GameBoardPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startButtonActionListener implements ActionListener {
    JPanel startPanel;

    public startButtonActionListener(JPanel startPanel) {
        this.startPanel = startPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(startPanel);
        startPanel.setVisible(false);
        GameBoardPanel gameBoardPanel = new GameBoardPanel();
        frame.add(gameBoardPanel);
        frame.revalidate();
        frame.repaint();
    }
}
