package de.jinx.smp_reborn.events;

import de.jinx.smp_reborn.items.ItemMobList;
import de.jinx.smp_reborn.items.Souls;
import de.jinx.smp_reborn.util.Chance;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

public class SoulsDropListeners implements Listener {

    @EventHandler
    public void onUndeadDeaths(EntityDeathEvent e){
        Souls.spawnSoul(e,ItemMobList.undeadList, Souls.undeadSoul,5);
    }

    @EventHandler
    public void onWitchDeaths(EntityDeathEvent e){
        if(e.getEntity().getType() == EntityType.WITCH) {
            if (Chance.hitChance(20)) {
                e.getDrops().add(Souls.witchSoul);
            }
        }
    }

    @EventHandler
    public void onPeacefulDeaths(EntityDeathEvent e){
        Souls.spawnSoul(e,ItemMobList.peacefulList,Souls.peacefulSoul,5);
    }

    @EventHandler
    public void onWaterDeaths(EntityDeathEvent e){
        Souls.spawnSoul(e,ItemMobList.waterList,Souls.waterSoul,5);
    }

    @EventHandler
    public void onFireDeaths(EntityDeathEvent e){
        Souls.spawnSoul(e,ItemMobList.fireList,Souls.fireSoul,5);
    }
}
