package view;

import java.awt.*;

public class Colors {
    private static final Color GREEN = new Color(30, 90, 30);
    private static final Color PURPLE = new Color(90, 0, 50);
    private static final Color BROWN = new Color(100, 50, 30);
    private static final Color AQUA = new Color(10, 140, 130);

    public static Color getColor(int surroundingMines) {
        return switch (surroundingMines) {
            case 1 -> Color.BLUE;
            case 2 -> GREEN;
            case 3 -> Color.RED;
            case 4 -> PURPLE;
            case 5 -> BROWN;
            case 6 -> AQUA;
            case 7 -> Color.BLACK;
            case 8 -> Color.DARK_GRAY;
            default -> null;
        };
    }
}
