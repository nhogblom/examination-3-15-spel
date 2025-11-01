package org.example.Panels.startPanel.buttonActionListener;


import org.example.GUI;
import org.example.Panels.loginPanel.LoginPanel;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class startButtonActionListener implements ActionListener {
    JPanel startPanel;
    GUI gui;

    public startButtonActionListener(JPanel startPanel, GUI gui) {
        this.startPanel = startPanel;
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(startPanel);
        LoginPanel loginPanel = new LoginPanel(gui);
        frame.add(loginPanel);
        frame.setContentPane(loginPanel);
        frame.revalidate();
        frame.repaint();
    }
}
