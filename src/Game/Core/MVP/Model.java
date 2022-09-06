package Game.Core.MVP;

import Game.Core.Game.Logic;
import Game.Core.Game.Settings;

public class Model {
    Settings settings;
    Logic game;

    public Settings getSettings() {
        return settings;
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

    public void setLogic() {
        game = new Logic(settings);
    }
}
