import model.Game;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
        Game g = new Game();
        new MainFrame(g);
    }

}
