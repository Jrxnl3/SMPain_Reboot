package de.jinx.smp_reborn.npcs;

import de.jinx.smp_reborn.items.Souls;
import de.jinx.smp_reborn.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.inventory.Inventory;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class WizardNPC {
    public static final String TITLE = "§bWizard";
    public static final String PREFIX = "§bWizard §6>> §b";

    public static void openGUI(Player player) {
        Inventory inv = Bukkit.createInventory(null,9*3,TITLE);

        for (int i = 0; i <inv.getSize(); i++) {

            inv.setItem(i,new ItemBuilder(Material.GRAY_STAINED_GLASS_PANE).setName("").build());
        }

        //Evil Spirit
        inv.setItem(13,Souls.evilSpiritBuy);

        player.openInventory(inv);
    }

    public static void createWizardNPC(Location loc){
        Villager wizard = (Villager) loc.getWorld().spawnEntity(loc, EntityType.VILLAGER);
        wizard.setAI(true);
        wizard.setCustomName("§bWizard");
        wizard.setCustomNameVisible(true);
        wizard.setProfession(Villager.Profession.LIBRARIAN);
        wizard.addPotionEffect(new PotionEffect(PotionEffectType.SLOW,Integer.MAX_VALUE,255,false,false));
    }
}
