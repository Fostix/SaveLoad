package Example02;

import java.util.Scanner;

public class Game {
    public void game() {
        String enter;
        Scanner scanner = new Scanner(System.in);
        //#region setting game
        System.out.print("Enter how much be candies: ");
        int candies = scanner.nextInt();
        System.out.printf("\nEnter max candies can take one person: ");
        int max = scanner.nextInt();
        System.out.println();
        int min = 1;
        int take;
        int botTake;
        //#endregion
        while (candies > 0) {
            System.out.println("How many candies do you take?: ");

            take = personTake(candies, max, min, scanner);
            candies -= take;
            //take = scanner.nextInt();
            candies -= take;

            botTake = hardBot(candies, max, min);
            candies -= botTake;
            System.out.printf("Bot take: %d left: %d candies", botTake, candies);
        }
    }

    public int hardBot(int candies, int max, int min) {
        return candies % (max + min);
    }

    public int personTake(int candies, int max, int min, Scanner scanner) {
        int take;
        do {
            take = scanner.nextInt();
        } while (take >= max || take >= candies || take <= min);
            return take;
    }
}
