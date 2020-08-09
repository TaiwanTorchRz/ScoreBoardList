package gittorch.scoreboardlist;

import org.bukkit.Bukkit;

import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

public class ScoreBoardList extends JavaPlugin {

    private ConfigManager config;

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("Enable Plugin..");
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerBoard(this), this);
        try {
            config = new ConfigManager(this);
            config.setup();
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
