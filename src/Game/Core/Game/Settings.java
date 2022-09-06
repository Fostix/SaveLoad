package Game.Core.Game;

public class Settings {
    private int totalCandies;
    private int maxCanTake;
    private boolean whoFirstGoes;
    private int minCanTake;

    public Settings(int totalCandies, int maxCanTake, boolean whoFirstGoes) {
        this.totalCandies = totalCandies;
        this.maxCanTake = maxCanTake;
        this.whoFirstGoes = whoFirstGoes;
        this.minCanTake = 1;
    }

    public boolean checkCandies() {
        return totalCandies > 0;
    }

    /** For check what more max can take or candies */
    public boolean checkWhatMore() {
        if (totalCandies < maxCanTake) {
            this.maxCanTake = this.totalCandies;
            return true;
        }
        return false;
    }

    public boolean checkCanTake(int take) {
        return take > this.maxCanTake || take < this.minCanTake;
    }

    //public boolean moreOrLess() {}

    public int getMaxCanTake() {
        return maxCanTake;
    }

    public boolean isWhoFirstGoes() {
        return whoFirstGoes;
    }

    public int getMinCanTake() {
        return minCanTake;
    }


}
