package org.example.Panels.HighscorePanel.buttonActionListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BackButtonActionListener implements ActionListener {
    JPanel previousPanel;

    public BackButtonActionListener(JPanel previousPanel) {
        this.previousPanel = previousPanel;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(button);
        frame.setContentPane(previousPanel);
        frame.revalidate();
        frame.repaint();
    }
}
