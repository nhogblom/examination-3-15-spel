package org.example.Panels.HighscorePanel.ButtonActionListener;

import org.example.Panels.StartPanel.StartPanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonActionListener implements ActionListener {
    JPanel highScorePanel;

    public BackButtonActionListener(JPanel panel) {
        this.highScorePanel = highScorePanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(highScorePanel);
        frame.remove(highScorePanel);
        StartPanel startPanel = new StartPanel();
        frame.add(startPanel);
        frame.revalidate();
        frame.repaint();
    }
}
