package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class that represents the board, i.e. a matrix of fields
 */
public class Board {
    private final int N_ROWS;
    private final int N_COLUMNS;
    private final ArrayList<ArrayList<Field>> matrix = new ArrayList<>();
    Random random = new Random();

    /**
     * Constructor
     * @param rows    number of rows in the matrix
     * @param columns number of columns in the matrix
     * @param mines   number of mines on the board
     */
    public Board(int rows, int columns, int mines) {
        this.N_ROWS = rows;
        N_COLUMNS = columns;
        initMatrix();
        initMines(mines);
        initSurroundingMines();
    }

    /**
     * Creates the ArrayList-matrix structure
     */
    public void initMatrix() {
        for (int r = 0; r < N_ROWS; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < N_COLUMNS; c++) {
                matrix.get(r).add(new Field());
            }
        }
    }

    /**
     * Randomly divides the mines over the board
     * @param mines     number of mines 
     */
    public void initMines(int mines) {
        int i = 0;
        while (i < mines) {
            int randomRow = random.nextInt(N_ROWS);
            int randomColumn = random.nextInt(N_COLUMNS);
            Field randomField = matrix.get(randomRow).get(randomColumn);
            if (randomField.isMine()) {
                randomField.placeMine();
                i++;
            }
        }
    }

    /**
     * Assigns the right {@code surroundingMines} value for each {@code Field} in the board
     */
    public void initSurroundingMines() {
        for (int r = 0; r < N_ROWS; r++) {
            for (int c = 0; c < N_COLUMNS; c++) {
                Field currentField = matrix.get(r).get(c);
                if (!currentField.isMine()) {
                    int mines = checkSurroundingFields(r, c);
                    currentField.setSurroundingMines(mines);
                } else {
                    currentField.setSurroundingMines(-1);
                }
            }
        }
    }

    private int checkSurroundingFields(int row, int column) {
        int mines = 0;
        for (int i = row - 1; i < row + 2; i++) {
            for (int j = column - 1; j < column + 2; j++) {
                if (i >= 0 && i < N_ROWS && j >= 0 && j < N_COLUMNS) {
                    if (matrix.get(i).get(j).isMine()) {
                        mines++;
                    }
                }
            }
        }
        return mines;
    }

    /**
     * @return the matrix which is an ArrayList of {@code Field} ArrayLists
     */
    public ArrayList<ArrayList<Field>> getMatrix() {
        return matrix;
    }
}