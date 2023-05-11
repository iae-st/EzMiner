package ezcoins.ezminer.api.constructors;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class EzMinerIngot extends ItemStack {

    public static List<EzMinerIngot> forgeableIngots = new ArrayList<>();
    public EzMinerIngot() {

    }

    public void isForgeable() {
        forgeableIngots.add(this);
    }
}
