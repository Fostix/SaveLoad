package Game.UI;

import java.util.Scanner;

public class Button {
    public void buttonOnOff() {
        String enter;
        Scanner scanner = new Scanner(System.in);
        while (true)
            try {
                System.out.print("Enter 'q' for on game: ");
                enter = "q"; //scanner.next(); then delete
                if (enter.equals("q")) { // for faster check code!!
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
