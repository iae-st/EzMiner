package ezcoins.ezminer.items.constructors;

import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class Ingots extends ItemStack {

    public static List<Ingots> forgeableIngots = new ArrayList<>();
    public Ingots() {

    }

    public void isForgeable() {
        forgeableIngots.add(this);
    }
}
