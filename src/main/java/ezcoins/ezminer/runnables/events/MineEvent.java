package ezcoins.ezminer.runnables.events;

import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;

import javax.annotation.ParametersAreNonnullByDefault;

public class MineEvent extends BlockBreakEvent {


    @ParametersAreNonnullByDefault
    public MineEvent(Block block, Player player) {
        super(block, player);
    }

    @Override
    public void setCancelled(boolean cancel) {
        super.setCancelled(cancel);
    }

    public void sendMessage() {
        super.getPlayer().sendMessage("Test");
    }


}
