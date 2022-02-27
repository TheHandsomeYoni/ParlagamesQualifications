package me.thehandsomeyoni.parlagamesqualification;

import me.thehandsomeyoni.parlagamesqualification.Listeners.ItemClickListener;
import me.thehandsomeyoni.parlagamesqualification.Utils.LoadItems;
import me.thehandsomeyoni.parlagamesqualification.commands.CreateItem;
import me.thehandsomeyoni.parlagamesqualification.commands.OpenInventory;
import me.thehandsomeyoni.parlagamesqualification.commands.ReloadInventory;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Main extends JavaPlugin {

    public static Inventory inventory;


    @Override
    public void onEnable() {
        // -> Register Commands
        getCommand("createitem").setExecutor(new CreateItem());
        getCommand("openinv").setExecutor(new OpenInventory());
        getCommand("reloadinv").setExecutor(new ReloadInventory());

        // -> Register Listeners
        getServer().getPluginManager().registerEvents(new ItemClickListener(), this);


        // -> Register Config
        getConfig().options().copyDefaults();
        saveDefaultConfig();

        // -> Set up other things
        inventory = Bukkit.createInventory(null, 27, "Pick an Item");
        new LoadItems(inventory);
    }

    @Override
    public void onDisable() {
    }


    // -> Static reference to the inventory
    public static Inventory getInventory(){
        return inventory;
    }
}
