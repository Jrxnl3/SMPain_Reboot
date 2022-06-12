package de.jinx.smp_reborn.commands;

import com.connorlinfoot.titleapi.TitleAPI;
import de.jinx.smp_reborn.SMP_Reboot;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.FireworkMeta;
import java.util.ArrayList;
import java.util.Arrays;

public class StartSMPCommand implements CommandExecutor {
    ArrayList<String> initphaseText = new ArrayList<>(Arrays.asList(
            "§bInitilizing SMPain...",
            "§75",
            "§74",
            "§73",
            "§72",
            "§71",
            "§7§l..."
    ));
    ArrayList<String> errorphaseText = new ArrayList<>(Arrays.asList(
            "§4§lFailed! ERROR 418!"
    ));
    ArrayList<String> rebootphaseText = new ArrayList<>(Arrays.asList(
            "§1§bTrying to reboot...",
            "§75",
            "§74",
            "§73",
            "§72",
            "§71",
            "§7...",
            "§2§lSucesfully Rebooted!",
            "§bHave Fun! :)"
    ));
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            if(((Player) sender).getUniqueId().toString().equals("a9fe96e0-d85e-4146-b08d-9735f244a34f")) {
                if (label.equalsIgnoreCase("startSMP")) {
                    System.out.println("Command");
                    Bukkit.getScheduler().scheduleSyncRepeatingTask(SMP_Reboot.getPlugin(), new Runnable() {
                        int phase = 1;
                        int i = 0;
                        @Override
                        public void run() {
                            switch (phase){
                                case 1:
                                    for(Player p : Bukkit.getOnlinePlayers()) {
                                        TitleAPI.sendTitle(p,initphaseText.get(i),null,0,2 *20, 20);
                                    }
                                    if(i + 1>= initphaseText.size()){
                                        phase++;
                                        i = -1;
                                    }
                                    break;
                                case 2:
                                    for(Player p : Bukkit.getOnlinePlayers()) {
                                        TitleAPI.sendTitle(p,errorphaseText.get(i),null,0,2 *20, 20);
                                    }
                                    if(i+1 >= errorphaseText.size()){
                                        phase++;
                                        i = -1;
                                    }
                                    break;
                                case 3:
                                    for(Player p : Bukkit.getOnlinePlayers()) {
                                        TitleAPI.sendTitle(p,rebootphaseText.get(i),null,0,2 *20, 20);
                                    }
                                    if(i+1 >= rebootphaseText.size()){
                                        phase++;
                                        i = -1;
                                    }
                                    break;
                                case 4:
                                    for(Player p : Bukkit.getOnlinePlayers()) {
                                        Firework fw = (Firework) p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
                                        FireworkMeta fwm = fw.getFireworkMeta();

                                        fwm.setPower(2);
                                        fwm.addEffect(FireworkEffect.builder().withColor(Color.AQUA).flicker(true).build());

                                        fw.setFireworkMeta(fwm);                                    }
                                    Bukkit.getScheduler().cancelTasks(SMP_Reboot.getPlugin());
                                    break;
                            }
                            i++;
                        }
                    }, 0L, 3 * 20L);

                }
            }
        }
        return false;
    }
}
