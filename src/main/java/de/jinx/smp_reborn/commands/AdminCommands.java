package de.jinx.smp_reborn.commands;

import de.jinx.smp_reborn.SMP_Reboot;
import de.jinx.smp_reborn.gamble.Luckwheel;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;

public class AdminCommands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player = (Player) sender;

        if(player.getUniqueId().toString().equals("a9fe96e0-d85e-4146-b08d-9735f244a34f")) {
            if (label.equalsIgnoreCase("broadcast")) {
                String text = formateArgs(args);

                Bukkit.broadcastMessage(SMP_Reboot.PREFIX + text);

            } else if (label.equalsIgnoreCase("rename")) {
                if (player.getLevel() >= 1) {
                    if (player.getInventory().getItemInMainHand().getType() != Material.AIR) {
                        String text = formateArgs(args);

                        ItemMeta itemMeta = player.getInventory().getItemInMainHand().getItemMeta();
                        itemMeta.setDisplayName(text);

                        player.setLevel(player.getLevel() - 1);
                        player.getInventory().getItemInMainHand().setItemMeta(itemMeta);
                    } else
                        player.sendMessage(SMP_Reboot.PREFIX + "You dont have an Item your Main Hand!");
                } else
                    player.sendMessage(SMP_Reboot.PREFIX + "§cYou dont have enough levels to rename!");

            } else if (label.equalsIgnoreCase("testString")) {
                String text = formateArgs(args);
                player.sendMessage(text);
            }
        }
        return false;
    }

    //Formats & to §, for Colour purpose stuff
    public String formateArgs(String[] argsToFormat){
        String text = "";
        for (int i = 0; i < argsToFormat.length; i++) {

            text += argsToFormat[i].replace("&","§") + " ";
        }
        return text;
    }
/*
    public String formateString(String stringToFormat){
        return stringToFormat.replace("&","§");
    }
*/
}
