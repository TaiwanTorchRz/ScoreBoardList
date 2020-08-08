package gittorch.scoreboardlist;

import de.snx.statsapi.manager.StatsManager;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Statistic;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;


import java.util.*;

public class PlayerBoard implements Listener {
    private final ScoreBoardList plugin;
    public StatsManager statsManager;

    HashMap<String,Integer> BOAT_ONE_CM = new HashMap<>();

    ScoreboardManager manager = Bukkit.getScoreboardManager();
    final Scoreboard board = manager.getNewScoreboard();
    final Objective objective = board.registerNewObjective("test", "dummy");


    public PlayerBoard(ScoreBoardList plugin){
        this.plugin = plugin;
    }//建構子

    @EventHandler
    public void PlayerJoin(PlayerJoinEvent e) {
        Bukkit.getScheduler().runTaskTimer(plugin,() -> {
            for( Player player: Bukkit.getOnlinePlayers()) {
                ScoreboardManager manager = Bukkit.getScoreboardManager();
                assert manager != null;
                final Scoreboard board = manager.getNewScoreboard();
                final Objective objective = board.registerNewObjective("test", "dummy");
                objective.setDisplaySlot(DisplaySlot.SIDEBAR);
                for (Player PLAYER : Bukkit.getOnlinePlayers()){
                    BOAT_ONE_CM.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.BOAT_ONE_CM));}
                ScoreBoard(BOAT_ONE_CM,"BOAT_ONE_CM",player);
            }

        },0,20);
    }

    public void ScoreBoard(HashMap<String,Integer> map,String name,Player p){
        objective.setDisplayName(ChatColor.RED + name.toString());
        Set set = map.entrySet();
        Iterator i  = set.iterator();
        if (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            Score score = objective.getScore(me.getKey().toString());
            System.out.println(me.getKey().toString());
            score.setScore((Integer) me.getValue());
            System.out.println((Integer) me.getValue());
        }
        if (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            Score score2 = objective.getScore(me.getKey().toString());
            score2.setScore((Integer) me.getValue());
        }
        if (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            Score score3 = objective.getScore(me.getKey().toString());
            score3.setScore((Integer) me.getValue());
        }
        if (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            Score score4 = objective.getScore(me.getKey().toString());
            score4.setScore((Integer) me.getValue());
        }
        if (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            Score score5 = objective.getScore(me.getKey().toString());
            score5.setScore((Integer) me.getValue());
        }
        if (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            Score score6 = objective.getScore(me.getKey().toString());
            score6.setScore((Integer) me.getValue());
        }
        if (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            Score score7 = objective.getScore(me.getKey().toString());
            score7.setScore((Integer) me.getValue());
        }
        if (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            Score score8 = objective.getScore(me.getKey().toString());
            score8.setScore((Integer) me.getValue());
        }
        if (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            Score score9 = objective.getScore(me.getKey().toString());
            score9.setScore((Integer) me.getValue());
        }
        if (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            Score score10 = objective.getScore(me.getKey().toString());
            score10.setScore((Integer) me.getValue());
        }
        if (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            Score score11 = objective.getScore(me.getKey().toString());
            score11.setScore((Integer) me.getValue());
        }
        if (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            Score score12 = objective.getScore(me.getKey().toString());
            score12.setScore((Integer) me.getValue());
        }
        if (i.hasNext()){
            Map.Entry me = (Map.Entry)i.next();
            Score score13 = objective.getScore(me.getKey().toString());
            score13.setScore((Integer) me.getValue());
        }

        Score score14 = objective.getScore("");
        score14.setScore(-1);

        Score scoreEnd = objective.getScore(ChatColor.RED + "GTIC");
        scoreEnd.setScore(-2);
        System.out.println(p);
        p.setScoreboard(board);
    }

}

