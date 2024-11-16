package dev.tonimatas.litefun;

import dev.tonimatas.litefun.util.Messages;
import net.milkbowl.vault2.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class LiteFunPlugin extends JavaPlugin {
    private static Economy econ = null;
    
    @Override
    public void onLoad() {
        Messages.sendConsole("LiteFun official plugins has been loaded successfully. (v" + getDescription().getVersion() + ")");
    }

    @Override
    public void onEnable() {
        Messages.sendConsole("LiteFun official plugins has been enabled successfully. (v" + getDescription().getVersion() + ")");
        
        // Setup economy logic
        if (!setupEconomy()) {
            Messages.sendConsole("[LiteFun] - Disabled due to no Vault dependency found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }

    @Override
    public void onDisable() {
        Messages.sendConsole("LiteFun official plugins has been disabled successfully.");
    }

    @SuppressWarnings("ConstantValue")
    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }
}
