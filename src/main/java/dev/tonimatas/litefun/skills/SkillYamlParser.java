package dev.tonimatas.litefun.skills;

import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SkillYamlParser {
    public static Skill parse(FileConfiguration config, String id) {


        String name = config.getString("name");
        String description = config.getString("description");

        List<Integer> xpRequirements = config.getIntegerList("xp-requirements");

        List<Reward> rewards = new ArrayList<>();
        for (String rewardId : config.getStringList("rewards")) {
            ConfigurationSection reward = getSectionOfSection(config, "rewards", rewardId);
            int levels = reward.getInt("levels");
            int startLevel = reward.getInt("start-level", 1);
            int endLevel = reward.getInt("end-level", Integer.MAX_VALUE);
            rewards.add(new Reward(rewardId, levels, startLevel, endLevel));
        }

        List<XPGainMethod> gainMethods = new ArrayList<>();
        for (String gainMethod : config.getStringList("xp-gain-methods")) {
            ConfigurationSection section = getSectionOfSection(config, "xp-gain-methods", gainMethod);
            String trigger = section.getString("trigger");
            double multiplier = section.getDouble("multiplier");
            List<String> entities = new ArrayList<>();
            if (section.getKeys(false).contains("filters")) {
                Map<String, Object> filters = (Map<String, Object>) section.getMapList("filters");
                entities = (List<String>) filters.getOrDefault("entities", Collections.emptyList());
            }
            gainMethods.add(new XPGainMethod(trigger, multiplier, entities));
        }

        return new SimpleSkill(id, name, description, xpRequirements, rewards, gainMethods);
    }

    private static @NotNull ConfigurationSection getSectionOfSection(FileConfiguration config, String first, String second) {
        return Objects.requireNonNull(
                Objects.requireNonNull(
                        config.getConfigurationSection(first)
                ).getConfigurationSection(second)
        );
    }
}
