package Game.Core.Game;

import java.util.Scanner;

public class Logic {
    Settings settings;
    // maybe need set function and another function game
    // or maybe add prototype. but it's then?
    public Logic(Settings settings) {
        this.settings = settings;
    }

    public int personTake() { // int candies, int max, int min, Scanner scanner
        int take;
        boolean flag = false;
        if (settings.checkWhatMore())
        do {
            if (flag)
                System.out.printf("You can't take more than: %d\nAnd can't take less than: %d\nTry again take: ", max, min);
            take = scanner.nextInt();
            flag = true;
        } while (settings.checkCanTake(take));
        return take;
    }
}