package Game.UI;

import Game.Core.MVP.View;

import java.util.Scanner;

public class ConsoleView implements View {
    private Scanner scanner = new Scanner(System.in);

    @Override
    public void menu() {
        System.out.printf("write \"start\" for play new game\n");
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
        return scanner.next();
    }

    @Override
    public void itIsNumber() {
        System.out.println("А вот это число. Молодец!");
    }

    @Override
    public void whoGoesFirst() {
        System.out.print("Who first take candies you or bot\nWrite \"Me\" or \"I\" if you want to go first,\nif the bot does not understand what you see, then it will go first: ");
    }
}