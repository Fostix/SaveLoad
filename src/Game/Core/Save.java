package Game.Core;

import Game.Core.Game.Settings;

import java.util.Map;

public class Save<G extends Settings> {
    private Map<Integer ,G> storage;// First Array maybe then in map or now uses map.
    public void saveGame(G g) { // Maybe need information about max min candies??!!
        // Condition array for user can make more than one save?
        storage.put(0, g);
    }

    public G loadGame() { // If array need information.
        // If need for user cannot change information need return prototype.
        return storage.get(0);
    }
}
