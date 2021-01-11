package club.frozed.lunarutils.player;

import club.frozed.lunarutils.commands.BackCommand;
import club.frozed.lunarutils.utils.CC;
import com.lunarclient.bukkitapi.LunarClientAPI;
import com.lunarclient.bukkitapi.object.LCNotification;
import com.lunarclient.bukkitapi.object.TitleType;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;

import java.time.Duration;
import java.util.UUID;

/**
 * Created by Elb1to
 * Project: LunarClientUtils
 * Date: 09/17/2020 @ 21:47
 */
public class PlayerListener implements Listener {

    private final LunarClientAPI lunarClientAPI = LunarClientAPI.getInstance();

    /**
     * On player join.
     *
     * @param event the event
     */
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        /*
         * IMPORTANT: The Official LunarClient API (which is being used on this small project)
         * has all LunarClient methods available for development, but to check whether or not
         * a Player has LunarClient's AntiCheat ON or OFF, you may need to be PARTNERED with
         * LunarClient in order for the API to make those checks successfully.
         *
         * Also, LunarClient StaffModules ONLY work on the 1.7.10 LunarClient Version.
         *
         * This plugin is just made as a "base" or usage example of LunarClient's Official API.
         */

        if (lunarClientAPI.isRunningLunarClient(player)) {
            player.sendMessage(CC.translate("&aSuccess! &7You've been authenticated for using &bLunar Client&7."));
            player.sendMessage(CC.translate("&b&lNOTICE&7: &fYou're running LunarClient without the AntiCheat enabled."));
        } else if (lunarClientAPI.isRunningAntiCheat(player)) {
            player.sendMessage(CC.translate("&aSuccess! &7You've been authenticated for using &bLunar Client&7."));
            player.sendMessage(CC.translate("&b&lNOTICE&7: &fYou're running LunarClient with the AntiCheat enabled."));
        } else {
            lunarClientAPI.sendNotification(player, new LCNotification("LunarClientAPI - Successfully authenticated.", Duration.ofSeconds(5L)));

            lunarClientAPI.sendTitle(player, TitleType.TITLE, CC.translate("&b&lLunarClient&bAPI"), 1.0F, Duration.ofSeconds(2L), Duration.ofSeconds(6L), Duration.ofSeconds(2L));
            lunarClientAPI.sendTitle(player, TitleType.SUBTITLE, CC.translate("&aSuccessfully Authenticated"), 1.0F, Duration.ofSeconds(2L), Duration.ofSeconds(6L), Duration.ofSeconds(2L));

            if (player.hasPermission("lunar.utils.staff-modules")) {
                lunarClientAPI.giveAllStaffModules(player);
                player.sendMessage(CC.translate("&8[&bLunarClient&8] &7You have received all Staff-Modules. "));
            }
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = Bukkit.getPlayer(event.getEntity().getUniqueId());
        if (event.getEntity() == player) {
            BackCommand.playerLocation.put(player, player.getLocation());
        }
        player.sendMessage(CC.translate("&cYou died, your last death location has been saved! &7&oUse /back to go back to it."));
    }
}
