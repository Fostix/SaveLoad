package Game.Core;

import Game.Core.Game.Settings;

import java.util.HashMap;
import java.util.Map;

public class Save<G extends Settings> {
    private Map<String ,G> storage;// First Array maybe then in map or now uses map.

    public Save() {
        this.storage = new HashMap<>();
    }

    public void saveGame(String text, G g) { // Maybe need information about max min candies??!!
        // Condition array for user can make more than one save?
        storage.put(text, g);
    }

    public Settings loadGame(String text) { // If array need information.
        // If need for user cannot change information need return prototype.
        return storage.get(text).prototype();
    }

    public String getAllKeys() {
        // If don't saves need make something otherwise there will be error!!
        return storage.keySet().toString();
    }
}
