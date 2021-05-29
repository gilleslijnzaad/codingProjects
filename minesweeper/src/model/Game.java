package model;

public class Game {
    private final int N_ROWS = 30;
    private final int N_COLUMNS = 16;
    private final int N_MINES = 99;
    private Board board;
    private int minesLeft;

    // TODO: put stopwatch in
    public Game() {
        board = new Board(N_ROWS, N_COLUMNS, N_MINES);
        minesLeft = N_MINES;
    }

    public int getN_ROWS() {
        return N_ROWS;
    }

    public int getN_COLUMNS() {
        return N_COLUMNS;
    }

    public int getN_MINES() {
        return N_MINES;
    }

    public Board getBoard() {
        return board;
    }

}
