package Game.Core;

import java.util.Scanner;

public class GameL {
    // first stat


    public void game() {
        String enter;
        Scanner scanner = new Scanner(System.in);
        //#region setting game
        System.out.println("If you want save game write save during the game restore to restore");
        System.out.print("Enter how much be candies: ");
        int candies =  27; //scanner.nextInt();
        System.out.print("\nEnter max candies can take one person: ");
        int max = 6;// scanner.nextInt();
        System.out.println();
        System.out.print("Who first take candies you or bot\nEnter bot if bot first take or I if you first take: ");
        String whoFirst = scanner.next();
        boolean flag;

        if (whoFirst.equals("bot"))
            flag = false;
        else
            flag = true;
        int min = 1;
        int take; // Need create function which check what user write if write save to save,
        int botTake; // if restore to need show save information.
        //#endregion
        while (candies > 0) {
            if (flag) {
                System.out.print("How many candies do you take: ");
                // here need send information.
                // not in function.
                take = personTake(candies, max, min, scanner);
                candies -= take;
                flag = false;
            }
            else {
                botTake = hardBot(candies, max, min);
                candies -= botTake;
                System.out.printf("Bot take: %d left: %d candies\n", botTake, candies);
                flag = true;
            }
        }
        if (!flag)
            System.out.println("You win successful!!!");
        else
            System.out.println("You lose : (");
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
                System.out.printf("You can't take more than: %d\nAnd can't take less than: %d\nTry again take: ", max, min);
            take = scanner.nextInt();
            flag = true;
        } while (take > max || take < min);
            return take;
    }
}