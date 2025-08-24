package dev.tonimatas.litefun.configs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class BaseConfig {
    private FileConfiguration custom = null;
    private final File customFile;
    private final JavaPlugin plugin;
    private final String name;

    public BaseConfig(JavaPlugin plugin, String name) {
        this.customFile = new File(plugin.getDataFolder(), name);
        this.plugin = plugin;
        this.name = name;
    }

    public FileConfiguration get() {
        if (custom == null) {
            reload();
        }

        return custom;
    }

    public void reload() {
        custom = YamlConfiguration.loadConfiguration(customFile);
        Reader defConfigStream = new InputStreamReader(Objects.requireNonNull(plugin.getResource(name)), StandardCharsets.UTF_8);
        YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
        custom.setDefaults(defConfig);
    }

    public void save() {
        try {
            custom.save(customFile);
        } catch (IOException var1) {
            IOException var2 = var1;
            var2.printStackTrace();
        }

    }

    public void registerCustom() {
        if (!customFile.exists()) {
            get().options().copyDefaults(true);
            save();
        }
    }
}
