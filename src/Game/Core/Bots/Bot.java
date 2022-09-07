package Game.Core.Bots;

import Game.Core.Game.Settings;

public class Bot {
    public int hardBot(Settings settings) {
        int botTake = settings.getTotalCandies() % (settings.getMaxCanTake() + settings.getMinCanTake());
        return settings.getMinCanTake() < botTake ? botTake : 1;
    }
}
