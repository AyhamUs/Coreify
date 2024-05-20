package tech.ayham.coreify.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if(!(sender instanceof Player)){
            sender.sendMessage(ChatColor.GOLD + "Coreify » " + ChatColor.RED + "This command can only be used by players.");
            return true;
        }
        Player player = (Player) sender;
        if (player.hasPermission("coreify.fly")) {
            if (player.getAllowFlight()) {
                player.setAllowFlight(false);
                player.sendMessage(ChatColor.GOLD + "Coreify » " + ChatColor.RED + "Fly mode disabled.");
            } else {
                player.setAllowFlight(true);
                player.sendMessage(ChatColor.GOLD + "Coreify » " + ChatColor.GREEN + "Fly mode enabled.");
            }
        } else {
            player.sendMessage(ChatColor.GOLD + "Coreify » " + ChatColor.RED + "You do not have permission to use this command.");
        }
        return true;
    }
}
