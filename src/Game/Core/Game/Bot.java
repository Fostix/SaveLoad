package Game.Core.Game;

public class Bot {
    public int hardBot(int candies, int max, int min) {
        int botTake = candies % (max + min);
        return min < botTake ? botTake : 1;
    }
}
