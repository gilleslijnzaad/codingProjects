package model;

import java.util.ArrayList;
import java.util.Random;

public class Board {
    private final int rows;
    private final int columns;
    private final int mines;
    private ArrayList<ArrayList<Field>> matrix = new ArrayList<>();
    Random random = new Random();

    public Board(int rows, int columns, int mines) {
        this.rows = rows;
        this.columns = columns;
        this.mines = mines;
        initBoard();
        initMines(mines);
        initSurroundingMines();
        for (int r = 0; r < 6; r++) {
            for (int c = 0; c < 6; c++) {
                matrix.get(r).get(c).uncover();
            }
        }
    }

    public ArrayList<ArrayList<Field>> getMatrix() {
        return matrix;
    }

    public void initBoard() {
        for (int r = 0; r < rows; r++) {
            matrix.add(new ArrayList<>());
            for (int c = 0; c < columns; c++) {
                matrix.get(r).add(new Field());
            }
        }
    }

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

    public void printBoard() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                Field currentField = matrix.get(r).get(c);
                System.out.print(currentField.isMine() ? "X" : currentField.getSurroundingMines());
                System.out.print(" ");
            }
            System.out.println();
        }
    }

}
