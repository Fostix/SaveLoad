package Game.Core.Bots;

import Game.Core.Game.Settings;

public class Bot {
    public int hardBot(Settings settings) { // int candies, int max, int min
        int botTake = settings.getTotalCandies() % (settings.getMaxCanTake() + settings.getMinCanTake());
        // int botTake = candies % (max + min);
        return settings.getMinCanTake() < botTake ? botTake : 1;
    }
}
