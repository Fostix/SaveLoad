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
                enter = "start"; // scanner.next();
                switch (enter) {
                    case "start":
                        presenter.settings();
                        boolean playing = true; // for check game continue or not!!
                        while (playing) {
                            playing = presenter.playing();
                            presenter.getNumber();
                        }
                        break;
                    case "save":
                        System.out.println("will be here save");
                        break;
                    case "load":
                        System.out.println("will be here load");
                }
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}