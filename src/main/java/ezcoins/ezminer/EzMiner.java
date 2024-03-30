package ezcoins.ezminer;

import ez.iELib.Logger;
import ez.iELib.iELib;
import ezcoins.ezminer.managers.DatabaseManager;
import ezcoins.ezminer.managers.ListenerManager;
import lombok.Getter;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class EzMiner extends JavaPlugin {
    @Getter
    public static EzMiner plugin;
    @Getter
    public static Logger log;
    @Override
    public void onEnable() {
        plugin = this;
        iELib.assignPlugin(this);
        plugin.saveDefaultConfig();
        log = new Logger("&cEzMiner &7>");
        try {
            new DatabaseManager();
        } catch (Exception e) {
            log.warn(e.toString(), true);
        }
        ListenerManager listenerManager = new ListenerManager();
        getLog().log("EzMiner ready for takeoff!", true);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static PluginManager getPluginManager() {
        return plugin.getServer().getPluginManager();
    }
}
