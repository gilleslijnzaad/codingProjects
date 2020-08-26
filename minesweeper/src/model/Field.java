package model;

import java.awt.*;

public class Field {
    private boolean mine;
    private boolean flagged;
    private boolean covered;
    private int surroundingMines;
    private Point startXY;

    public Field() {
        flagged = false;
        covered = false;
        surroundingMines = 0;
    }

    public boolean isMine() {
        return mine;
    }

    public void setMine(boolean mine) {
        this.mine = mine;
    }

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

    public void setSurroundingMines() {
        surroundingMines++;
    }

    public void setSurroundingMines(int number) { surroundingMines = number ;}

    public void setStartXY(Point p) {
        startXY = p;
    }

    public Point getStartXY() {
        return startXY;
    }
}
