package gittorch.scoreboardlist;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.logging.Level;

public class ConfigManager{
    private static File file;
    private static FileConfiguration customFile;
    public ScoreBoardList plugin;
    private static String fileName = "config.yml";

    public ConfigManager(ScoreBoardList plugin) throws IOException, InvalidConfigurationException {
        this.plugin = plugin;
        setup();
    }

    //找到或建立設定檔案
    public void setup() throws IOException, InvalidConfigurationException {
        File dataFolder = new File(String.valueOf(this.plugin.getDataFolder()));
        dataFolder.mkdir();
        file = new File(this.plugin.getDataFolder(), fileName);
        customFile = YamlConfiguration.loadConfiguration(file);
        InputStream inputStream = this.plugin.getResource(fileName);//config.yml
        if (!file.exists()) {
            try {
                file.createNewFile();
                customFile.load(new InputStreamReader(Objects.requireNonNull(inputStream), StandardCharsets.UTF_8));
                customFile.save(file);
            }catch (IOException e) {
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED+"建立設定檔案失敗");
                Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + e.toString());
                Bukkit.getLogger().log(Level.SEVERE,"<<<<----建立設定檔案失敗---->>>>");
                Bukkit.getLogger().log(Level.SEVERE,e.toString(),StandardCharsets.UTF_8);
                Bukkit.getLogger().log(Level.SEVERE,"<<<<----建立設定檔案失敗---->>>>");
            }
        }
        save();
    }

    public static ConfigurationSection get(){
        return customFile;
    }

    public static void save(){
        try {
            customFile.save(file);
        }catch (IOException e){
            System.out.println(e.toString());
        }
    }

    public static void reload(){
        customFile = YamlConfiguration.loadConfiguration(file);
    }

    public void forceReload(){
        file = new File(this.plugin.getDataFolder(), fileName);
        customFile = YamlConfiguration.loadConfiguration(file);
        InputStream inputStream = this.plugin.getResource(fileName);
        try {
            file.createNewFile();
            customFile.load(new InputStreamReader(Objects.requireNonNull(inputStream),StandardCharsets.UTF_8));
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }

    }
}
