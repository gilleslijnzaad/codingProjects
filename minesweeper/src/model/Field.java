package model;

import java.awt.*;

/**
 * Class that represents a single square on the board
 */
public class Field {
    private boolean mine;
    private boolean flagged;
    private boolean covered;
    private int surroundingMines;
    private Point startXY;

    /**
     * Constructor
     */
    public Field() {
        flagged = false;
        covered = false;
        surroundingMines = 0;
    }

    /**
     * @return whether the {@code Field} is a mine or not
     */
    public boolean isMine() {
        return mine;
    }

    /**
     * Makes the {@code Field} a mine by setting the field mine true
     */
    public void placeMine() {
        mine = true;
    }

    /**
     *
     * @return
     */
    public boolean isFlagged() {
        return flagged;
    }

    public void setFlagged(boolean flagged) {
        this.flagged = flagged;
    }

    public boolean isCovered() {
        return covered;
    }

    public void uncover() {
        covered = false;
    }

    public int getSurroundingMines() {
        return surroundingMines;
    }

    public void setSurroundingMines(int number) { 
        surroundingMines = number ;
    }

    public void setStartXY(Point p) {
        startXY = p;
    }

    public Point getStartXY() {
        return startXY;
    }
}
