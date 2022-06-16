package de.jinx.smp_reborn.gamble;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class LuckwheelHandler implements Listener {
    @EventHandler
    public void handleLuckInv(InventoryClickEvent e){
        if (!(e.getWhoClicked() instanceof Player))
            return;
        if (e.getView().getTitle().equals(Luckwheel.TITLE))
            e.setCancelled(true);
    }
}
