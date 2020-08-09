package gittorch.scoreboardlist;



import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Statistic;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.scoreboard.*;

import java.util.*;
import java.util.stream.Collectors;

public class PlayerBoard implements Listener {
    private final ScoreBoardList plugin;

    HashMap<String, Integer> ANIMALS_BRED = new HashMap<>();
    HashMap<String, Integer> ARMOR_CLEANED = new HashMap<>();
    HashMap<String, Integer> AVIATE_ONE_CM = new HashMap<>();
    HashMap<String, Integer> BANNER_CLEANED = new HashMap<>();
    HashMap<String, Integer> BEACON_INTERACTION = new HashMap<>();
    HashMap<String, Integer> BELL_RING = new HashMap<>();
    HashMap<String, Integer> BOAT_ONE_CM = new HashMap<>();
    HashMap<String, Integer> BREAK_ITEM = new HashMap<>();
    HashMap<String, Integer> BREWINGSTAND_INTERACTION = new HashMap<>();
    HashMap<String, Integer> CAKE_SLICES_EATEN = new HashMap<>();
    HashMap<String, Integer> CAULDRON_FILLED = new HashMap<>();
    HashMap<String, Integer> CAULDRON_USED = new HashMap<>();
    HashMap<String, Integer> CHEST_OPENED = new HashMap<>();
    HashMap<String, Integer> CLEAN_SHULKER_BOX = new HashMap<>();
    HashMap<String, Integer> CLIMB_ONE_CM = new HashMap<>();
    HashMap<String, Integer> CRAFT_ITEM = new HashMap<>();
    HashMap<String, Integer> CRAFTING_TABLE_INTERACTION = new HashMap<>();
    HashMap<String, Integer> CROUCH_ONE_CM = new HashMap<>();
    HashMap<String, Integer> DAMAGE_ABSORBED = new HashMap<>();
    HashMap<String, Integer> DAMAGE_BLOCKED_BY_SHIELD = new HashMap<>();
    HashMap<String, Integer> DAMAGE_DEALT = new HashMap<>();
    HashMap<String, Integer> DAMAGE_DEALT_ABSORBED = new HashMap<>();
    HashMap<String, Integer> DAMAGE_DEALT_RESISTED = new HashMap<>();
    HashMap<String, Integer> DAMAGE_RESISTED = new HashMap<>();
    HashMap<String, Integer> DAMAGE_TAKEN = new HashMap<>();
    HashMap<String, Integer> DEATHS = new HashMap<>();
    HashMap<String, Integer> DISPENSER_INSPECTED = new HashMap<>();
    HashMap<String, Integer> DROP = new HashMap<>();
    HashMap<String, Integer> DROP_COUNT = new HashMap<>();
    HashMap<String, Integer> DROPPER_INSPECTED = new HashMap<>();
    HashMap<String, Integer> ENDERCHEST_OPENED = new HashMap<>();
    HashMap<String, Integer> ENTITY_KILLED_BY = new HashMap<>();
    HashMap<String, Integer> FALL_ONE_CM = new HashMap<>();
    HashMap<String, Integer> FISH_CAUGHT = new HashMap<>();
    HashMap<String, Integer> FLOWER_POTTED = new HashMap<>();
    HashMap<String, Integer> FLY_ONE_CM = new HashMap<>();
    HashMap<String, Integer> FURNACE_INTERACTION = new HashMap<>();
    HashMap<String, Integer> HOPPER_INSPECTED = new HashMap<>();
    HashMap<String, Integer> HORSE_ONE_CM = new HashMap<>();
    HashMap<String, Integer> INTERACT_WITH_ANVIL = new HashMap<>();
    HashMap<String, Integer> INTERACT_WITH_BLAST_FURNACE = new HashMap<>();
    HashMap<String, Integer> INTERACT_WITH_CAMPFIRE = new HashMap<>();
    HashMap<String, Integer> INTERACT_WITH_CARTOGRAPHY_TABLE = new HashMap<>();
    HashMap<String, Integer> INTERACT_WITH_GRINDSTONE = new HashMap<>();
    HashMap<String, Integer> INTERACT_WITH_LECTERN = new HashMap<>();
    HashMap<String, Integer> INTERACT_WITH_LOOM = new HashMap<>();
    HashMap<String, Integer> INTERACT_WITH_SMITHING_TABLE = new HashMap<>();
    HashMap<String, Integer> INTERACT_WITH_SMOKER = new HashMap<>();
    HashMap<String, Integer> INTERACT_WITH_STONECUTTER = new HashMap<>();
    HashMap<String, Integer> ITEM_ENCHANTED = new HashMap<>();
    HashMap<String, Integer> JUMP = new HashMap<>();
    HashMap<String, Integer> KILL_ENTITY = new HashMap<>();
    HashMap<String, Integer> LEAVE_GAME = new HashMap<>();
    HashMap<String, Integer> MINE_BLOCK = new HashMap<>();
    HashMap<String, Integer> MINECART_ONE_CM = new HashMap<>();
    HashMap<String, Integer> MOB_KILLS = new HashMap<>();
    HashMap<String, Integer> NOTEBLOCK_PLAYED = new HashMap<>();
    HashMap<String, Integer> NOTEBLOCK_TUNED = new HashMap<>();
    HashMap<String, Integer> OPEN_BARREL = new HashMap<>();
    HashMap<String, Integer> PICKUP = new HashMap<>();
    HashMap<String, Integer> PIG_ONE_CM = new HashMap<>();
    HashMap<String, Integer> PLAY_ONE_MINUTE = new HashMap<>();
    HashMap<String, Integer> PLAYER_KILLS = new HashMap<>();
    HashMap<String, Integer> RAID_TRIGGER = new HashMap<>();
    HashMap<String, Integer> RAID_WIN = new HashMap<>();
    HashMap<String, Integer> RECORD_PLAYED = new HashMap<>();
    HashMap<String, Integer> SHULKER_BOX_OPENED = new HashMap<>();
    HashMap<String, Integer> SLEEP_IN_BED = new HashMap<>();
    HashMap<String, Integer> SNEAK_TIME = new HashMap<>();
    HashMap<String, Integer> SPRINT_ONE_CM = new HashMap<>();
    HashMap<String, Integer> STRIDER_ONE_CM = new HashMap<>();
    HashMap<String, Integer> SWIM_ONE_CM = new HashMap<>();
    HashMap<String, Integer> TALKED_TO_VILLAGER = new HashMap<>();
    HashMap<String, Integer> TARGET_HIT = new HashMap<>();
    HashMap<String, Integer> TIME_SINCE_DEATH = new HashMap<>();
    HashMap<String, Integer> TIME_SINCE_REST = new HashMap<>();
    HashMap<String, Integer> TRADED_WITH_VILLAGER = new HashMap<>();
    HashMap<String, Integer> TRAPPED_CHEST_TRIGGERED = new HashMap<>();
    HashMap<String, Integer> USE_ITEM = new HashMap<>();
    HashMap<String, Integer> WALK_ON_WATER_ONE_CM = new HashMap<>();
    HashMap<String, Integer> WALK_ONE_CM = new HashMap<>();
    HashMap<String, Integer> WALK_UNDER_WATER_ONE_CM = new HashMap<>();



