package controller;

import model.Field;
import model.Game;
import view.MainPanel;

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

/**
 * Class that handles mouse input
 */
public class Clicker extends MouseInputAdapter {
    private static MainPanel panel;
    private static Game game;

    /**
     * Constructor
     * @param panel the panel in which the clicking is going to be happening
     * @param game  the game in the panel
     */
    public Clicker(MainPanel panel, Game game) {
        System.out.println("Clicker created");
        Clicker.panel = panel;
        Clicker.game = game;
    }

    /**
     * Finds out which {@code Field} was clicked
     * @param p the {@code Point} that was clicked (from the {@code MouseEvent})
     * @return  the {@code Field}
     */
    Field whichFieldClicked(Point p) {
        for (ArrayList<Field> fields : game.getBoard().getMatrix()) {
            for (Field f : fields) {
                if (f.getStartXY().equals(p)) {
                    return f;
                }
            }
        }
        return null;
    }

    /**
     * Takes care of what happens when either the left or right mouse button is pressed in the field
     * @param event the {@code MouseEvent} that contains the information on the click
     */
    @Override
    public void mousePressed(MouseEvent event) {
        super.mousePressed(event);
        if (SwingUtilities.isLeftMouseButton(event)) {
            System.out.println("CLICK");
            Field clickedField = whichFieldClicked(event.getPoint());
            System.out.println(clickedField.getSurroundingMines());
        }
//        if (SwingUtilities.isRightMouseButton(event)) {
//            // right click stuff
//        }
    }
}
