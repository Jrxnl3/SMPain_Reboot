package de.jinx.smp_reborn.npcs;

import de.jinx.smp_reborn.items.ShopItems;
import de.jinx.smp_reborn.items.Souls;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class NPC_GUIHandler implements Listener {

    @EventHandler
    public void handleWizardShop(InventoryClickEvent e) {
        if (!(e.getWhoClicked() instanceof Player))
            return;

        Player p = (Player) e.getWhoClicked();

        if (!canUse(e))
            return;

        //EVIL SPIRIT
        if (e.getCurrentItem().isSimilar(ShopItems.evilSpiritBuy)) {
                //TODO Buy Mechanism
                int[] slots = new int[4];
                slots[0] = getSlotOfItem(p,Souls.peacefulSoul,2);
                slots[1] = getSlotOfItem(p,Souls.fireSoul,2);
                slots[2] = getSlotOfItem(p,Souls.waterSoul,2);
                slots[3] = getSlotOfItem(p,Souls.undeadSoul,2);

                for (int j : slots) {
                    if (j == -1) {
                        e.setCancelled(true);
                        return;
                    }
                }

                for (int slot : slots) {
                    ItemStack item = p.getInventory().getItem(slot);
                    item.setAmount(item.getAmount() - 5);
                    p.getInventory().setItem(slot, item);
                }

            givePlayerItem(p,Souls.evilSpirit);

        }else if(e.getCurrentItem().isSimilar(ShopItems.timberAxeBuy)){
            if(p.getInventory().contains(Souls.evilSpirit,2)){
                int count = 0;
                for (ItemStack item: p.getInventory().getContents()) {
                    if(item != null && item.isSimilar(Souls.evilSpirit)) {
                        item.setAmount(item.getAmount() - 1);
                        count++;
                        if(count >= 2)
                            break;
                    }
                }
                givePlayerItem(p,Souls.timberAxe);

            }
        }
        e.setCancelled(true);
    }

    public boolean canUse(InventoryClickEvent e) {
        if (!e.getView().getTitle().equals(WizardNPC.TITLE))
            return false;

        if (e.getCurrentItem() == null)
            return false;

        if (e.getCurrentItem().getType() == Material.GRAY_STAINED_GLASS_PANE)
            e.setCancelled(true);

        if (!e.getCurrentItem().hasItemMeta())
            return false;

        return true;
    }

    public boolean hasAvaliableSlot(Player player) {
        Inventory inv = player.getInventory();
        for (ItemStack item : inv.getStorageContents()) {
            if (item == null) {
                System.out.println("Got Space!");
                return true;
            }
        }
        return false;
    }

    public int getSlotOfItem(Player p,ItemStack lookingForItem, int amount){
        int i = 0;
        for (ItemStack itemInInv : p.getInventory().getContents()) {
            if(itemInInv != null){
                if(itemInInv.isSimilar(lookingForItem))
                    if(itemInInv.getAmount() >= amount)
                        return i;
            }
            i++;
        }
        return -1;
    }

    public void givePlayerItem(Player p, ItemStack item){
        if(hasAvaliableSlot(p))
            p.getInventory().addItem(item);
        else
            p.getWorld().dropItem(p.getLocation(),item);
    }
}
