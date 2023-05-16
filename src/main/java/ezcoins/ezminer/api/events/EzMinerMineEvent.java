package ezcoins.ezminer.api.events;

import jdk.internal.net.http.common.Cancelable;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.bukkit.event.block.BlockBreakEvent;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class EzMinerMineEvent extends BlockBreakEvent {


    @ParametersAreNonnullByDefault
    public EzMinerMineEvent(Block block, Player player) {
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
