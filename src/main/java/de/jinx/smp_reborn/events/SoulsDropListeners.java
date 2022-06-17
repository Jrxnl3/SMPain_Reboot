package de.jinx.smp_reborn.events;

import de.jinx.smp_reborn.items.Souls;
import de.jinx.smp_reborn.util.Chance;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import java.util.ArrayList;
import java.util.Arrays;

public class SoulsDropListeners implements Listener {

    //TODO: May be uncomplete
    ArrayList<EntityType> undeadList = new ArrayList<>(Arrays.asList(EntityType.ZOMBIE,EntityType.SKELETON,EntityType.CREEPER,EntityType.ZOMBIE_VILLAGER,EntityType.SLIME,EntityType.DROWNED));
    ArrayList<EntityType> peacefulList = new ArrayList<>(Arrays.asList(EntityType.COW,EntityType.PIG,EntityType.CHICKEN,EntityType.FOX,EntityType.SHEEP));
    ArrayList<EntityType> waterList = new ArrayList<>(Arrays.asList(EntityType.COD,EntityType.GLOW_SQUID,EntityType.SQUID,EntityType.SALMON,EntityType.GUARDIAN,EntityType.ELDER_GUARDIAN));
    ArrayList<EntityType> fireList = new ArrayList<>(Arrays.asList(EntityType.BLAZE,EntityType.WITHER_SKELETON,EntityType.ZOMBIFIED_PIGLIN,EntityType.PIGLIN,EntityType.MAGMA_CUBE,EntityType.HOGLIN));

    @EventHandler
    public void onUndeadDeaths(EntityDeathEvent e){
        if(undeadList.contains(e.getEntity().getType())) {
            if (Chance.hitChance(5)) {
                e.getDrops().add(Souls.undeadSoul);
            }
        }
    }

    @EventHandler
    public void onPeacefulDeaths(EntityDeathEvent e){
        if(peacefulList.contains(e.getEntity().getType())) {
            if (Chance.hitChance(5)) {
                e.getDrops().add(Souls.peacefulSoul);
            }
        }
    }

    @EventHandler
    public void onWaterDeaths(EntityDeathEvent e){
        if(waterList.contains(e.getEntity().getType())) {
            if (Chance.hitChance(5)) {
                e.getDrops().add(Souls.waterSoul);
            }
        }
    }

    @EventHandler
    public void onFireDeaths(EntityDeathEvent e){
        if(fireList.contains(e.getEntity().getType())) {
            if (Chance.hitChance(5)) {
                e.getDrops().add(Souls.fireSoul);
            }
        }
    }
}
