package me.thehandsomeyoni.parlagamesqualification.commands;

import me.thehandsomeyoni.parlagamesqualification.Utils.LoadItems;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import static me.thehandsomeyoni.parlagamesqualification.Main.getInventory;
import static me.thehandsomeyoni.parlagamesqualification.Statics.GetPlugin.getPlugin;

public class ReloadInventory implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) return false;
        Player player = (Player) sender;

        if(!player.hasPermission("simpleplugin.reloadinventory")){
            player.sendMessage(ChatColor.RED + "Access Denied!");
            return false;
        }

        if(args.length > 0){
            player.sendMessage(ChatColor.RED + "Wrong usage. Try: /reloadinventory");
            return false;
        }

        getInventory().clear();
        getPlugin().reloadConfig();
        new LoadItems(getInventory());
        player.sendMessage(ChatColor.GREEN + "Successfully reloaded the inventory");

        return true;
    }
}
