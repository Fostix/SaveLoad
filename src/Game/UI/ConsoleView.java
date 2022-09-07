package Game.UI;

import Game.Core.MVP.View;

import java.util.Scanner;

public class ConsoleView implements View {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void menu() {
        System.out.print("write \"start\" for play new game\n");
    }

    @Override
    public void setTotalCandiesText() {
        System.out.print("How many candies will there be: ");
    }

    @Override
    public void setMaxCanTakeCandiesText() {
        System.out.print("Enter max candies can take one person: ");
    }

    @Override
    public String enterInConsole() {
        return scanner.nextLine();
    }

    @Override
    public void itIsNumber() {
        System.out.println("Bot say: Hey, are you still there?\nIt's not fair : (");
    }

    @Override
    public void whoGoesFirst() {
        System.out.print("Who first take candies you or bot\nWrite \"Me\" or \"I\" if you want to go first,\nif the bot does not understand what you see, then it will go first: ");
    }

    @Override
    public void sayTakeCandies() {
        System.out.print("How many candies do you take: ");
    }

    @Override
    public void printCandies(int candies) {
        System.out.println(candies + " candies left!!");
    }

    @Override
    public void botTake(int take) {
        System.out.printf("Bot took: %d candies\n", take);
    }

    @Override
    public void youWin() {
        System.out.println("Congratulations you won!!!");
    }

    @Override
    public void botWin() {
        System.out.println("You lose : (");
    }

    @Override
    public void showSaves(String saves) {
        System.out.println(saves.replace("[", "").replace("]", "").replace(", ", "\n"));
        System.out.println("load save_info");
    }

    @Override
    public void badSave() {
        System.out.println("For save use \"save title\"");
    }

    @Override
    public void saveGood() {
        System.out.println("Save good");
    }
}