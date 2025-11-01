package org.example.Panels.startPanel.buttonActionListener;

import org.example.Panels.HighscorePanel.HighscorePanel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighscoreButtonActionListener implements ActionListener {
    JPanel startPanel;

    public HighscoreButtonActionListener(JPanel startPanel) {
        this.startPanel = startPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(startPanel);
        HighscorePanel highscorePanel = new HighscorePanel(startPanel);
        frame.setContentPane(highscorePanel);
        frame.revalidate();
        frame.repaint();

    }
}
