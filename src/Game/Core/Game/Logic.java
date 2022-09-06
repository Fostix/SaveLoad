package Game.Core.Game;

import java.util.Scanner;

public class Logic {
    Settings settings;
    // maybe need set function and another function game
    // or maybe add prototype. but it's then?
    public Logic(Settings settings) {
        this.settings = settings;
    }

    public int personTake(Settings settings) { // int candies, int max, int min, Scanner scanner
        // int take = 0; ????
//        if (settings.checkWhatMore())
//        do {
//            if (flag)
//                // System.out.printf("You can't take more than: %d\nAnd can't take less than: %d\nTry again take: ", max, min);
//            //settings.minusCandies(); //scanner.nextInt();
//            flag = true;
//        } while (settings.checkCanTake(settings.minusCandies()));
        return 1;
    }

    public int botTake() {
        return 1;
    }
}