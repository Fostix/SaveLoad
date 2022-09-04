package Example00.UI;

import Example00.Core.MVP.Presenter;

import java.util.Scanner;

public class Menu {
    public void menu() {
        String enter;
        Scanner scanner = new Scanner(System.in);
        Presenter presenter = new Presenter(new ConsoleView());
        while (true) {
            try {
                enter =scanner.next();
                switch (enter) {
                    case "asd":
                        System.out.println("lolik");
                }
            } catch (Exception e) {
                throw new RuntimeException();
            }
        }
    }
}
