package Game.Core.MVP;

public class Presenter {
    private Model model;
    private View view;

    public Presenter(View view) {
        this.model = new Model();
        this.view = view;
    }

    public void showMenu() {
        view.menu();
    }

    public void settings() {
        view.setTotalCandiesText();
        int totalCandies = 27; // getNumber();
        view.setMaxCanTakeCandiesText();
        int maxCanTake = 6; // getNumber();
        view.whoGoesFirst();
        String whoFirst = "i"; // view.enterInConsole(); For faster check!
        boolean whoGoesFirst = whoGoesFirst(whoFirst.toLowerCase());
        model.setSettings(totalCandies, maxCanTake, whoGoesFirst);
    }

    /** Для ввода и проверки является ли введенное значение числом*/
    public int getNumber() {
        String beNumber = "";
        int count = 0;
        do {
            beNumber = view.enterInConsole();
            count++;
        } while (!model.isDigitString(beNumber));

        if (count > 1) {
            view.itIsNumber();
        }
        return model.getNumber(beNumber);
    }

    public boolean whoGoesFirst(String whoFirst) {
        if (whoFirst.equals("i") || whoFirst.equals("me"))
            return true;
        else
            return false;
    }
}
