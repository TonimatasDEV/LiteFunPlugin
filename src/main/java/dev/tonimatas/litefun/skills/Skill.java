package dev.tonimatas.litefun.skills;

import java.util.List;

public interface Skill {
    String getId();
    String getName();
    String getDescription();
    int getLevelXpRequirement(int level);
    List<Reward> getRewardsForLevel(int level);
    List<XPGainMethod> getXpGainMethods();
}
