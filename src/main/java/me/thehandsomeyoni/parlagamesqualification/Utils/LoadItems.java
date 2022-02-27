package me.thehandsomeyoni.parlagamesqualification.Utils;

import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import static me.thehandsomeyoni.parlagamesqualification.Statics.GetPlugin.getPlugin;

public class LoadItems {
    private ConfigurationSection itemsSection = getPlugin().getConfig().getConfigurationSection("items");
    public LoadItems(Inventory inventory){
        for(String key : itemsSection.getKeys(false)){
            inventory.setItem(Integer.parseInt(itemsSection.get(key + ".slot").toString()) -1,
                    new ItemStack(Material.getMaterial(itemsSection.get(key + ".material").toString())));
        }
    }
}
