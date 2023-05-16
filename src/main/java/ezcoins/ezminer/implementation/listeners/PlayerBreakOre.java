package ezcoins.ezminer.implementation.listeners;

import ezcoins.ezminer.api.events.EzMinerMineEvent;
import lombok.NonNull;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class PlayerBreakOre implements Listener {
    @EventHandler
    private void onOreBreak(@NonNull BlockBreakEvent event) {
        EzMinerMineEvent mineEvent = new EzMinerMineEvent(event.getBlock(), event.getPlayer());
        mineEvent.sendMessage();

    }

}
