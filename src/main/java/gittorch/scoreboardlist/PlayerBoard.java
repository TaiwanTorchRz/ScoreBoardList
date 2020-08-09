package gittorch.scoreboardlist;



import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;


import java.util.*;
import java.util.stream.Collectors;

public class PlayerBoard implements Listener {
    private ScoreBoardList plugin;

    HashMap<String, Integer> level = new HashMap<>();
    HashMap<String, Integer> ARMOR_CLEANED = new HashMap<>();
    HashMap<String, Integer> deathCount = new HashMap<>();
    HashMap<String, Integer> food = new HashMap<>();
    HashMap<String, Integer> BOAT_ONE_CM = new HashMap<>();

    ScoreboardManager manager = Bukkit.getScoreboardManager();
    final Scoreboard board = manager.getNewScoreboard();
    final Objective objective = board.registerNewObjective("test", "dummy");
    int index = 0,enableIndex;

    public PlayerBoard(ScoreBoardList plugin) {
        this.plugin = plugin;
    }// 建構子

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                for (Player PLAYER : Bukkit.getOnlinePlayers()) {
                    if (ConfigManager.get().getBoolean("level")) level.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.BOAT_ONE_CM));enableIndex++;
                    if (ConfigManager.get().getBoolean("ARMOR_CLEANED")) ARMOR_CLEANED.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.ARMOR_CLEANED));enableIndex++;
                    if (ConfigManager.get().getBoolean("deathCount")) deathCount.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.DEATHS));enableIndex++;
                    if (ConfigManager.get().getBoolean("food")) food.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.FISH_CAUGHT));
                }

            }

                switch(index){
                    case 0: ScoreBoard(level, "level", e.getPlayer());
                            break;
                    case 1: ScoreBoard(ARMOR_CLEANED,"ARMOR_CLEANED",e.getPlayer());
                            break;
                    case 2: ScoreBoard(deathCount,"deathCount",e.getPlayer());
                            break;
                }
            index++;
            index=index%2;



        }, 1000, 10);
    }

    public void ScoreBoard(HashMap<String, Integer> map, String name, Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        assert manager != null;
        final Scoreboard board = manager.getNewScoreboard();
        final Objective objective = board.registerNewObjective("test", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.RED + name.toString());

        Map<Object, Object> sortedMap =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue())
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
        int i = 0;
        for (Object key : sortedMap.keySet()) {
            int value = (Integer) sortedMap.get((String) key);
//            Score score = objective.getScore(key.toString() +
//                    ChatColor.GRAY +" - " + ChatColor.GOLD + value);
            Score score = objective.getScore(key.toString());
//            score.setScore(i);
            score.setScore(value);
            i++;
        }

        Score score14 = objective.getScore("");
        score14.setScore(-1);

        Score scoreEnd = objective.getScore(ChatColor.RED + "GTIC");
        scoreEnd.setScore(-2);
        p.setScoreboard(board);
    }
}

