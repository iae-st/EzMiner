package ezcoins.ezminer;

import ezcoins.ezminer.managers.ListenerManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class EzMiner extends JavaPlugin {
    public static EzMiner plugin;
    @Override
    public void onEnable() {
        plugin = this;
        ListenerManager listenerManager = new ListenerManager();
        this.getLogger().info("EzMiner ready for takeoff!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static EzMiner getPlugin() {
        return plugin;
    }

    public static PluginManager getPluginManager() {
        return plugin.getServer().getPluginManager();
    }
}
