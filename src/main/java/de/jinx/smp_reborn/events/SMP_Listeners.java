package de.jinx.smp_reborn.events;

import de.jinx.smp_reborn.SMP_Reboot;
import de.jinx.smp_reborn.items.Souls;
import de.jinx.smp_reborn.scoreboard.ScoreboardHandler;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

public class SMP_Listeners implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e){
        e.setJoinMessage(SMP_Reboot.PREFIX+e.getPlayer().getName()+" has joined us. :)");
        System.out.println(e.getPlayer().getAddress().getAddress());
        ScoreboardHandler.createScoreboard(e.getPlayer());
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e){
        e.setQuitMessage(SMP_Reboot.PREFIX +"Oh :(. " + e.getPlayer().getName()+" has left the Game.");
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent e){
        Player p = e.getEntity();

        System.out.println("Death Location X:"+p.getLocation().getBlockX() + " Y: "+p.getLocation().getBlockY()+ " Z: "+p.getLocation().getBlockZ());

        if(p.getUniqueId().equals("945f99b5-2db4-4880-bb80-da3a4445c067")){
            e.setDeathMessage(SMP_Reboot.PREFIX + "Oh. §6"+p.getName()+" just fucking died of a heatstroke.");
        }else if(p.getUniqueId().equals("047bb7af-dbd0-475b-bb60-1bf0a859a47e")){
            e.setDeathMessage(SMP_Reboot.PREFIX+"§6§l"+p.getName()+ "§6§lchoked on damn rice again!");
        }else
            e.setDeathMessage(SMP_Reboot.PREFIX + "§6" + p.getName() + " made a terrible choice. :(\n§6F");


        p.sendMessage("§cYou died at X:"+p.getLocation().getBlockX() + " Y: "+p.getLocation().getBlockY()+ " Z: "+p.getLocation().getBlockZ());
    }
}
