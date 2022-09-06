package Game.Core.MVP;

public interface View {
    void menu();
    void setTotalCandiesText();
    void setMaxCanTakeCandiesText();
    String enterInConsole();
    void itIsNumber();
    void whoGoesFirst();
    void sayTakeCandies();
    void printCandies(int candies);
    void botTake(int take);
    void youWin();
    void botWin();
}