    public PlayerBoard(ScoreBoardList plugin) {
        this.plugin = plugin;
    }// 建構子

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent e) {
        for (Player PLAYER : Bukkit.getOnlinePlayers()) {
            if (ConfigManager.get().getBoolean("DEATHS")) DEATHS.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.DEATHS));
        }
        ScoreBoard(DEATHS,"DEATHS",e.getPlayer());
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
                for (Player PLAYER : Bukkit.getOnlinePlayers()) {
                    if (ConfigManager.get().getBoolean("ANIMALS_BRED")) ANIMALS_BRED.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.ANIMALS_BRED));
                    if (ConfigManager.get().getBoolean("ARMOR_CLEANED")) ARMOR_CLEANED.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.ARMOR_CLEANED));
                    if (ConfigManager.get().getBoolean("AVIATE_ONE_CM")) AVIATE_ONE_CM.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.AVIATE_ONE_CM));
                    if (ConfigManager.get().getBoolean("BANNER_CLEANED")) BANNER_CLEANED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.BANNER_CLEANED));
                    if (ConfigManager.get().getBoolean("BEACON_INTERACTION")) BEACON_INTERACTION.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.BEACON_INTERACTION));
                    if (ConfigManager.get().getBoolean("BELL_RING")) BELL_RING.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.BELL_RING));
                    if (ConfigManager.get().getBoolean("BOAT_ONE_CM")) BOAT_ONE_CM.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.BOAT_ONE_CM));
//                    if (ConfigManager.get().getBoolean("BREAK_ITEM")) BREAK_ITEM.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.BREAK_ITEM));
                    if (ConfigManager.get().getBoolean("BREWINGSTAND_INTERACTION")) BREWINGSTAND_INTERACTION.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.BREWINGSTAND_INTERACTION));
                    if (ConfigManager.get().getBoolean("CAKE_SLICES_EATEN")) CAKE_SLICES_EATEN.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.CAKE_SLICES_EATEN));

                    if (ConfigManager.get().getBoolean("CAULDRON_FILLED")) CAULDRON_FILLED.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.CAULDRON_FILLED));
                    if (ConfigManager.get().getBoolean("CAULDRON_USED")) CAULDRON_USED.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.CAULDRON_USED));
                    if (ConfigManager.get().getBoolean("CHEST_OPENED")) CHEST_OPENED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.CHEST_OPENED));
                    if (ConfigManager.get().getBoolean("CLEAN_SHULKER_BOX")) CLEAN_SHULKER_BOX.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.CLEAN_SHULKER_BOX));
                    if (ConfigManager.get().getBoolean("CLIMB_ONE_CM")) CLIMB_ONE_CM.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.CLIMB_ONE_CM));
