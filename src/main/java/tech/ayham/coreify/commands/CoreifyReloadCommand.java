package tech.ayham.coreify.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class CoreifyReloadCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public CoreifyReloadCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("coreify.reload")) {
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.GOLD + "Coreify » " + ChatColor.GREEN + "Configuration reloaded.");
            return true;
        } else {
            sender.sendMessage(ChatColor.GOLD + "Coreify » " + ChatColor.RED + "You do not have permission to use this command.");
            return true;
        }
    }
}