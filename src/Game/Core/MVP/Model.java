package Game.Core.MVP;

import Game.Core.Bots.Bot;
import Game.Core.Game.Settings;
import Game.Core.Save;

public class Model {
    private Settings settings;
    private Save<Settings> mrSave;

    public Model() {
        this.mrSave = new Save<>();
    }

    public void setSettings(int totalCandies, int maxCanTake, boolean whoFirstGoes) { // 27 -> 6
        settings = new Settings(totalCandies, maxCanTake, whoFirstGoes);
    }

    public boolean isDigitString(String foCheck) {
        if (foCheck.isEmpty()) {
            return false;
        }
        for (char c : foCheck.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public int getNumber(String willBeNumber) {
        return Integer.parseInt(willBeNumber);
    }

    public boolean checkCandies() {
        return settings.checkCandies();
    }

    public boolean canTakeOrNot(int number) {
        settings.setTake(number);
        return settings.checkCanTake(settings);
    }

    public int botActivate() {
        Bot bot = new Bot();
        int take = bot.hardBot(settings);
        takeCandies(take);
        return take;
    }

    public void takeCandies(int take) {
        settings.setTake(take);
        settings.takeCandies();
    }

    public int checkCandiesLeft() {
        return settings.getTotalCandies();
    }

    public void saveGame() {
        mrSave.saveGame(settings);
    }

    public void loadGame() {
        this.settings = mrSave.loadGame(); // In the same memory!!
    }
}
