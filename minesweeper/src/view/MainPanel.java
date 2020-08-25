package view;

import model.Field;
import model.Game;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

// will later implement Observer
public class MainPanel extends JPanel {
    private Game game;
    private ArrayList<ArrayList<Field>> matrix;

    private static final int FIELD_SIZE = 30;
    private Font FONT;

    public MainPanel(Game game) {
        this.game = game;
        matrix = game.getBoard().getMatrix();
        initFont();
        setBackground(Color.GRAY);
        setVisible(true);
    }

    public void initFont() {
        try {
            FONT = Font.createFont(Font.TRUETYPE_FONT, new File("Minecraft.ttf")).deriveFont(20f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(FONT);
        } catch (IOException | FontFormatException e) {
            System.err.println("Something went wrong here...");
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void paintField(Graphics2D g, int r, int c, int x, int y) {
        Field field = matrix.get(r).get(c);
        FontMetrics fm = getFontMetrics(FONT);
        int startX;
        int startY = y + fm.getHeight();
        if (!field.isCovered()) {
            if (!field.isMine()) {
                g.setColor(Color.LIGHT_GRAY);
                g.fillRect(x, y, FIELD_SIZE, FIELD_SIZE);
                int number = field.getSurroundingMines();
                g.setColor(Colors.getColor(number));
                int width = fm.charWidth((char) ('0' + number));
                startX = x + (FIELD_SIZE - width) / 2;
                g.drawString(String.valueOf(number), startX, startY);
            }
        }
        g.setColor(Color.BLACK);
        g.drawRect(x, y, FIELD_SIZE, FIELD_SIZE);
    }

    private void paintBoard(Graphics2D g) {
        g.setFont(FONT);
        int x = 50;
        int y = 50;
        int rows = game.getROWS();
        int columns = game.getCOLUMNS();
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                paintField(g, r, c, x, y);
                x += FIELD_SIZE;
            }
            x = 50;
            y = 50 + r*FIELD_SIZE;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        paintBoard(g2D);
        requestFocusInWindow();
    }

//    public void update(Observable observable, Object o) {
//        this.repaint();
//    }

}