//                    if (ConfigManager.get().getBoolean("CRAFT_ITEM")) CRAFT_ITEM.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.CRAFT_ITEM));
                    if (ConfigManager.get().getBoolean("CRAFTING_TABLE_INTERACTION")) CRAFTING_TABLE_INTERACTION.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.CRAFTING_TABLE_INTERACTION));
                    if (ConfigManager.get().getBoolean("CROUCH_ONE_CM")) CROUCH_ONE_CM.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.CROUCH_ONE_CM));
                    if (ConfigManager.get().getBoolean("DAMAGE_ABSORBED")) DAMAGE_ABSORBED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.DAMAGE_ABSORBED));
                    if (ConfigManager.get().getBoolean("DAMAGE_BLOCKED_BY_SHIELD")) DAMAGE_BLOCKED_BY_SHIELD.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.DAMAGE_BLOCKED_BY_SHIELD));

                    if (ConfigManager.get().getBoolean("DAMAGE_DEALT")) DAMAGE_DEALT.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.DAMAGE_DEALT));
                    if (ConfigManager.get().getBoolean("DAMAGE_DEALT_ABSORBED")) DAMAGE_DEALT_ABSORBED.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.DAMAGE_DEALT_ABSORBED));
                    if (ConfigManager.get().getBoolean("DAMAGE_DEALT_RESISTED")) DAMAGE_DEALT_RESISTED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.DAMAGE_DEALT_RESISTED));
                    if (ConfigManager.get().getBoolean("DAMAGE_RESISTED")) DAMAGE_RESISTED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.DAMAGE_RESISTED));
                    if (ConfigManager.get().getBoolean("DAMAGE_TAKEN")) DAMAGE_TAKEN.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.DAMAGE_TAKEN));
                    if (ConfigManager.get().getBoolean("DEATHS")) DEATHS.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.DEATHS));
                    if (ConfigManager.get().getBoolean("DISPENSER_INSPECTED")) DISPENSER_INSPECTED.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.DISPENSER_INSPECTED));
//                    if (ConfigManager.get().getBoolean("DROP")) DROP.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.DROP));
                    if (ConfigManager.get().getBoolean("DROP_COUNT")) DROP_COUNT.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.DROP_COUNT));
                    if (ConfigManager.get().getBoolean("DROPPER_INSPECTED")) DROPPER_INSPECTED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.DROPPER_INSPECTED));

                    if (ConfigManager.get().getBoolean("ENDERCHEST_OPENED")) ENDERCHEST_OPENED.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.ENDERCHEST_OPENED));
//                    if (ConfigManager.get().getBoolean("ENTITY_KILLED_BY")) ENTITY_KILLED_BY.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.ENTITY_KILLED_BY));
                    if (ConfigManager.get().getBoolean("FALL_ONE_CM")) FALL_ONE_CM.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.FALL_ONE_CM));
                    if (ConfigManager.get().getBoolean("FISH_CAUGHT")) FISH_CAUGHT.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.FISH_CAUGHT));
                    if (ConfigManager.get().getBoolean("FLOWER_POTTED")) FLOWER_POTTED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.FLOWER_POTTED));
                    if (ConfigManager.get().getBoolean("FLY_ONE_CM")) FLY_ONE_CM.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.FLY_ONE_CM));
                    if (ConfigManager.get().getBoolean("FURNACE_INTERACTION")) FURNACE_INTERACTION.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.FURNACE_INTERACTION));
                    if (ConfigManager.get().getBoolean("HOPPER_INSPECTED")) HOPPER_INSPECTED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.HOPPER_INSPECTED));
                    if (ConfigManager.get().getBoolean("HORSE_ONE_CM")) HORSE_ONE_CM.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.HORSE_ONE_CM));
                    if (ConfigManager.get().getBoolean("INTERACT_WITH_ANVIL")) INTERACT_WITH_ANVIL.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.INTERACT_WITH_ANVIL));

                    if (ConfigManager.get().getBoolean("INTERACT_WITH_BLAST_FURNACE")) INTERACT_WITH_BLAST_FURNACE.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.INTERACT_WITH_BLAST_FURNACE));
                    if (ConfigManager.get().getBoolean("INTERACT_WITH_CAMPFIRE")) INTERACT_WITH_CAMPFIRE.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.INTERACT_WITH_CAMPFIRE));
                    if (ConfigManager.get().getBoolean("INTERACT_WITH_CARTOGRAPHY_TABLE")) INTERACT_WITH_CARTOGRAPHY_TABLE.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.INTERACT_WITH_CARTOGRAPHY_TABLE));
                    if (ConfigManager.get().getBoolean("INTERACT_WITH_GRINDSTONE")) INTERACT_WITH_GRINDSTONE.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.INTERACT_WITH_GRINDSTONE));
                    if (ConfigManager.get().getBoolean("INTERACT_WITH_LECTERN")) INTERACT_WITH_LECTERN.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.INTERACT_WITH_LECTERN));
                    if (ConfigManager.get().getBoolean("INTERACT_WITH_LOOM")) INTERACT_WITH_LOOM.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.INTERACT_WITH_LOOM));
                    if (ConfigManager.get().getBoolean("INTERACT_WITH_SMITHING_TABLE")) INTERACT_WITH_SMITHING_TABLE.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.INTERACT_WITH_SMITHING_TABLE));
                    if (ConfigManager.get().getBoolean("INTERACT_WITH_SMOKER")) INTERACT_WITH_SMOKER.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.INTERACT_WITH_SMOKER));
                    if (ConfigManager.get().getBoolean("INTERACT_WITH_STONECUTTER")) INTERACT_WITH_STONECUTTER.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.INTERACT_WITH_STONECUTTER));
                    if (ConfigManager.get().getBoolean("ITEM_ENCHANTED")) ITEM_ENCHANTED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.ITEM_ENCHANTED));

                    if (ConfigManager.get().getBoolean("JUMP")) JUMP.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.JUMP));
