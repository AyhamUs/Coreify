package tech.ayham.coreify;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class WelcomeMessage implements Listener {

    private final JavaPlugin plugin;

    public WelcomeMessage(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        List<String> welcomeMessages = plugin.getConfig().getStringList("welcome-message");
        for (String line : welcomeMessages) {
            event.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', line));
        }
    }
}