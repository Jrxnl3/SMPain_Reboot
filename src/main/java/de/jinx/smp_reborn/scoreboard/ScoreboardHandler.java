package de.jinx.smp_reborn.scoreboard;

import de.jinx.smp_reborn.SMP_Reboot;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;

public class ScoreboardHandler {

    public static void createScoreboard(Player p){
        Scoreboard scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        Objective obj = scoreboard.registerNewObjective("smp_scoreboard", "dummy", "§6<< §r"+SMP_Reboot.PREFIX);
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.getScore("").setScore(8);
        obj.getScore("§4§lVisit").setScore(7);
        obj.getScore("§asmpain.de").setScore(6);
        obj.getScore(" ").setScore(5);
        obj.getScore("§6§lObjective").setScore(4);
        obj.getScore("§aGather §4§lEvil Spirits").setScore(3);
        obj.getScore("  ").setScore(2);
        obj.getScore("§d§lDiscord:").setScore(1);
        obj.getScore("§adiscord.gg/wUUKbk7eaz").setScore(0);

        p.setScoreboard(scoreboard);
    }
}
