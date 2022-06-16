package de.jinx.smp_reborn.gamble;

import de.jinx.smp_reborn.SMP_Reboot;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class GambleScrollCooldown {
    public static ArrayList<GamblePlayer> gamblingPlayers = new ArrayList<>();

    public static void ScrollActive(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(SMP_Reboot.getPlugin(), new Runnable() {
            @Override
            public void run() {
                try {
                    if (gamblingPlayers.size() > 0) {
                        for (GamblePlayer gbp : gamblingPlayers) {
                            if (gbp.getScrollCount() > 0) {
                                ArrayList<ItemStack> luckItems = gbp.getShuffeldLuckItems();

                                //Scrolling Algorythem
                                for (int i = 1; i < luckItems.size(); i++) {
                                    ItemStack tmpItem = luckItems.get(i);
                                    luckItems.set(i, luckItems.get(i - 1));
                                    luckItems.set(i - 1, tmpItem);
                                }

                                //Setting scrolled list
                                int j = 0;
                                for (int i = 9; i < 18; i++) {
                                    gbp.getLuckInv().setItem(i, luckItems.get(j));
                                    j++;
                                }

                                //Half Time
                                if((gbp.getMaxCount() / 2 ) >= gbp.getScrollCount()){
                                    gbp.halftime();
                                }else
                                    Bukkit.getPlayer(gbp.getPlayerUUID()).getWorld().playSound(Bukkit.getPlayer(gbp.getPlayerUUID()), Sound.BLOCK_NOTE_BLOCK_SNARE,3,1);


                                gbp.setScrollCount(gbp.getScrollCount() - 1);
                            } else {
                                gbp.won();
                                gamblingPlayers.remove(gbp);
                            }
                        }
                    }
                }catch (Exception ignored){}
            }
        },0L,20L);
    }
}
