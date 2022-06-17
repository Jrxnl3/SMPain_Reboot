package de.jinx.smp_reborn.items;

import de.jinx.smp_reborn.SMP_Reboot;
import de.jinx.smp_reborn.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class ShopItems {
    public static ItemStack timberAxeBuy = new ItemBuilder(Material.GOLDEN_AXE).setAmount(1).setName("§3§lBest Friend").setLore("Costs 5 Evil Spirits","Fortune but for Trees!").addEnchantment(SMP_Reboot.timber,1,true).build();
    public static ItemStack evilSpiritBuy = new ItemBuilder(Material.COD_BUCKET).setAmount(1).setLore("Costs 2 of each Soul").setName("§4Evil §6Spirit").addGlow().build();

}
