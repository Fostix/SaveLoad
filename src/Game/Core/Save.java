package Game.Core;

public class Save {
    private int condition;

    public void saveGame(int candies) { // Maybe need information about max min candies??!!
        // Condition array for user can make more than one save?
        this.condition = candies;
    }

    public int loadGame() { // If array need information.
        // If need for user cannot change information need return prototype.
        return this.condition;
    }
}
