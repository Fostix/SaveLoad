package Game.Core.Game;

public class Settings implements IMrCloneable<Settings>{
    private int totalCandies;
    private int maxCanTake;
    private boolean whoFirstGoes;
    private int minCanTake;
    private int take;

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

    public boolean checkCanTake(Settings takeCandies) {
        checkTotalAndMax();
        return this.take > this.maxCanTake || take < this.minCanTake;
    }
    
    public void checkTotalAndMax() {
        if (this.totalCandies < this.maxCanTake)
            this.maxCanTake = this.totalCandies;
    }

    public int getTotalCandies() {
        return totalCandies;
    }

    public void setTake(int take) {
        this.take = take;
    }

    public int getMaxCanTake() {
        return maxCanTake;
    }

    public boolean isWhoFirstGoes() {
        return whoFirstGoes;
    }

    public int getMinCanTake() {
        return minCanTake;
    }

    public void takeCandies() {
        this.totalCandies -= this.take;
    }

    @Override
    public Settings prototype() {
        return new Settings(getTotalCandies(), getMaxCanTake(), isWhoFirstGoes());
    }
}
