package me.thehandsomeyoni.parlagamesqualification.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import static me.thehandsomeyoni.parlagamesqualification.Main.getInventory;

public class OpenInventory implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) return false;

        Player player = (Player) sender;

        if(args.length > 0){
            player.sendMessage(ChatColor.RED + "Wrong usage. Try: /openinv");
            return false;
        }

        player.openInventory(getInventory());





        return true;
    }
}
