package de.jinx.smp_reborn.npcs;

import de.jinx.smp_reborn.items.Souls;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class WizardHandler implements Listener {
    @EventHandler
    public void villagerDamage(EntityDamageEvent e){

        if(e.getEntity().getCustomName() == null)
            return;

        if(e.getEntity().getCustomName().equals(WizardNPC.TITLE)){
            e.setCancelled(true);
        }
    }

    @EventHandler
    public void myTalkingWizard(PlayerInteractEntityEvent e) {
        if (e.getRightClicked().getCustomName() == null) return;
        if(!(e.getRightClicked().getType() == EntityType.VILLAGER)) return;

        if (e.getRightClicked().getCustomName().equals(WizardNPC.TITLE)) {

            if (e.getPlayer().isSneaking()) {
                WizardNPC.openGUI(e.getPlayer());
            }else {
                for (int i = 0; i < Dialogs.wizardDialog.size(); i++) {
                    e.getPlayer().sendMessage(WizardNPC.PREFIX + Dialogs.wizardDialog.get(i));
                }
                e.getPlayer().getInventory().addItem(Souls.jumpFeather);
            }

            e.setCancelled(true);
        }
    }
}
