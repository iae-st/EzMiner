package ezcoins.ezminer.implementation.listeners;

import ezcoins.ezminer.runnables.events.ForgePlaceEvent;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class PlayerPlaceForge implements Listener {
    private void onForgePlace(BlockPlaceEvent event) {
        ForgePlaceEvent forgePlaceEvent = new ForgePlaceEvent(event.getBlockPlaced(), event.getPlayer());
        if(!forgePlaceEvent.validateForge()) return;

    }
}
