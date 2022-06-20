package de.jinx.smp_reborn.commands;

import de.jinx.smp_reborn.SMP_Reboot;
import de.jinx.smp_reborn.gamble.Luckwheel;
import de.jinx.smp_reborn.items.Souls;
import de.jinx.smp_reborn.npcs.WizardNPC;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
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
            }else if(label.equalsIgnoreCase("createWizard")){
                WizardNPC.createWizardNPC(player.getLocation());
                player.sendMessage(SMP_Reboot.PREFIX+"Created Wizard!");
            }else if(label.equalsIgnoreCase("customItems")){
                player.getInventory().addItem(Souls.creeperSword);
                player.getInventory().addItem(Souls.jumpFeather);
                player.getInventory().addItem(Souls.timberAxe);
                player.getInventory().addItem(Souls.loggerAxe);
            }else if(label.equalsIgnoreCase("souls")){
                player.getInventory().addItem(Souls.waterSoul);
                player.getInventory().addItem(Souls.fireSoul);
                player.getInventory().addItem(Souls.undeadSoul);
                player.getInventory().addItem(Souls.peacefulSoul);
                player.getInventory().addItem(Souls.raikoSoul);
                player.getInventory().addItem(Souls.witchSoul);
            }else if(label.equalsIgnoreCase("printInfo")){
                ItemStack item = player.getInventory().getItemInMainHand();
                player.sendMessage(item.getEnchantments().toString());
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
