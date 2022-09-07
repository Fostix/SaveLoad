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
        int totalCandies = getNumber();
        view.setMaxCanTakeCandiesText();
        int maxCanTake = getNumber();
        view.whoGoesFirst();
        String whoFirst = view.enterInConsole();
        this.whoGoes = whoGoesFirst(whoFirst.toLowerCase());
        model.setSettings(totalCandies, maxCanTake, whoGoes);
    }

    public int inGame() {
        String beNumber = "";
        int count = 0;
        do {
            beNumber = view.enterInConsole();
            if (beNumber.contains("save ")) {
                if (!saving(beNumber))
                    view.badSave();
                view.saveGood();
                view.sayTakeCandies();
            }
            if (beNumber.equals("load")) {
                String saves = model.showSaveInformations();
                view.showSaves(saves);
            }
            if (beNumber.contains("load ")) {
                int forRemoveTrashWord = 5;
                loadGame(beNumber.substring(forRemoveTrashWord));
                view.sayTakeCandies();
            }
            count++;
        } while (!model.isDigitString(beNumber));
        if (count > 1) {
            view.itIsNumber();
        }
        return model.getNumber(beNumber);
    }

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

    public boolean playing() {
        if (whoGoes) {
            int take;
            do {
                view.sayTakeCandies();
                take = inGame();
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

    private boolean saving(String text) {
        text = text.substring(5);
        if (text.isEmpty())
            return false;
        model.saveGame(text);
        return true;
    }

    public void loadGame(String text) {
        model.loadGame(text);
    }
}
