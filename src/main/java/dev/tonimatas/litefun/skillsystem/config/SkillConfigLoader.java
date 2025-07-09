package dev.tonimatas.litefun.skillsystem.config;

import dev.tonimatas.litefun.skillsystem.effect.SkillEffect;
import dev.tonimatas.litefun.skillsystem.skill.Skill;
import dev.tonimatas.litefun.skillsystem.skill.SkillManager;
import dev.tonimatas.litefun.skillsystem.stat.Stat;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SkillConfigLoader {
    public static void loadSkills(File dataFolder) {
        File file = new File(dataFolder, "skills.yml");
        FileConfiguration config = YamlConfiguration.loadConfiguration(file);

        Set<String> skillKeys = config.getKeys(false);

        for (String key : skillKeys) {
            String name = config.getString(key + ".name");
            List<SkillEffect> effects = new ArrayList<>();
            List<Stat> stats = new ArrayList<>();

            if (config.contains(key + ".effects")) {
                for (String effectStr : config.getStringList(key + ".effects")) {
                    String[] parts = effectStr.split(":");
                    effects.add(new SkillEffect(parts[0], Integer.parseInt(parts[1])));
                }
            }

            if (config.contains(key + ".stats")) {
                for (String effectStr : config.getStringList(key + ".stats")) {
                    String[] parts = effectStr.split(":");
                    stats.add(new Stat(parts[0], Double.parseDouble(parts[1])));
                }
            }

            Skill skill = new Skill(key, name, effects, stats);
            SkillManager.registerSkill(skill);
        }
    }
}
