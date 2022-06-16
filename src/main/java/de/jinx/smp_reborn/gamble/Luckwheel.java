package de.jinx.smp_reborn.gamble;

import de.jinx.smp_reborn.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Luckwheel {

    static ArrayList<ItemStack> winnableItems = new ArrayList<>(Arrays.asList(
            new ItemStack(Material.ACACIA_BOAT),
            new ItemStack(Material.ACACIA_BOAT),
            new ItemStack(Material.ACACIA_BOAT),
            new ItemStack(Material.ACACIA_BOAT),
            new ItemStack(Material.FEATHER),
            new ItemStack(Material.FEATHER),
            new ItemStack(Material.FEATHER),
            new ItemStack(Material.FEATHER),
            new ItemStack(Material.FEATHER),
            new ItemStack(Material.DIAMOND),
            new ItemStack(Material.DIAMOND),
            new ItemStack(Material.DIAMOND)
    ));

    public static ArrayList<ItemStack> generateLuckItems(){
        ArrayList<ItemStack> shuffeldItems = winnableItems;
        Collections.shuffle(shuffeldItems);
        return shuffeldItems;
    }

    public static Inventory initLuckwheel(ArrayList<ItemStack> shuffeldItems) {
        Inventory inv = Bukkit.createInventory(null, 9 * 3, "LuckWheel");
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName(" ").build());
        }

        int j = 0;
        for (int i = 9; i < 18; i++) {
            inv.setItem(i, shuffeldItems.get(j));
            j++;
        }

        for (int i = 18; i < 27; i++) {
            inv.setItem(i, new ItemBuilder(Material.BLUE_STAINED_GLASS_PANE).setName(" ").build());
        }

        inv.setItem(4, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
        inv.setItem(22, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());

        return inv;
    }
}
