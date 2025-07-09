package dev.tonimatas.litefun;

import dev.tonimatas.litefun.skillsystem.config.SkillConfigLoader;
import dev.tonimatas.litefun.skillsystem.skill.SkillManager;
import dev.tonimatas.litefun.util.Messages;
import net.milkbowl.vault2.economy.Economy;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class LiteFunPlugin extends JavaPlugin {
    private static Economy econ = null;
    
    @Override
    public void onLoad() {
        Messages.sendConsole("LiteFun official plugins has been loaded successfully. (v" + getPluginMeta().getVersion() + ")");
    }

    @Override
    public void onEnable() {
        Messages.sendConsole("LiteFun official plugins has been enabled successfully. (v" + getPluginMeta().getVersion() + ")");
        
        // Setup economy logic
        if (!setupEconomy()) {
            Messages.sendConsole("[LiteFun] - Disabled due to no Vault economy plugin found!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        SkillConfigLoader.loadSkills(getDataFolder());
        Messages.sendConsole("[LiteFun] - Skills cargadas: " + SkillManager.getAllSkills().size());
    }

    @Override
    public void onDisable() {
        Messages.sendConsole("LiteFun official plugins has been disabled successfully.");
    }

    @SuppressWarnings("ConstantValue")
    private boolean setupEconomy() {
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