//                    if (ConfigManager.get().getBoolean("KILL_ENTITY")) KILL_ENTITY.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.KILL_ENTITY));
                    if (ConfigManager.get().getBoolean("LEAVE_GAME")) LEAVE_GAME.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.LEAVE_GAME));
//                    if (ConfigManager.get().getBoolean("MINE_BLOCK")) MINE_BLOCK.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.MINE_BLOCK));
                    if (ConfigManager.get().getBoolean("MINECART_ONE_CM")) MINECART_ONE_CM.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.MINECART_ONE_CM));
                    if (ConfigManager.get().getBoolean("MOB_KILLS")) MOB_KILLS.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.MOB_KILLS));
                    if (ConfigManager.get().getBoolean("NOTEBLOCK_PLAYED")) NOTEBLOCK_PLAYED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.NOTEBLOCK_PLAYED));
                    if (ConfigManager.get().getBoolean("NOTEBLOCK_TUNED")) NOTEBLOCK_TUNED.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.NOTEBLOCK_TUNED));
                    if (ConfigManager.get().getBoolean("OPEN_BARREL")) OPEN_BARREL.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.OPEN_BARREL));
//                    if (ConfigManager.get().getBoolean("PICKUP")) PICKUP.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.PICKUP));

                    if (ConfigManager.get().getBoolean("PIG_ONE_CM")) PIG_ONE_CM.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.PIG_ONE_CM));
                    if (ConfigManager.get().getBoolean("PLAY_ONE_MINUTE")) PLAY_ONE_MINUTE.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.PLAY_ONE_MINUTE));
                    if (ConfigManager.get().getBoolean("PLAYER_KILLS")) PLAYER_KILLS.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.PLAYER_KILLS));
                    if (ConfigManager.get().getBoolean("RAID_TRIGGER")) RAID_TRIGGER.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.RAID_TRIGGER));
                    if (ConfigManager.get().getBoolean("RAID_WIN")) RAID_WIN.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.RAID_WIN));
                    if (ConfigManager.get().getBoolean("RECORD_PLAYED")) RECORD_PLAYED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.RECORD_PLAYED));
                    if (ConfigManager.get().getBoolean("SHULKER_BOX_OPENED")) SHULKER_BOX_OPENED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.SHULKER_BOX_OPENED));
                    if (ConfigManager.get().getBoolean("SLEEP_IN_BED")) SLEEP_IN_BED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.SLEEP_IN_BED));
                    if (ConfigManager.get().getBoolean("SNEAK_TIME")) SNEAK_TIME.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.SNEAK_TIME));
                    if (ConfigManager.get().getBoolean("SPRINT_ONE_CM")) SPRINT_ONE_CM.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.SPRINT_ONE_CM));
                    if (ConfigManager.get().getBoolean("STRIDER_ONE_CM")) STRIDER_ONE_CM.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.STRIDER_ONE_CM));
                    if (ConfigManager.get().getBoolean("SWIM_ONE_CM")) SWIM_ONE_CM.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.SWIM_ONE_CM));

                    if (ConfigManager.get().getBoolean("TALKED_TO_VILLAGER")) TALKED_TO_VILLAGER.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.TALKED_TO_VILLAGER));
                    if (ConfigManager.get().getBoolean("TARGET_HIT")) TARGET_HIT.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.TARGET_HIT));
                    if (ConfigManager.get().getBoolean("TIME_SINCE_DEATH")) TIME_SINCE_DEATH.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.TIME_SINCE_DEATH));
                    if (ConfigManager.get().getBoolean("TIME_SINCE_REST")) TIME_SINCE_REST.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.TIME_SINCE_REST));
                    if (ConfigManager.get().getBoolean("TRADED_WITH_VILLAGER")) TRADED_WITH_VILLAGER.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.TRADED_WITH_VILLAGER));
                    if (ConfigManager.get().getBoolean("TRAPPED_CHEST_TRIGGERED")) TRAPPED_CHEST_TRIGGERED.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.TRAPPED_CHEST_TRIGGERED));
