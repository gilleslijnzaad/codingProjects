package view;

import controller.Clicker;
import model.Game;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public MainFrame(Game game) {
        super("Minesweeper");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(500, 750));

        MainPanel panel = new MainPanel(game);
        new Clicker(panel, game);
        panel.requestFocusInWindow();
        add(panel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
