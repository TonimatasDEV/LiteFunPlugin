package dev.tonimatas.litefun.skillsystem.effect;

public class SkillEffect {
    private final String type;
    private final int level;

    public SkillEffect(String type, int level) {
        this.type = type;
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public String getType() {
        return type;
    }
}
