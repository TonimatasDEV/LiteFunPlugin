package dev.tonimatas.litefun.listeners;

import dev.tonimatas.litefun.skills.Skill;
import dev.tonimatas.litefun.skills.SkillManager;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Material broken = event.getBlock().getType();

        if (broken != Material.STONE && broken != Material.IRON_ORE && broken != Material.DEEPSLATE_IRON_ORE) {
            return;
        }

        Skill mining = SkillManager.get("mining");
        if (mining == null) return;
    }
}
