package dev.tonimatas.litefun;

import dev.tonimatas.litefun.util.Messages;
import org.bukkit.plugin.java.JavaPlugin;

public class LiteFunPlugin extends JavaPlugin {
    @Override
    public void onLoad() {
        Messages.sendConsole("LiteFun official plugins has been loaded successfully.");
    }

    @Override
    public void onEnable() {
        Messages.sendConsole("LiteFun official plugins has been enabled successfully.");
    }

    @Override
    public void onDisable() {
        Messages.sendConsole("LiteFun official plugins has been disabled successfully.");
    }
}
