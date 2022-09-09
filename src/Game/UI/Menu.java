package Game.UI;

import Game.Core.MVP.Presenter;

import java.util.Scanner;

public class Menu {
    /** Launches the menu*/
    public void menu() {
        String enter;
        Scanner scanner = new Scanner(System.in);
        Presenter presenter = new Presenter(new ConsoleView());
        while (true) {
            try {
                presenter.showMenu();
                enter = scanner.next();
                if (enter.equals("start")) {
                    presenter.settings();
                    boolean playing = true;
                    while (playing)
                        playing = presenter.playing();
                }
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}