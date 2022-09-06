package Game.Core.Game;

import java.util.Scanner;

public class Take {
    public int personTake(int candies, int max, int min, Scanner scanner) {
        int take;
        boolean flag = false;
        if (candies < max)
            max = candies;
        do {
            if (flag)
                System.out.printf("You can't take more than: %d\nAnd can't take less than: %d\nTry again take: ", max, min);
            take = scanner.nextInt();
            flag = true;
        } while (take > max || take < min);
        return take;
    }
}
