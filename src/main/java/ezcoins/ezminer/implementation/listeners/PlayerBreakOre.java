package ezcoins.ezminer.implementation.listeners;

import ezcoins.ezminer.runnables.events.MineEvent;
import lombok.NonNull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakOre implements Listener {
    @EventHandler
    private void onOreBreak(@NonNull BlockBreakEvent event) {
        MineEvent mineEvent = new MineEvent(event.getBlock(), event.getPlayer());
        mineEvent.sendMessage();

    }

}
