package tech.ayham.coreify.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeSpectatorCommand implements CommandExecutor {

    private static final String PREFIX = ChatColor.GOLD + "Coreify » " + ChatColor.RESET;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("coreify.gmsp")) {
            if (args.length == 0) {
                // No parameter set, change sender's gamemode to spectator
                if (sender instanceof Player) {
                    Player player = (Player) sender;
                    player.setGameMode(GameMode.SPECTATOR);
                    player.sendMessage(PREFIX + ChatColor.GREEN + "Your gamemode has been set to Spectator.");
                } else {
                    sender.sendMessage(PREFIX + ChatColor.RED + "Only players can use this command without parameters.");
                }
            } else if (args.length == 1) {
                // Parameter set, change the specified player's gamemode to spectator
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    target.setGameMode(GameMode.SPECTATOR);
                    target.sendMessage(PREFIX + ChatColor.GREEN + "Your gamemode has been set to Spectator by " + sender.getName() + ".");
                    sender.sendMessage(PREFIX + ChatColor.GREEN + "You have set " + target.getName() + "'s gamemode to Spectator.");
                } else {
                    sender.sendMessage(PREFIX + ChatColor.RED + "Player not found.");
                }
            } else {
                sender.sendMessage(PREFIX + ChatColor.RED + "Usage: /gmsp [player]");
            }
            return true;
        } else {
            sender.sendMessage(PREFIX + ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }
    }
}
