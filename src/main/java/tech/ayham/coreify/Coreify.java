package tech.ayham.coreify;

import org.bukkit.plugin.java.JavaPlugin;
import tech.ayham.commands.GamemodeCreativeCommand;
import tech.ayham.coreify.commands.*;

public final class Coreify extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("coreifyreload").setExecutor(new CoreifyReloadCommand(this));
        getCommand("gmc").setExecutor(new GamemodeCreativeCommand());
        getCommand("gms").setExecutor(new GamemodeSurvivalCommand());
        getCommand("gma").setExecutor(new GamemodeAdventureCommand());
        getCommand("gmsp").setExecutor(new GamemodeSpectatorCommand());
        getServer().getPluginManager().registerEvents(new WelcomeMessage(this), this);
        saveDefaultConfig();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
