package org.example.Panels.StartPanel.startButtonActionListener;

import org.example.Panels.GameBoardPanel.GameBoardPanel;
import org.example.Panels.LoginPanel.LoginPanel;
import org.example.Panels.StartPanel.StartPanel;

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
        LoginPanel loginPanel = new LoginPanel();
        frame.add(loginPanel);
        frame.revalidate();
        frame.repaint();
    }
}
