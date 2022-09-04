package Example00.UI;

import java.util.Scanner;

public class Button {
    public void buttonOnOff() {
        String enter;
        Scanner scanner = new Scanner(System.in);
        while (true)
            try {
                System.out.println("Enter 'q' for on game");
                enter = scanner.next();
                if (enter.equals("q")) {
                    Menu menu = new Menu();
                    menu.menu();
                } else {
                    System.out.println("...");
                }
            } catch (Exception e) {
                throw new RuntimeException(e);
        }
    }
}