//                    if (ConfigManager.get().getBoolean("USE_ITEM")) USE_ITEM.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.USE_ITEM));
                    if (ConfigManager.get().getBoolean("FLY_ONE_CM")) WALK_ON_WATER_ONE_CM.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.WALK_ON_WATER_ONE_CM));
                    if (ConfigManager.get().getBoolean("WALK_ONE_CM")) WALK_ONE_CM.put(PLAYER.getDisplayName(), PLAYER.getStatistic(Statistic.WALK_ONE_CM));
                    if (ConfigManager.get().getBoolean("WALK_UNDER_WATER_ONE_CM")) WALK_UNDER_WATER_ONE_CM.put(PLAYER.getDisplayName(),PLAYER.getStatistic(Statistic.WALK_UNDER_WATER_ONE_CM));

                }
                int index = (int) (Math.random() * 81)+1;
                switch(index){
                    case 1: if (ConfigManager.get().getBoolean("ANIMALS_BRED")){
                                ScoreBoard(ANIMALS_BRED,"ANIMALS_BRED",e.getPlayer());
                                break;
                            }
                    case 2: if (ConfigManager.get().getBoolean("ARMOR_CLEANED")){
                        ScoreBoard(ARMOR_CLEANED,"ARMOR_CLEANED",e.getPlayer());
                        break;
                    }
                    case 3: if (ConfigManager.get().getBoolean("AVIATE_ONE_CM")){
                        ScoreBoard(AVIATE_ONE_CM,"AVIATE_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 4: if (ConfigManager.get().getBoolean("BANNER_CLEANED")){
                        ScoreBoard(BANNER_CLEANED,"BANNER_CLEANED",e.getPlayer());
                        break;
                    }
                    case 5: if (ConfigManager.get().getBoolean("BEACON_INTERACTION")){
                        ScoreBoard(BEACON_INTERACTION,"BEACON_INTERACTION",e.getPlayer());
                        break;
                    }
                    case 6: if (ConfigManager.get().getBoolean("BELL_RING")){
                        ScoreBoard(BELL_RING,"BELL_RING",e.getPlayer());
                        break;
                    }
                    case 7: if (ConfigManager.get().getBoolean("BOAT_ONE_CM")){
                        ScoreBoard(BOAT_ONE_CM,"BOAT_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 8: if (ConfigManager.get().getBoolean("BREAK_ITEM")){
                        ScoreBoard(BREAK_ITEM,"BREAK_ITEM",e.getPlayer());
                        break;
                    }
                    case 9: if (ConfigManager.get().getBoolean("BREWINGSTAND_INTERACTION")){
                        ScoreBoard(BREWINGSTAND_INTERACTION,"BREWINGSTAND_INTERACTION",e.getPlayer());
                        break;
                    }
                    case 10: if (ConfigManager.get().getBoolean("CAKE_SLICES_EATEN")){
                        ScoreBoard(CAKE_SLICES_EATEN,"CAKE_SLICES_EATEN",e.getPlayer());
                        break;
                    }
                    case 11: if (ConfigManager.get().getBoolean("CAULDRON_FILLED")){
                        ScoreBoard(CAULDRON_FILLED,"CAULDRON_FILLED",e.getPlayer());
                        break;
                    }
                    case 12: if (ConfigManager.get().getBoolean("CAULDRON_USED")){
                        ScoreBoard(CAULDRON_USED,"CAULDRON_USED",e.getPlayer());
                        break;
                    }
                    case 13: if (ConfigManager.get().getBoolean("CHEST_OPENED")){
                        ScoreBoard(CHEST_OPENED,"CHEST_OPENED",e.getPlayer());
                        break;
                    }
                    case 14: if (ConfigManager.get().getBoolean("CLEAN_SHULKER_BOX")){
                        ScoreBoard(CLEAN_SHULKER_BOX,"CLEAN_SHULKER_BOX",e.getPlayer());
                        break;
                    }
                    case 15: if (ConfigManager.get().getBoolean("CLIMB_ONE_CM")){
                        ScoreBoard(CLIMB_ONE_CM,"CLIMB_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 16: if (ConfigManager.get().getBoolean("CRAFT_ITEM")){
                        ScoreBoard(CRAFT_ITEM,"CRAFT_ITEM",e.getPlayer());
                        break;
                    }
                    case 17: if (ConfigManager.get().getBoolean("CRAFTING_TABLE_INTERACTION")){
                        ScoreBoard(CRAFTING_TABLE_INTERACTION,"CRAFTING_TABLE_INTERACTION",e.getPlayer());
                        break;
                    }
                    case 18: if (ConfigManager.get().getBoolean("CROUCH_ONE_CM")){
                        ScoreBoard(CROUCH_ONE_CM,"CROUCH_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 19: if (ConfigManager.get().getBoolean("DAMAGE_ABSORBED")){
                        ScoreBoard(DAMAGE_ABSORBED,"DAMAGE_ABSORBED",e.getPlayer());
                        break;
                    }
                    case 20: if (ConfigManager.get().getBoolean("DAMAGE_BLOCKED_BY_SHIELD")){
                        ScoreBoard(DAMAGE_BLOCKED_BY_SHIELD,"DAMAGE_BLOCKED_BY_SHIELD",e.getPlayer());
                        break;
                    }
                    case 21: if (ConfigManager.get().getBoolean("DAMAGE_DEALT")){
                        ScoreBoard(DAMAGE_DEALT,"DAMAGE_DEALT",e.getPlayer());
                        break;
                    }
                    case 22: if (ConfigManager.get().getBoolean("DAMAGE_DEALT_ABSORBED")){
                        ScoreBoard(DAMAGE_DEALT_ABSORBED,"DAMAGE_DEALT_ABSORBED",e.getPlayer());
                        break;
                    }
                    case 23: if (ConfigManager.get().getBoolean("DAMAGE_DEALT_RESISTED")){
                        ScoreBoard(DAMAGE_DEALT_RESISTED,"DAMAGE_DEALT_RESISTED",e.getPlayer());
                        break;
                    }
                    case 24: if (ConfigManager.get().getBoolean("DAMAGE_RESISTED")){
                        ScoreBoard(DAMAGE_RESISTED,"DAMAGE_RESISTED",e.getPlayer());
                        break;
                    }
                    case 25: if (ConfigManager.get().getBoolean("DAMAGE_TAKEN")){
                        ScoreBoard(DAMAGE_TAKEN,"DAMAGE_TAKEN",e.getPlayer());
                        break;
                    }
                    case 26: if (ConfigManager.get().getBoolean("DEATHS")){
                        ScoreBoard(DEATHS,"DEATHS",e.getPlayer());
                        break;
                    }
                    case 27: if (ConfigManager.get().getBoolean("DISPENSER_INSPECTED")){
                        ScoreBoard(DISPENSER_INSPECTED,"DISPENSER_INSPECTED",e.getPlayer());
                        break;
                    }
                    case 28: if (ConfigManager.get().getBoolean("DROP")){
                        ScoreBoard(DROP,"DROP",e.getPlayer());
                        break;
                    }
                    case 29: if (ConfigManager.get().getBoolean("DROP_COUNT")){
                        ScoreBoard(DROP_COUNT,"DROP_COUNT",e.getPlayer());
                        break;
                    }
                    case 30: if (ConfigManager.get().getBoolean("DROPPER_INSPECTED")){
                        ScoreBoard(DROPPER_INSPECTED,"DROPPER_INSPECTED",e.getPlayer());
                        break;
                    }
                    case 31: if (ConfigManager.get().getBoolean("ENDERCHEST_OPENED")){
                        ScoreBoard(ENDERCHEST_OPENED,"ENDERCHEST_OPENED",e.getPlayer());
                        break;
                    }
                    case 32: if (ConfigManager.get().getBoolean("ENTITY_KILLED_BY")){
                        ScoreBoard(ENTITY_KILLED_BY,"ENTITY_KILLED_BY",e.getPlayer());
                        break;
                    }
                    case 33: if (ConfigManager.get().getBoolean("FALL_ONE_CM")){
                        ScoreBoard(FALL_ONE_CM,"FALL_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 34: if (ConfigManager.get().getBoolean("FISH_CAUGHT")){
                        ScoreBoard(FISH_CAUGHT,"FISH_CAUGHT",e.getPlayer());
                        break;
                    }
                    case 35: if (ConfigManager.get().getBoolean("FLOWER_POTTED")){
                        ScoreBoard(FLOWER_POTTED,"FLOWER_POTTED",e.getPlayer());
                        break;
                    }
                    case 36: if (ConfigManager.get().getBoolean("FLY_ONE_CM")){
                        ScoreBoard(FLY_ONE_CM,"FLY_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 37: if (ConfigManager.get().getBoolean("FURNACE_INTERACTION")){
                        ScoreBoard(FURNACE_INTERACTION,"FURNACE_INTERACTION",e.getPlayer());
                        break;
                    }
                    case 38: if (ConfigManager.get().getBoolean("HOPPER_INSPECTED")){
                        ScoreBoard(HOPPER_INSPECTED,"HOPPER_INSPECTED",e.getPlayer());
                        break;
                    }
                    case 39: if (ConfigManager.get().getBoolean("HORSE_ONE_CM")){
                        ScoreBoard(HORSE_ONE_CM,"HORSE_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 40: if (ConfigManager.get().getBoolean("INTERACT_WITH_ANVIL")){
                        ScoreBoard(INTERACT_WITH_ANVIL,"INTERACT_WITH_ANVIL",e.getPlayer());
                        break;
                    }
                    case 41: if (ConfigManager.get().getBoolean("INTERACT_WITH_BLAST_FURNACE")){
                        ScoreBoard(INTERACT_WITH_BLAST_FURNACE,"INTERACT_WITH_BLAST_FURNACE",e.getPlayer());
                        break;
                    }
                    case 42: if (ConfigManager.get().getBoolean("INTERACT_WITH_CAMPFIRE")){
                        ScoreBoard(INTERACT_WITH_CAMPFIRE,"INTERACT_WITH_CAMPFIRE",e.getPlayer());
                        break;
                    }
                    case 43: if (ConfigManager.get().getBoolean("INTERACT_WITH_CARTOGRAPHY_TABLE")){
                        ScoreBoard(INTERACT_WITH_CARTOGRAPHY_TABLE,"INTERACT_WITH_CARTOGRAPHY_TABLE",e.getPlayer());
                        break;
                    }
                    case 44: if (ConfigManager.get().getBoolean("INTERACT_WITH_GRINDSTONE")){
                        ScoreBoard(INTERACT_WITH_GRINDSTONE,"INTERACT_WITH_GRINDSTONE",e.getPlayer());
                        break;
                    }
                    case 45: if (ConfigManager.get().getBoolean("INTERACT_WITH_LECTERN")){
                        ScoreBoard(INTERACT_WITH_LECTERN,"INTERACT_WITH_LECTERN",e.getPlayer());
                        break;
                    }
                    case 46: if (ConfigManager.get().getBoolean("INTERACT_WITH_LOOM")){
                        ScoreBoard(INTERACT_WITH_LOOM,"INTERACT_WITH_LOOM",e.getPlayer());
                        break;
                    }
                    case 47: if (ConfigManager.get().getBoolean("INTERACT_WITH_SMITHING_TABLE")){
                        ScoreBoard(INTERACT_WITH_SMITHING_TABLE,"INTERACT_WITH_SMITHING_TABLE",e.getPlayer());
                        break;
                    }
                    case 48: if (ConfigManager.get().getBoolean("INTERACT_WITH_SMOKER")){
                        ScoreBoard(INTERACT_WITH_SMOKER,"INTERACT_WITH_SMOKER",e.getPlayer());
                        break;
                    }
                    case 49: if (ConfigManager.get().getBoolean("INTERACT_WITH_STONECUTTER")){
                        ScoreBoard(INTERACT_WITH_STONECUTTER,"INTERACT_WITH_STONECUTTER",e.getPlayer());
                        break;
                    }
                    case 50: if (ConfigManager.get().getBoolean("ITEM_ENCHANTED")){
                        ScoreBoard(ITEM_ENCHANTED,"ITEM_ENCHANTED",e.getPlayer());
                        break;
                    }
                    case 51: if (ConfigManager.get().getBoolean("JUMP")){
                        ScoreBoard(JUMP,"JUMP",e.getPlayer());
                        break;
                    }
                    case 52: if (ConfigManager.get().getBoolean("KILL_ENTITY")){
                        ScoreBoard(KILL_ENTITY,"KILL_ENTITY",e.getPlayer());
                        break;
                    }
                    case 53: if (ConfigManager.get().getBoolean("LEAVE_GAME")){
                        ScoreBoard(LEAVE_GAME,"LEAVE_GAME",e.getPlayer());
                        break;
                    }
                    case 54: if (ConfigManager.get().getBoolean("MINE_BLOCK")){
                        ScoreBoard(MINE_BLOCK,"MINE_BLOCK",e.getPlayer());
                        break;
                    }
                    case 55: if (ConfigManager.get().getBoolean("MINECART_ONE_CM")){
                        ScoreBoard(MINECART_ONE_CM,"MINECART_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 56: if (ConfigManager.get().getBoolean("MOB_KILLS")){
                        ScoreBoard(MOB_KILLS,"MOB_KILLS",e.getPlayer());
                        break;
                    }
                    case 57: if (ConfigManager.get().getBoolean("NOTEBLOCK_PLAYED")){
                        ScoreBoard(NOTEBLOCK_PLAYED,"NOTEBLOCK_PLAYED",e.getPlayer());
                        break;
                    }
                    case 58: if (ConfigManager.get().getBoolean("NOTEBLOCK_TUNED")){
                        ScoreBoard(NOTEBLOCK_TUNED,"NOTEBLOCK_TUNED",e.getPlayer());
                        break;
                    }
                    case 59: if (ConfigManager.get().getBoolean("OPEN_BARREL")){
                        ScoreBoard(OPEN_BARREL,"OPEN_BARREL",e.getPlayer());
                        break;
                    }
                    case 60: if (ConfigManager.get().getBoolean("PICKUP")){
                        ScoreBoard(PICKUP,"PICKUP",e.getPlayer());
                        break;
                    }
                    case 61: if (ConfigManager.get().getBoolean("PIG_ONE_CM")){
                        ScoreBoard(PIG_ONE_CM,"PIG_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 62: if (ConfigManager.get().getBoolean("PLAY_ONE_MINUTE")){
                        ScoreBoard(PLAY_ONE_MINUTE,"PLAY_ONE_MINUTE",e.getPlayer());
                        break;
                    }
                    case 63: if (ConfigManager.get().getBoolean("PLAYER_KILLS")){
                        ScoreBoard(PLAYER_KILLS,"PLAYER_KILLS",e.getPlayer());
                        break;
                    }
                    case 64: if (ConfigManager.get().getBoolean("RAID_TRIGGER")){
                        ScoreBoard(RAID_TRIGGER,"RAID_TRIGGER",e.getPlayer());
                        break;
                    }
                    case 65: if (ConfigManager.get().getBoolean("RAID_WIN")){
                        ScoreBoard(RAID_WIN,"RAID_WIN",e.getPlayer());
                        break;
                    }
                    case 66: if (ConfigManager.get().getBoolean("RECORD_PLAYED")){
                        ScoreBoard(RECORD_PLAYED,"RECORD_PLAYED",e.getPlayer());
                        break;
                    }
                    case 67: if (ConfigManager.get().getBoolean("SHULKER_BOX_OPENED")){
                        ScoreBoard(SHULKER_BOX_OPENED,"SHULKER_BOX_OPENED",e.getPlayer());
                        break;
                    }
                    case 68: if (ConfigManager.get().getBoolean("SLEEP_IN_BED")){
                        ScoreBoard(SLEEP_IN_BED,"SLEEP_IN_BED",e.getPlayer());
                        break;
                    }
                    case 69: if (ConfigManager.get().getBoolean("SNEAK_TIME")){
                        ScoreBoard(SNEAK_TIME,"SNEAK_TIME",e.getPlayer());
                        break;
                    }
                    case 70: if (ConfigManager.get().getBoolean("SPRINT_ONE_CM")){
                        ScoreBoard(SPRINT_ONE_CM,"SPRINT_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 71: if (ConfigManager.get().getBoolean("STRIDER_ONE_CM")){
                        ScoreBoard(STRIDER_ONE_CM,"STRIDER_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 72: if (ConfigManager.get().getBoolean("SWIM_ONE_CM")){
                        ScoreBoard(SWIM_ONE_CM,"SWIM_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 73: if (ConfigManager.get().getBoolean("TALKED_TO_VILLAGER")){
                        ScoreBoard(TALKED_TO_VILLAGER,"TALKED_TO_VILLAGER",e.getPlayer());
                        break;
                    }
                    case 74: if (ConfigManager.get().getBoolean("TARGET_HIT")){
                        ScoreBoard(TARGET_HIT,"TARGET_HIT",e.getPlayer());
                        break;
                    }
                    case 75: if (ConfigManager.get().getBoolean("TIME_SINCE_DEATH")){
                        ScoreBoard(TIME_SINCE_DEATH,"TIME_SINCE_DEATH",e.getPlayer());
                        break;
                    }
                    case 76: if (ConfigManager.get().getBoolean("TIME_SINCE_REST")){
                        ScoreBoard(TIME_SINCE_REST,"TIME_SINCE_REST",e.getPlayer());
                        break;
                    }
                    case 77: if (ConfigManager.get().getBoolean("TRADED_WITH_VILLAGER")){
                        ScoreBoard(TRADED_WITH_VILLAGER,"TRADED_WITH_VILLAGER",e.getPlayer());
                        break;
                    }
                    case 78: if (ConfigManager.get().getBoolean("TRAPPED_CHEST_TRIGGERED")){
                        ScoreBoard(TRAPPED_CHEST_TRIGGERED,"TRAPPED_CHEST_TRIGGERED",e.getPlayer());
                        break;
                    }
                    case 79: if (ConfigManager.get().getBoolean("USE_ITEM")){
                        ScoreBoard(USE_ITEM,"USE_ITEM",e.getPlayer());
                        break;
                    }
                    case 80: if (ConfigManager.get().getBoolean("WALK_ON_WATER_ONE_CM")){
                        ScoreBoard(WALK_ON_WATER_ONE_CM,"WALK_ON_WATER_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 81: if (ConfigManager.get().getBoolean("WALK_ONE_CM")){
                        ScoreBoard(WALK_ONE_CM,"WALK_ONE_CM",e.getPlayer());
                        break;
                    }
                    case 82: if (ConfigManager.get().getBoolean("WALK_UNDER_WATER_ONE_CM")){
                        ScoreBoard(WALK_UNDER_WATER_ONE_CM,"WALK_UNDER_WATER_ONE_CM",e.getPlayer());
                        break;
                    }
                    default:
                        throw new IllegalStateException("Unexpected value: " + index);
                }

        }, 0, ConfigManager.get().getInt("timer"));

    }

    public void ScoreBoard(HashMap<String, Integer> map, String name, Player p) {
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        assert manager != null;
        final Scoreboard board = manager.getNewScoreboard();
        final Objective objective = board.registerNewObjective("test", "dummy");
        objective.setDisplaySlot(DisplaySlot.SIDEBAR);
        objective.setDisplayName(ChatColor.AQUA + name.toString());

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

        Score scoreEnd = objective.getScore(ChatColor.GRAY + "Update every"+ (ConfigManager.get().getInt("timer")/20) +"s");
        scoreEnd.setScore(-2);
        p.setScoreboard(board);
    }


}

