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
            beNumber = String.valueOf(beNumber.contains("save"));
            if (beNumber.contains("save"))// Here need check save and load word.
                System.out.println(beNumber);
                if (!checkSaveText(beNumber))

            if (beNumber.equals("load")) { // then which for what would be choice
                String saves = model.showSaveInformations();
                view.showSaves(saves);
                loadGame();
            }
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

    private boolean checkSaveText(String text) {
        //beNumber = String.valueOf(beNumber.contains("save"))
        System.out.println(text);
        text = String.valueOf(text.substring(5)); //here error
        if (text.isEmpty()) {
            System.out.println("bad don't work");
            return false;
        }
            model.saveGame(text);
        System.out.println("good moment");
        return true;
    }

    public void loadGame() {
        model.loadGame();
    }
}
