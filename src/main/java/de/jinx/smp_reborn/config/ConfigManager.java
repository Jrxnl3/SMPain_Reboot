package de.jinx.smp_reborn.config;

import de.jinx.smp_reborn.SMP_Reboot;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import java.io.File;
import java.io.IOException;

public class ConfigManager {
    File file;
    FileConfiguration cfg;


    public ConfigManager() {
        file = new File(SMP_Reboot.getPlugin().getDataFolder() + File.separator + "config.yml");
        cfg = YamlConfiguration.loadConfiguration(file);
    }

    public File getFile() {
        return file;
    }

    public FileConfiguration getCfg() {
        return cfg;
    }

    public void reload(){
        file = new File(SMP_Reboot.getPlugin().getDataFolder() + File.separator + "config.yml");
        cfg = YamlConfiguration.loadConfiguration(file);
    }

    public void save(){
        try {
            cfg.save(file);
        } catch (IOException e) {
            Bukkit.getServer().getConsoleSender().sendMessage(SMP_Reboot.PREFIX + "§aCould not save" + file.getName() + ".");
        }
    }
}
