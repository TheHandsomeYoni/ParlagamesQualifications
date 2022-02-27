package me.thehandsomeyoni.parlagamesqualification.commands;

import me.thehandsomeyoni.parlagamesqualification.Utils.LoadItems;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;

import static me.thehandsomeyoni.parlagamesqualification.Main.getInventory;
import static me.thehandsomeyoni.parlagamesqualification.Statics.GetPlugin.getPlugin;

public class CreateItem implements CommandExecutor {
    private String[] information;
    private String message = "";
    private String name;
    private String material;
    private int slot;
    private ConfigurationSection items = getPlugin().getConfig().getConfigurationSection("items");
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) return false; // A quick check if the sender of the command is a player
        Player player = (Player) sender;

        if(!player.hasPermission("simpleplugin.createitem")){ // A check if the sender has permission to use this command
            player.sendMessage(ChatColor.RED + "Access Denied!");
            return false;
        }

        if(args.length < 4){ // A check if the arguments are matching the required standards
            player.sendMessage(ChatColor.RED + "Wrong usage! Please try:");
            player.sendMessage(ChatColor.RED + "/ci <name> <material (Make sure you switch space with '_')> <slot> <message>");
            return false;
        }

        try{ // An attempt to turn the second argument (slot number) to an integer. If and problem appear it will stop.
            slot = Integer.parseInt(args[2]);
        }catch (NumberFormatException e){
            player.sendMessage(ChatColor.RED + "No number was found to represent the slot of the item.");
            return false;
        }

        if(slot > 27){
            player.sendMessage(ChatColor.RED + "The biggest slot possible is 27!");
            return false;
        }

        for(int i = 3; i < args.length; i++){ // Add all arguments related to the message to one message
            message += args[i] + " ";
        }
        name = args[0];
        material = args[1];

        // -> Register info to the config.yml
        items.set(name + ".material", material.toUpperCase());
        items.set(name + ".slot", slot);
        items.set(name + ".message", message);
        getPlugin().saveConfig();

        new LoadItems(getInventory());
        player.sendMessage(ChatColor.GREEN + "Successfully created a new item");

        message = "";
        return true;
    }

    /*
    private String buildMessage(String[] arguments){ // Build a single message out of all of the arguments
        StringBuilder builder = new StringBuilder();
        for(String singleArgument: arguments){
            builder.append(singleArgument);
        }
        return builder.toString();
    }

     */
}
