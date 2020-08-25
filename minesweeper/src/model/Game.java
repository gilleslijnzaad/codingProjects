package model;

public class Game {
    private final int ROWS = 30;
    private final int COLUMNS = 16;
    private final int MINES = 99;
    private Board board;
    private int minesLeft;

    // TODO: put stopwatch in
    public Game() {
        board = new Board(ROWS, COLUMNS, MINES);
        minesLeft = MINES;
    }

    public int getROWS() {
        return ROWS;
    }

    public int getCOLUMNS() {
        return COLUMNS;
    }

    public int getMINES() {
        return MINES;
    }

    public Board getBoard() {
        return board;
    }

}
