package Game.UI;

import Game.Core.MVP.Presenter;

import java.util.Scanner;

public class Menu {
    public void menu() {
        String enter;
        Scanner scanner = new Scanner(System.in);
        Presenter presenter = new Presenter(new ConsoleView());
        presenter.showMenu();
        while (true) {
            try {
                enter = "start";//scanner.next();
                if (enter.equals("start")) {
                    presenter.settings();
                    boolean playing = true; // for check game continue or not!!
                    while (playing)  // check save or load write or not
                        playing = presenter.playing();
                }
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}