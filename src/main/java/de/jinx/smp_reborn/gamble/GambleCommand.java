package de.jinx.smp_reborn.gamble;

import de.jinx.smp_reborn.SMP_Reboot;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class GambleCommand implements CommandExecutor {

    //TODO: Gets overriden when some else uses it at the same time :(
    int id;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = ((Player) sender).getPlayer();
            if(label.equalsIgnoreCase("luckwheel")){
                final int[] rdmSpinCounter = {(int) (Math.random() * 30 + 20)};

                ArrayList<ItemStack> luckItems =  Luckwheel.generateLuckItems();
                Inventory gambleInv = Luckwheel.initLuckwheel(luckItems);

                p.openInventory(gambleInv);

                id = Bukkit.getScheduler().scheduleSyncRepeatingTask(SMP_Reboot.getPlugin(), new Runnable() {
                    @Override
                    public void run() {
                        if(rdmSpinCounter[0] > 0) {
                            for (int i = 1; i < luckItems.size(); i++) {
                                ItemStack tmpItem = luckItems.get(i);
                                luckItems.set(i, luckItems.get(i - 1));
                                luckItems.set(i - 1, tmpItem);
                            }

                            int j = 0;
                            for (int i = 9; i < 18; i++) {
                                gambleInv.setItem(i, luckItems.get(j));
                                j++;
                            }
                            rdmSpinCounter[0]--;
                            System.out.println(rdmSpinCounter[0]);
                        }else {
                            //TODO: Change to Winning Inv, give Player Item

                            Bukkit.getScheduler().cancelTask(id);
                        }
                        System.out.println("Running");
                    }
                }, 0L, 10L);
            }
        }
        return false;
    }
}
