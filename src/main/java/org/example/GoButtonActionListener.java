package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GoButtonActionListener implements ActionListener {
    JPanel jp;

    public GoButtonActionListener(JPanel jp) {
        this.jp = jp;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(jp);
        jp.setVisible(false);
        StartPanel startPanel = new StartPanel();
        frame.add(startPanel);
        frame.revalidate();
        frame.repaint();
    }

}
