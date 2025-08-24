package dev.tonimatas.litefun.skills;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class SkillManager {
    private static final Map<String, Skill> SKILLS = new HashMap<>();

    public static void register(Skill skill) {
        if (SKILLS.containsKey(skill.getId())) {
            throw new IllegalStateException("Skill '" + skill.getId() + "' is already registered");
        }
        SKILLS.put(skill.getId(), skill);
    }

    public static void clear() {
        SKILLS.clear();
    }

    public static Skill get(String id) {
        return SKILLS.get(id);
    }

    public static Collection<Skill> getAll() {
        return Collections.unmodifiableCollection(SKILLS.values());
    }
}