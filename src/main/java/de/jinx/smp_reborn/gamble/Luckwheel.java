package de.jinx.smp_reborn.gamble;

import de.jinx.smp_reborn.items.Souls;
import de.jinx.smp_reborn.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Luckwheel {

    static ArrayList<ItemStack> winnableItems = new ArrayList<>(Arrays.asList(
            new ItemBuilder(Material.PAPER).setName("§cNothing").setLore(":,(").build(),
            new ItemBuilder(Material.PAPER).setName("§cNothing").setLore(":,(").build(),
            new ItemBuilder(Material.PAPER).setName("§cNothing").setLore(":,(").build(),
            new ItemBuilder(Material.PAPER).setName("§cNothing").setLore(":,(").build(),
            new ItemBuilder(Material.PAPER).setName("§cNothing").setLore(":,(").build(),
            new ItemBuilder(Material.DEAD_BUSH).setName("§cNothing than just Trash").setLore("F").build(),
            new ItemBuilder(Material.DEAD_BUSH).setName("§cNothing than just Trash").setLore("F").build(),
            new ItemBuilder(Material.ACACIA_BOAT).setName("§bBoat").setLore("Whats special about a damn Boat???").build(),
            new ItemBuilder(Material.DIAMOND).setName("§bDiamond").setLore("Lucky...").setAmount(2).build(),
            new ItemBuilder(Material.DIAMOND).setName("§bDiamond").setLore("Lucky...").setAmount(2).build(),
            new ItemBuilder(Material.DIAMOND).setName("§bDiamond").setLore("Lucky...").setAmount(2).build(),
            new ItemBuilder(Material.SEA_PICKLE).setAmount(5).setName("§4§lForbidden §aPickle").setLore("It just travel 500.000 Blocks, ok!?").build(),
            new ItemBuilder(Material.SEA_PICKLE).setAmount(5).setName("§4§lForbidden §aPickle").setLore("It just travel 500.000 Blocks, ok!?").build(),
            new ItemBuilder(Material.NETHERITE_SCRAP).setName("§6§lShiny Thingy").setLore("Can be used to make Netherrite!").build(),
            Souls.creeperSword
            ));

    public static String TITLE = "§bLuckWheel";

    public static ArrayList<ItemStack> generateLuckItems(){
        ArrayList<ItemStack> shuffeldItems = winnableItems;
        Collections.shuffle(shuffeldItems);
        return shuffeldItems;
    }

    public static Inventory initLuckwheel(ArrayList<ItemStack> shuffeldItems) {
        Inventory inv = Bukkit.createInventory(null, 9 * 3, TITLE);
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName(" ").build());
        }

        int j = 0;
        for (int i = 9; i < 18; i++) {
            inv.setItem(i, shuffeldItems.get(j));
            j++;
        }

        for (int i = 18; i < 27; i++) {
            inv.setItem(i, new ItemBuilder(Material.RED_STAINED_GLASS_PANE).setName(" ").build());
        }

        inv.setItem(4, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
        inv.setItem(22, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());

        return inv;
    }
}
