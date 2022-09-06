package Game.Core.MVP;

public class Presenter {
    private Model model;
    private View view;
    private boolean whoGoes;

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
        this.whoGoes = whoGoesFirst(whoFirst.toLowerCase());
        model.setSettings(totalCandies, maxCanTake, whoGoes);
    }

    /** Для ввода и проверки является ли введенное значение числом*/
    public int getNumber() {
        String beNumber = "";
        int count = 0;
        do {
            beNumber = view.enterInConsole().toLowerCase();
            if (beNumber.equals("save"))// Here need check save and load word.
                saveGame();
            if (beNumber.equals("load"))
                loadGame();
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

    public boolean playing() {
        if (whoGoes) {
            int take;
            do {
                view.sayTakeCandies(); // Only show text.
                // Here put function and some rewrite getNumber function.
                take = getNumber();
            } while (model.canTakeOrNot(take));
            model.takeCandies(take);
            whoGoes = false;
        } else {
            view.botTake(model.botActivate());
            whoGoes = true;
        }
        view.printCandies(model.checkCandiesLeft());
        boolean play = model.checkCandies();
        if (!play) {
            if (whoGoes) {
                view.botWin();
            } else
                view.youWin();
        }
        return play;
    }

    public void action() {
        getNumber();
    }

    public void saveGame() {
        model.saveGame();
    }

    public void loadGame() {
        model.loadGame();
    }
}
