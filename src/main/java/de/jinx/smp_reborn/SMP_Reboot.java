package de.jinx.smp_reborn;

import de.jinx.smp_reborn.commands.AdminCommands;
import de.jinx.smp_reborn.commands.StartSMPCommand;
import de.jinx.smp_reborn.config.ConfigManager;
import de.jinx.smp_reborn.events.SMP_Listeners;
import de.jinx.smp_reborn.events.SoulsDropListeners;
import de.jinx.smp_reborn.gamble.GambleCommand;
import de.jinx.smp_reborn.gamble.LuckwheelHandler;
import de.jinx.smp_reborn.items.Entchantments.CreeperHit;
import de.jinx.smp_reborn.items.Entchantments.Jumpo;
import de.jinx.smp_reborn.items.Entchantments.Timber;
import de.jinx.smp_reborn.npcs.NPC_GUIHandler;
import de.jinx.smp_reborn.npcs.WizardHandler;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;

public final class SMP_Reboot extends JavaPlugin {

    public static String PREFIX = "§2SM§aPain §bReboot§6 >> §r";

    private static SMP_Reboot plugin;
    private ConfigManager cfg;

    private static int gambleSchedularID;

    public static ArrayList<Enchantment> custom_enchants = new ArrayList<>();
    public static CreeperHit creeperHitEnchantment;
    public static Jumpo jumpo;
    public static Timber timber;

    @Override
    public void onEnable() {
        plugin = this;
        // Plugin startup logic
        System.out.println("Started SMPain Reboot Plugin");

        creeperHitEnchantment = new CreeperHit("creeperhit");
        jumpo = new Jumpo("jumpo");
        timber = new Timber("timber");

        cfg = new ConfigManager();

        //ADMIN Commands
        this.getCommand("broadcast").setExecutor(new AdminCommands());
        this.getCommand("rename").setExecutor(new AdminCommands());
        this.getCommand("testString").setExecutor(new AdminCommands());
        this.getCommand("setspawn").setExecutor(new AdminCommands());
        this.getCommand("spawnActive").setExecutor(new AdminCommands());
        this.getCommand("createWizard").setExecutor(new AdminCommands());
        this.getCommand("customItems").setExecutor(new AdminCommands());
        this.getCommand("startSMP").setExecutor(new StartSMPCommand());

        //User Commands
        this.getCommand("luckwheel").setExecutor(new GambleCommand());

        //Listeners
        PluginManager pl = Bukkit.getPluginManager();
        pl.registerEvents(new SMP_Listeners(), this);
        pl.registerEvents(new SoulsDropListeners(), this);
        pl.registerEvents(new WizardHandler(), this);
        pl.registerEvents(new NPC_GUIHandler(), this);
        pl.registerEvents(new LuckwheelHandler(), this);

        //Enchantments
        custom_enchants.add(creeperHitEnchantment);
        custom_enchants.add(jumpo);
        custom_enchants.add(timber);

        registerEnchantment(creeperHitEnchantment);
        registerEnchantment(jumpo);
        registerEnchantment(timber);

        //Enchantment Events
        pl.registerEvents(creeperHitEnchantment, this);
        pl.registerEvents(jumpo, this);
        pl.registerEvents(timber, this);


    }

    @Override
    public void onDisable() {
        SMP_Reboot.getPlugin().getCfgManager().save();

        try {
            Field keyField = Enchantment.class.getDeclaredField("byKey");

            keyField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<NamespacedKey, Enchantment> byKey = (HashMap<NamespacedKey, Enchantment>) keyField.get(null);

            for (Enchantment enchantment : custom_enchants){
                byKey.remove(enchantment.getKey());
            }

            //TODO: Needed?
            Field nameField = Enchantment.class.getDeclaredField("byName");

            nameField.setAccessible(true);
            @SuppressWarnings("unchecked")
            HashMap<String, Enchantment> byName = (HashMap<String, Enchantment>) nameField.get(null);

            for (Enchantment enchantment : custom_enchants){
                byName.remove(enchantment.getName());
            }
        } catch (Exception ignored) { }

    }

    public static void registerEnchantment(Enchantment enchantment){
        boolean registered = true;
        try{
            Field f = Enchantment.class.getDeclaredField("acceptingNew");
            f.setAccessible(true);
            f.set(null,true);
            Enchantment.registerEnchantment(enchantment);
        }catch (Exception e){
            registered = false;
            e.printStackTrace();
        }
        if(registered){
            System.out.println("Registered the enchantment: " + enchantment);
        }
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

    public static int getGambleSchedularID() {
        return gambleSchedularID;
    }

}
