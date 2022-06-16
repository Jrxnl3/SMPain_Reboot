package de.jinx.smp_reborn.gamble;

import de.jinx.smp_reborn.SMP_Reboot;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
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
                int rdmSpinCounter = (int) (Math.random() * 30 + 20);

                ArrayList<ItemStack> luckItems =  Luckwheel.generateLuckItems();
                Inventory gambleInv = Luckwheel.initLuckwheel(luckItems);

                InventoryView invview = p.openInventory(gambleInv);

                GamblePlayer gp = new GamblePlayer(p.getUniqueId(),luckItems,rdmSpinCounter,invview);
                GambleScrollCooldown.gamblingPlayers.add(gp);
            }
        }
        return false;
    }
}
