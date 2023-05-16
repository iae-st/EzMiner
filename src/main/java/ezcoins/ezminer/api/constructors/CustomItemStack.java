package ezcoins.ezminer.api.constructors;

import lombok.Getter;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CustomItemStack extends ItemStack {

    @Getter
    private static final List<CustomItemStack> allItems = new ArrayList<>();

    public CustomItemStack(@Nonnull ItemStack item) {
        super(item);

        allItems.add(this);
    }

    public CustomItemStack(@Nonnull ItemStack itemStack, @Nonnull Consumer<ItemMeta> consumer) {
        this(itemStack);
        ItemMeta im = this.getItemMeta();
        consumer.accept(im);
        this.setItemMeta(im);

        allItems.add(this);
    }

    public CustomItemStack(ItemStack itemStack, String name, String... lore) {
        this(itemStack, (im) -> {
            if (name != null) {
                im.setDisplayName(ChatColor.translateAlternateColorCodes('&', name));
            }

            if (lore.length > 0) {
                List<String> lines = new ArrayList<>();

                for (String line : lore) {
                    lines.add(ChatColor.translateAlternateColorCodes('&', line));
                }

                im.setLore(lines);
            }

        });

        allItems.add(this);
    }

}
