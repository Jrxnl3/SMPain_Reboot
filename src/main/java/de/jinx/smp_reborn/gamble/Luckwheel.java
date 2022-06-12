package de.jinx.smp_reborn.gamble;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Luckwheel {
    public static Inventory initLuckwheel(){
        Inventory inv = Bukkit.createInventory(null,9*3,"LuckWheel");
        for (int i = 0; i < 9; i++) {
            inv.setItem(i,new ItemStack(Material.BLUE_STAINED_GLASS_PANE));
        }
        for (int i = 18; i < 27; i++) {
            inv.setItem(i,new ItemStack(Material.BLUE_STAINED_GLASS_PANE));
        }

        return inv;
    }

    //TODO Roatating items as Function + cooldown for that
    //public static
}
