package de.jinx.smp_reborn.items.Entchantments;

import de.jinx.smp_reborn.SMP_Reboot;
import de.jinx.smp_reborn.util.Chance;
import de.jinx.smp_reborn.util.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.inventory.ItemStack;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Timber extends Enchantment implements Listener {

    public Timber(String namespace){
        super(new NamespacedKey(SMP_Reboot.getPlugin(), namespace));
    }

    ArrayList<Material> blocks = new ArrayList<>(Arrays.asList(
            Material.ACACIA_LOG,
            Material.BIRCH_LOG,
            Material.OAK_LOG,
            Material.DARK_OAK_LOG,
            Material.JUNGLE_LOG,
            Material.MANGROVE_LOG,
            Material.SPRUCE_LOG));

    //Define what happens for the enchant
    @EventHandler
    public void onPlayerHit(BlockBreakEvent e){
        //Check to see if a player hurt another entity
            Player player = e.getPlayer();

            ItemStack item = player.getInventory().getItemInMainHand();

            if (item.getEnchantments().containsKey(Enchantment.getByKey(SMP_Reboot.timber.getKey()))){
                if(blocks.contains(e.getBlock().getType())) {

                    if(Chance.hitChance(25)) {
                        ItemStack clonedBlock = new ItemBuilder(e.getBlock().getType()).build();
                        e.getBlock().getWorld().dropItemNaturally(e.getBlock().getLocation(),clonedBlock);
                    }
                }
        }
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.WEAPON;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public NamespacedKey getKey() {
        return super.getKey();
    }

    @Override
    public String getName() {
        return "Timber";
    }

    @Override
    public boolean isTreasure() {
        return false;
    }

    @Override
    public boolean isCursed() {
        return false;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return true;
    }

}
