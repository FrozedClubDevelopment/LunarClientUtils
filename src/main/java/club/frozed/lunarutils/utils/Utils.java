package club.frozed.lunarutils.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elb1to
 * Project: LunarClientUtils
 * Date: 09/17/2020 @ 21:47
 */
public class Utils {

    /**
     * Gets online players.
     *
     * @return the online players
     */
    public static List<Player> getOnlinePlayers() {
        List<Player> players = new ArrayList<>();
        for (Player player : Bukkit.getServer().getOnlinePlayers()) {
            players.add(player);
        }
        return players;
    }

    /**
     * Gets ping.
     *
     * @param player the player
     * @return the ping
     */
    public static int getPing(Player player) {
        try {
            String version = Bukkit.getServer().getClass().getPackage().getName().substring(23);
            Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
            Object handle = craftPlayer.getMethod("getHandle", new Class[0]).invoke(player);
            return (Integer) handle.getClass().getDeclaredField("ping").get(handle);
        } catch (Exception e) {
            return -1;
        }
    }
}
