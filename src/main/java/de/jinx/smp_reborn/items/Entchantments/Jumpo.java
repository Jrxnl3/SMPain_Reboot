package de.jinx.smp_reborn.items.Entchantments;

import de.jinx.smp_reborn.SMP_Reboot;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Jumpo extends Enchantment implements Listener {

    public Jumpo(String namespace){
        super(new NamespacedKey(SMP_Reboot.getPlugin(), namespace));
    }

    @EventHandler
    public void onFeatherUse(PlayerInteractEvent e){
        //Check to see if a player hurt another entity
            Player player = e.getPlayer();

            //see if they are holding a sword with the enchant
            ItemStack item = player.getInventory().getItemInMainHand();

            if (item.getEnchantments().containsKey(Enchantment.getByKey(SMP_Reboot.jumpo.getKey()))){
                player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP,20,4,false));
                player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() -1 );
            }
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.WEAPON;
    }

    @Override
    public int getMaxLevel() {
        return 2;
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
        return "Jumpo";
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
