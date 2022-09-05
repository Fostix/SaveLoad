package Example02;

import java.util.Scanner;

public class Game {
    public void game() {
        String enter;
        Scanner scanner = new Scanner(System.in);
        //#region setting game
        System.out.print("Enter how much be candies: ");
        int candies =  27; //scanner.nextInt();
        System.out.printf("\nEnter max candies can take one person: ");
        int max = 6;// scanner.nextInt();
        System.out.println();
        int min = 1;
        int take;
        int botTake;
        //#endregion
        while (candies > 0) {
            System.out.print("How many candies do you take: ");

            take = personTake(candies, max, min, scanner);
            candies -= take;
            //take = scanner.nextInt();

            botTake = hardBot(candies, max, min);
            candies -= botTake;
            System.out.printf("Bot take: %d left: %d candies\n", botTake, candies);
        }
    }

    public int hardBot(int candies, int max, int min) {
        int botTake = candies % (max + min);
        return min < botTake ? botTake : 1;
    }

    public int personTake(int candies, int max, int min, Scanner scanner) {
        int take;
        boolean flag = false;
        if (candies < max)
            max = candies;
        do {
            if (flag)
                System.out.printf("You can't take more than: %d\nAnd can't take less than: %d\nTry again take: \n", max, min);
            take = scanner.nextInt();
            flag = true;
        } while (take > max || take < min);
            return take;
    }
}
