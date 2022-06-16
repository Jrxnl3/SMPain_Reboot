package de.jinx.smp_reborn.gamble;

import de.jinx.smp_reborn.util.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.UUID;

public class GamblePlayer {
    private UUID playerUUID;
    private ArrayList<ItemStack> shuffeldLuckItems;
    private int scrollCount;
    private InventoryView luckInv;


    public GamblePlayer(UUID playerUUID, ArrayList<ItemStack> shuffeldLuckItems, int scrollCount, InventoryView luckInv) {
        this.playerUUID = playerUUID;
        this.shuffeldLuckItems = shuffeldLuckItems;
        this.scrollCount = scrollCount;
        this.luckInv = luckInv;
    }

    public void setInvHeader(Material pane){
        for (int i = 0; i < 9; i++) {
            luckInv.setItem(i,new ItemBuilder(pane).setName(" ").build());
        }
        for (int i = 18; i < 27; i++) {
            luckInv.setItem(i,new ItemBuilder(pane).setName(" ").build());
        }

        luckInv.setItem(4, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
        luckInv.setItem(22, new ItemBuilder(Material.BLACK_STAINED_GLASS_PANE).setName(" ").build());
    }

    public void won(){
        setInvHeader(Material.GREEN_STAINED_GLASS_PANE);
        Player p = Bukkit.getPlayer(playerUUID);
        ItemStack wonItem = luckInv.getItem(13);

        if(p.getInventory().firstEmpty() == -1){
            p.getWorld().dropItemNaturally(p.getLocation(),wonItem);
        }else {
            p.getInventory().addItem(wonItem);
        }
    }

    public void halftime(){
        setInvHeader(Material.YELLOW_STAINED_GLASS_PANE);
    }

    public UUID getPlayerUUID() {
        return playerUUID;
    }

    public ArrayList<ItemStack> getShuffeldLuckItems() {
        return shuffeldLuckItems;
    }

    public int getScrollCount() {
        return scrollCount;
    }

    public InventoryView getLuckInv() {
        return luckInv;
    }

    public void setScrollCount(int scrollCount) {
        this.scrollCount = scrollCount;
    }
}
