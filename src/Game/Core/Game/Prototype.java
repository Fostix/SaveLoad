package Game.Core.Game;

public class Prototype<S extends Settings> {
    Settings clone(S s) {
        return new Settings(s.getTotalCandies(), s.getMaxCanTake(), s.isWhoFirstGoes());
    }
}
