package ezcoins.ezminer.managers;

import ezcoins.ezminer.EzMiner;
import ezcoins.ezminer.implementation.listeners.PlayerBreakOre;
import org.bukkit.event.Listener;

public class ListenerManager {
    public ListenerManager() {
        addListener(new PlayerBreakOre());
    }

    private void addListener(Listener listener) {
        EzMiner.getPluginManager().registerEvents(listener, EzMiner.getPlugin());
    }
}
