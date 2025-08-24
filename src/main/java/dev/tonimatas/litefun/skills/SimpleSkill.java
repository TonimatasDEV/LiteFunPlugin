package dev.tonimatas.litefun.skills;

import java.util.List;
import java.util.stream.Collectors;

public class SimpleSkill implements Skill {
    private final String id, name, description;
    private final List<Integer> xpRequirements;
    private final List<Reward> rewards;
    private final List<XPGainMethod> xpGainMethods;

    public SimpleSkill(String id, String name, String description,
                       List<Integer> xpRequirements,
                       List<Reward> rewards,
                       List<XPGainMethod> xpGainMethods) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.xpRequirements = xpRequirements;
        this.rewards = rewards;
        this.xpGainMethods = xpGainMethods;
    }

    @Override
    public String getId() { return id; }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    @Override
    public int getLevelXpRequirement(int level) {
        return level - 1 < xpRequirements.size() ? xpRequirements.get(level - 1) : xpRequirements.get(xpRequirements.size() - 1);
    }

    @Override
    public List<Reward> getRewardsForLevel(int level) {
        return rewards.stream()
                .filter(r -> level >= r.getStartLevel() && level <= r.getEndLevel())
                .collect(Collectors.toList());
    }

    @Override
    public List<XPGainMethod> getXpGainMethods() {
        return xpGainMethods;
    }
}
