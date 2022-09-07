package Game.Core.Game;

import java.util.HashMap;
import java.util.Map;

public class Save<G extends Settings> {
    private Map<String ,G> storage;

    public Save() {
        this.storage = new HashMap<>();
    }

    public void saveGame(String text, G g) {
        storage.put(text, g);
    }

    public Settings loadGame(String text) {
        return storage.get(text).prototype();
    }

    public String getAllKeys() {
        return storage.keySet().toString();
    }
}
