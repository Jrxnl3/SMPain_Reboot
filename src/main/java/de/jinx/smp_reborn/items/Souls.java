package de.jinx.smp_reborn.items;

import de.jinx.smp_reborn.SMP_Reboot;
import de.jinx.smp_reborn.util.Chance;
import de.jinx.smp_reborn.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class Souls {
    //Main Souls
    public static ItemStack undeadSoul = new ItemBuilder(Material.ROTTEN_FLESH).setAmount(1).setLore("The Soul Drop of an Undead Creature.").setName("§7Undead §6Soul").addGlow().build();
    public static ItemStack peacefulSoul = new ItemBuilder(Material.FEATHER).setAmount(1).setLore("The Soul Drop of an Peacefully Living Creature. You Monster").setName("§ePeaceful §6Soul").addGlow().build();
    public static ItemStack waterSoul = new ItemBuilder(Material.INK_SAC).setAmount(1).setLore("The Soul Drop of an Aquatic Creature.").setName("§bWatery §6Soul").addGlow().build();
    public static ItemStack fireSoul = new ItemBuilder(Material.BLAZE_ROD).setAmount(1).setLore("The Soul Drop of a Fire Creature. §c§oIt still burns....").setName("§cFiery §6Soul").addGlow().build();

    //Fan Souls
    public static ItemStack raikoSoul = new ItemBuilder(Material.POTATO).setAmount(1).setLore("The Soul of a Raiko. Mostly found near Wardens!","Not very intelligent species").setName("§9Raiko §6Soul").addGlow().build();
    public static ItemStack witchSoul = new ItemBuilder(Material.SUGAR).setAmount(1).setLore("The Soul Drop of an Evil Witch","May be able to fly").setName("§2Witch §6Soul").addGlow().build();


    public static ItemStack evilSpirit = new ItemBuilder(Material.COD_BUCKET).setAmount(1).setLore("The Spirit of an §4§lAncient Evil Demon§r trapped inside a ... §oBucket?").setName("§4Evil §6Spirit").addGlow().build();

    //Swords
    public static ItemStack creeperSword = new ItemBuilder(Material.DIAMOND_SWORD).setAmount(1).setName("§a§lCreeper §rSword").setLore("§7Creeper Hit I","§lCreates an Explosion on Impact").addEnchantment(SMP_Reboot.creeperHitEnchantment,1,true).build();
    public static ItemStack jumpFeather = new ItemBuilder(Material.FEATHER).setAmount(1).setName("§3§lUpstream Feather").setLore("One Time use! Makes you jump higher").addEnchantment(SMP_Reboot.jumpo,1,true).build();
    public static ItemStack timberAxe = new ItemBuilder(Material.GOLDEN_AXE).setAmount(1).setName("§3§lBest Friend").setLore("§7Timber I","...for Lumberjacks").addEnchantment(SMP_Reboot.timber,1,true).build();
    public static ItemStack loggerAxe = new ItemBuilder(Material.IRON_AXE).setAmount(1).setName("§3§lLog4Tree").setLore("§7Loggers","Hopefully it doesnt break anything ;)","Btw drops exp when you break a wood log!").addEnchantment(SMP_Reboot.loggers,1,true).build();

    public static void spawnSoul(EntityDeathEvent e, ArrayList<EntityType> mobList, ItemStack soul, int chance){
        if(mobList.contains(e.getEntity().getType())) {
            if (Chance.hitChance(chance)) {
                e.getDrops().add(soul);
            }
        }
    }

    //Miscellaneous
    public static ItemStack curseLove = new ItemBuilder(Material.POPPY).setName("§4Two Hearts §cone Soul").setLore("Right click a Person to bind it to them ","Saves your death but inflicts pain to others","One Time use!").addGlow().build();

}