package gittorch.scoreboardlist;

import org.bukkit.Bukkit;

import org.bukkit.plugin.java.JavaPlugin;

public class ScoreBoardList extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        Bukkit.getConsoleSender().sendMessage("Enable Plugin..");
        Bukkit.getServer().getPluginManager().registerEvents(new PlayerBoard(this), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
