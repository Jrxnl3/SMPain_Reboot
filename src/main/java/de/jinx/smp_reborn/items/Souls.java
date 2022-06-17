package de.jinx.smp_reborn.items;

import de.jinx.smp_reborn.SMP_Reboot;
import de.jinx.smp_reborn.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Souls {
    //TODO: Not being able to craft with them! Or just not worth it!
    public static ItemStack undeadSoul = new ItemBuilder(Material.ROTTEN_FLESH).setAmount(1).setLore("The Soul Drop of an Undead Creature.").setName("§7Undead §6Soul").addGlow().build();
    public static ItemStack peacefulSoul = new ItemBuilder(Material.FEATHER).setAmount(1).setLore("The Soul Drop of an Peacefully Living Creature. You Monster").setName("§ePeaceful §6Soul").addGlow().build();
    public static ItemStack waterSoul = new ItemBuilder(Material.INK_SAC).setAmount(1).setLore("The Soul Drop of an Aquatic Creature.").setName("§bWatery §6Soul").addGlow().build();
    public static ItemStack fireSoul = new ItemBuilder(Material.BLAZE_ROD).setAmount(1).setLore("The Soul Drop of a Fire Creature. §c§oIt still burns....").setName("§cFiery §6Soul").addGlow().build();
    public static ItemStack evilSpirit = new ItemBuilder(Material.COD_BUCKET).setAmount(1).setLore("The Spirit of an §4§lAncient Evil Demon§r trapped inside a ... §oBucket?").setName("§4Evil §6Spirit").addGlow().build();
    public static ItemStack evilSpiritBuy = new ItemBuilder(Material.COD_BUCKET).setAmount(1).setLore("Costs 2 of each Soul").setName("§4Evil §6Spirit").addGlow().build();

    //Swords
    public static ItemStack creeperSword = new ItemBuilder(Material.DIAMOND_SWORD).setAmount(1).setName("§a§lCreeper §rSword").setLore("§lCreates an Explosion on Impact","Creeper Hit I").addEnchantment(SMP_Reboot.creeperHitEnchantment,1,true).build();
    public static ItemStack jumpFeather = new ItemBuilder(Material.FEATHER).setAmount(1).setName("§3§lUpstream Feather").setLore("One Time use! Makes you jump higher").addEnchantment(SMP_Reboot.jumpo,1,true).build();
}