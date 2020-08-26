import model.Game;
import view.MainFrame;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        new MainFrame(game);
    }

}
