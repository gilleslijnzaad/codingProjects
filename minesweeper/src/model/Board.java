package model;

import java.util.ArrayList;
import java.util.Random;

/**
 * Class that represents the board, i.e. a matrix of fields
 */
public class Board {
    private final int rows;
    private final int columns;
    private final ArrayList<ArrayList<Field>> matrix = new ArrayList<>();
    Random random = new Random();

    /**
     * Constructor
     * @param rows    number of rows in the matrix
     * @param columns number of columns in the matrix
     * @param mines   number of mines on the board
     */
    public Board(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        initMatrix();
        initMines(mines);
        initSurroundingMines();
    }

    /**
     * @return the matrix, an ArrayList of {@code Field} ArrayLists
     */
    public ArrayList<ArrayList<Field>> getMatrix() {
        return matrix;
    }

    /**
     * Creates the ArrayList-matrix structure
     */
    public void initMatrix() {
        for (int r = 0; r < rows; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < columns; c++) {
                matrix.get(r).add(new Field());
            }
        }
    }

    /**
     * Recursive method that divides the mines randomly over the board
     * @param minesToGo number of mines left to put on the board
     */
    public void initMines(int minesToGo) {
        if (minesToGo == 0) {
            return;
        }
        Field randomField = matrix.get(random.nextInt(rows)).get(random.nextInt(columns));
        if (randomField.isMine()) {
            initMines(minesToGo);
        } else {
            randomField.setMine(true);
            initMines(minesToGo - 1);
        }
    }

    /**
     * Assigns the right {@code surroundingMines} value for each {@code Field} in the board
     */
    public void initSurroundingMines() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                Field currentField = matrix.get(r).get(c);
                if (!currentField.isMine()) {
                    for (int i = r - 1; i < r + 2; i++) {
                        for (int j = c - 1; j < c + 2; j++) {
                            if (i >= 0 && i < rows && j >= 0 && j < columns) {
                                if (matrix.get(i).get(j).isMine()) {
                                    currentField.setSurroundingMines();
                                }
                            }
                        }
                    }
                } else {
                    currentField.setSurroundingMines(-1);
                }
            }
        }
    }
}

