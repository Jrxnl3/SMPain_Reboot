package de.jinx.smp_reborn.items.Entchantments;

import de.jinx.smp_reborn.SMP_Reboot;
import de.jinx.smp_reborn.items.ItemCategorys;
import de.jinx.smp_reborn.util.Chance;
import org.bukkit.Effect;
import org.bukkit.NamespacedKey;
import org.bukkit.Particle;
import org.bukkit.Sound;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

public class Loggers extends Enchantment implements Listener {

    public Loggers(String namespace){
        super(new NamespacedKey(SMP_Reboot.getPlugin(), namespace));
    }


    @EventHandler
    public void onWoodBreakXP(BlockBreakEvent e){
        Player player = e.getPlayer();

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getEnchantments().containsKey(Enchantment.getByKey(SMP_Reboot.loggers.getKey()))){
            if(ItemCategorys.woodBlocks.contains(e.getBlock().getType())) {

                if(Chance.hitChance(18)) {
                    ExperienceOrb orb = player.getWorld().spawn(e.getBlock().getLocation(), ExperienceOrb.class);
                    orb.setExperience(1);
                    player.getWorld().playSound(e.getPlayer().getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT,2f,1f);
                    player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY,e.getBlock().getLocation(),5,0.2d,0,0.2d);
                }
            }
        }
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public int getMaxLevel() {
        return 0;
    }

    @Override
    public int getStartLevel() {
        return 0;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return null;
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
    public boolean conflictsWith(Enchantment enchantment) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack itemStack) {
        return false;
    }
}
