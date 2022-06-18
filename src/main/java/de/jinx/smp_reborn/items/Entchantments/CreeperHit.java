package de.jinx.smp_reborn.items.Entchantments;

import de.jinx.smp_reborn.SMP_Reboot;
import de.jinx.smp_reborn.util.Chance;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class CreeperHit extends Enchantment implements Listener {

    public CreeperHit(String namespace){
        super(new NamespacedKey(SMP_Reboot.getPlugin(), namespace));
    }

    //Define what happens for the enchant
    @EventHandler
    public void onPlayerHitMob(EntityDamageByEntityEvent e){
        //Check to see if a player hurt another entity
        if (e.getDamager() instanceof Player){
            Player player = ((Player) e.getDamager()).getPlayer();

            //see if they are holding a sword with the enchant
            ItemStack item = player.getInventory().getItemInMainHand();

            if (item.getEnchantments().containsKey(Enchantment.getByKey(SMP_Reboot.creeperHitEnchantment.getKey()))){
                if(Chance.hitChance(30)) {
                    LivingEntity victim = (LivingEntity) e.getEntity();

                    victim.getLocation().getWorld().createExplosion(victim.getLocation(), (float) Chance.rdmNr(0.2,0.7d), false, false);
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
        return "Creeper Hit";
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
