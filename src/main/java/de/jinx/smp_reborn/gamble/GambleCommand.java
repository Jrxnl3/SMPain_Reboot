package de.jinx.smp_reborn.gamble;

import de.jinx.smp_reborn.SMP_Reboot;
import de.jinx.smp_reborn.items.Souls;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;

public class GambleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = ((Player) sender).getPlayer();

            if(label.equalsIgnoreCase("luckwheel")){
                if(p.getInventory().getItemInMainHand().isSimilar(Souls.evilSpirit)) {

                    ItemStack soul = p.getInventory().getItemInMainHand();
                    soul.setAmount(soul.getAmount() - 1);

                    p.getInventory().setItemInMainHand(soul);

                    int rdmSpinCounter = (int) (Math.random() * 30 + 10);

                    ArrayList<ItemStack> luckItems = Luckwheel.generateLuckItems();
                    Inventory gambleInv = Luckwheel.initLuckwheel(luckItems);

                    InventoryView invView = p.openInventory(gambleInv);

                    GamblePlayer gp = new GamblePlayer(p.getUniqueId(), luckItems, rdmSpinCounter, invView);
                    GambleScrollCooldown.gamblingPlayers.add(gp);
                } else p.sendMessage(SMP_Reboot.PREFIX +"You need one Evil Spirit!");
            }
        }
        return false;
    }
}