package de.jinx.smp_reborn;

import de.jinx.smp_reborn.commands.AdminCommands;
import de.jinx.smp_reborn.commands.StartSMPCommand;
import de.jinx.smp_reborn.config.ConfigManager;
import de.jinx.smp_reborn.events.SMP_Listeners;
import de.jinx.smp_reborn.events.SoulsDropListeners;
import de.jinx.smp_reborn.gamble.GambleCommand;
import de.jinx.smp_reborn.gamble.GambleScrollCooldown;
import de.jinx.smp_reborn.gamble.LuckwheelHandler;
import de.jinx.smp_reborn.npcs.NPC_GUIHandler;
import de.jinx.smp_reborn.npcs.WizardHandler;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SMP_Reboot extends JavaPlugin {

    public static String PREFIX = "§2SM§aPain §bReboot§6 >> §r";
    private static SMP_Reboot plugin;
    private ConfigManager cfg;

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        System.out.println("Started SMPain Reboot Plugin");

        cfg = new ConfigManager();

        this.getCommand("broadcast").setExecutor(new AdminCommands());
        this.getCommand("rename").setExecutor(new AdminCommands());
        this.getCommand("testString").setExecutor(new AdminCommands());
        this.getCommand("setspawn").setExecutor(new AdminCommands());
        this.getCommand("spawnActive").setExecutor(new AdminCommands());
        this.getCommand("createWizard").setExecutor(new AdminCommands());

        this.getCommand("startSMP").setExecutor(new StartSMPCommand());
        this.getCommand("luckwheel").setExecutor(new GambleCommand());

        PluginManager pl = Bukkit.getPluginManager();
        pl.registerEvents(new SMP_Listeners(), this);
        pl.registerEvents(new SoulsDropListeners(), this);
        pl.registerEvents(new WizardHandler(), this);
        pl.registerEvents(new NPC_GUIHandler(), this);
        pl.registerEvents(new LuckwheelHandler(), this);

        GambleScrollCooldown.ScrollActive();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        SMP_Reboot.getPlugin().getCfgManager().save();
    }

    public static SMP_Reboot getPlugin() {
        return plugin;
    }

    public ConfigManager getCfgManager() {
        return cfg;
    }
    public FileConfiguration getCfg(){
        return getCfgManager().getCfg();
    }
}
