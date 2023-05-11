package ezcoins.ezminer.api.events;

import jdk.internal.net.http.common.Cancelable;
import lombok.Getter;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;

public class EzMinerMineEvent extends Event implements Cancelable {

    private static final HandlerList HANDLER_LIST = new HandlerList();

    @Getter
    private final Location location;

    @Getter
    private final Player player;
    private boolean cancelled;

    @ParametersAreNonnullByDefault
    public EzMinerMineEvent(Location location, Player player) {
        this.location = location;
        this.player = player;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLER_LIST;
    }

    @Override
    public boolean cancel(boolean mayInterruptIfRunning) {
        return cancelled;
    }

    public void setCancelled(boolean cancelled) {
        this.cancelled = cancelled;
    }
}
