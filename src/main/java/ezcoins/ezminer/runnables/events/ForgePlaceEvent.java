package ezcoins.ezminer.runnables.events;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockPlaceEvent;

public class ForgePlaceEvent extends BlockPlaceEvent {

    public ForgePlaceEvent(Block block, Player player) {
        super(block, block.getState(), player.getTargetBlockExact(5), player.getActiveItem(), player, true, player.getHandRaised());
    }

    public boolean validateForge() {
        return block.getType().equals(Material.BLAST_FURNACE);
    }

    public void createForge() {
        player.sendMessage("Created forge!");
    }

}
