package view;

import model.Game;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(Game g) {
        super("Minesweeper");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 750));

        MainPanel panel = new MainPanel(g);
        panel.requestFocusInWindow();
        add(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
