package dev.tonimatas.litefun.skillsystem.skill;

import java.util.HashMap;
import java.util.Map;

public class SkillManager {
    private static final Map<String, Skill> SKILLS = new HashMap<>();

    public static void registerSkill(Skill skill) {
        SKILLS.put(skill.getId(), skill);
    }

    public static Skill getSkill(String id) {
        return SKILLS.get(id);
    }

    public static Map<String, Skill> getAllSkills() {
        return SKILLS;
    }
}
