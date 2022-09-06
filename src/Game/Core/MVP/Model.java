package Game.Core.MVP;

import Game.Core.Bots.Bot;
import Game.Core.Game.Settings;

public class Model {
    Settings settings;

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
}
