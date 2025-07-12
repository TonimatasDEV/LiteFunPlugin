package dev.tonimatas.litefun.skills;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class SkillLoader {
    private final File skillsFolder;

    public SkillLoader(File dataFolder) {
        this.skillsFolder = new File(dataFolder, "skills");
        if (!skillsFolder.exists()) skillsFolder.mkdirs();
    }

    public List<Skill> loadSkills() {
        List<Skill> skills = new ArrayList<>();
        for (File file : skillsFolder.listFiles((f) -> f.getName().endsWith(".yml"))) {
            FileConfiguration config = YamlConfiguration.loadConfiguration(file);
            Skill skill = SkillYamlParser.parse(config, file.getName().replace(".yml", ""));
            skills.add(skill);
        }
        return skills;
    }
}
