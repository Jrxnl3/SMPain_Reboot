package de.jinx.smp_reborn.gamble;

import de.jinx.smp_reborn.SMP_Reboot;
import org.bukkit.Bukkit;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class GambleScrollCooldown {
    public static ArrayList<GamblePlayer> gamblingPlayers = new ArrayList<>();

    public static void ScrollActive(){
        Bukkit.getScheduler().scheduleSyncRepeatingTask(SMP_Reboot.getPlugin(), new Runnable() {
            @Override
            public void run() {
                if(gamblingPlayers.size() > 0) {
                    for (GamblePlayer gbp : gamblingPlayers) {
                        if(gbp.getScrollCount() > 0) {
                            ArrayList<ItemStack> luckItems = gbp.getShuffeldLuckItems();


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
                            gbp.setScrollCount(gbp.getScrollCount() -1);

                            if(gbp.getScrollCount() < ((int)(gbp.getScrollCount() / 2))){
                                gbp.halftime();
                            }
                        }else{
                            gbp.won();
                            gamblingPlayers.remove(gbp);
                        }
                    }
                }
            }
        },0L,20L);

    }
}
