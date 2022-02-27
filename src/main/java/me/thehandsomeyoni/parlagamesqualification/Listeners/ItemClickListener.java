package me.thehandsomeyoni.parlagamesqualification.Listeners;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import static me.thehandsomeyoni.parlagamesqualification.Statics.GetPlugin.getPlugin;

public class ItemClickListener implements Listener {
    private int slot;

    @EventHandler
    public void itemClickEvent(InventoryClickEvent event){
        ConfigurationSection items = getPlugin().getConfig().getConfigurationSection("items");

        slot = event.getSlot() + 1;
        event.setCancelled(true);
        for(String key : items.getKeys(false)){
            if(Integer.parseInt(items.get(key + ".slot").toString()) == slot &&
                    event.getCurrentItem().getType().name().equalsIgnoreCase(items.get(key + ".material").toString())){
                event.getWhoClicked().closeInventory();
                event.getWhoClicked().sendMessage(ChatColor.translateAlternateColorCodes('&',
                        items.get(key + ".message").toString()));
            }
        }
    }

}
