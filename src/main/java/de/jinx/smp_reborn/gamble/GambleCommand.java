package de.jinx.smp_reborn.gamble;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class GambleCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player){
            Player p = ((Player) sender).getPlayer();
            if(label.equalsIgnoreCase("luckwheel")){
                if(p.getInventory().getItemInMainHand().getType() == Material.DIAMOND){
                    Inventory wheel = Luckwheel.initLuckwheel();

                }
            }
        }
        return false;
    }
}
