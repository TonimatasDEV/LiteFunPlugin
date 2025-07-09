package dev.tonimatas.litefun.skillsystem.skill;

import dev.tonimatas.litefun.skillsystem.effect.SkillEffect;
import dev.tonimatas.litefun.skillsystem.stat.Stat;
import org.bukkit.Effect;

import java.util.List;

public class Skill {
    private final String id;
    private final String displayName;
    private final List<SkillEffect> effects;
    private final List<Stat> stats;

    public Skill(String id, String displayName, List<SkillEffect> effects, List<Stat> stats) {
        this.id = id;
        this.displayName = displayName;
        this.effects = effects;
        this.stats = stats;
    }

    public String getId() {
        return id;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public List<SkillEffect> getEffects() {
        return effects;
    }

    public String getDisplayName() {
        return displayName;
    }
}
