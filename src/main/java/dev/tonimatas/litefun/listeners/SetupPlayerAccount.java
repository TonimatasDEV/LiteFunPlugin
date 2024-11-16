package dev.tonimatas.litefun.listeners;

import dev.tonimatas.litefun.LiteFunPlugin;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class SetupPlayerAccount implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        // Create the player account if it doesn't exist
        if (!LiteFunPlugin.getEconomy().hasAccount(event.getPlayer().getUniqueId())) {
            LiteFunPlugin.getEconomy().createAccount(event.getPlayer().getUniqueId(), event.getPlayer().getName());
        }
    }
}
