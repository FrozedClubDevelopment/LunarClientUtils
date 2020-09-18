package club.frozed.lunarutils.commands;

import club.frozed.lunarutils.LunarClientUtils;
import club.frozed.lunarutils.utils.CC;
import club.frozed.lunarutils.utils.Utils;
import club.frozed.lunarutils.utils.command.BaseCommand;
import club.frozed.lunarutils.utils.command.Command;
import club.frozed.lunarutils.utils.command.CommandArgs;
import com.lunarclient.bukkitapi.LunarClientAPI;
import org.apache.commons.lang.StringUtils;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elb1to
 * Project: LunarClientUtils
 * Date: 09/17/2020 @ 21:47
 */
public class LunarClientCommand extends BaseCommand {
    @Command(name = "lunarclient", aliases = {"lc", "lc-api", "lcapi"})

    @Override
    public void onCommand(CommandArgs cmd) {
        Player player = cmd.getPlayer();

        player.sendMessage(CC.CHAT_BAR);
        player.sendMessage(CC.translate("&b&lLunarClientUtils &8- &7v" + LunarClientUtils.getInstance().getDescription().getVersion()));
        player.sendMessage(CC.translate(" "));
        player.sendMessage(CC.translate("&3 ▶ &bPlayers using LunarClient &7[AC-OFF]&8: &f" + nonAntiCheatPlayers().size()));
        if (nonAntiCheatPlayers().isEmpty()) {
            player.sendMessage(CC.translate("&cNo players with LunarClient [AC-OFF]"));
        } else {
            player.sendMessage(CC.translate(StringUtils.join(nonAntiCheatPlayers(), "\n")));
        }
        player.sendMessage(CC.translate(" "));
        player.sendMessage(CC.translate("&3 ▶ &bPlayers using LunarClient &7[AC-ON]&8: &f" + antiCheatPlayers().size()));
        if (antiCheatPlayers().isEmpty()) {
            player.sendMessage(CC.translate("&4 ▶ &cNobody is using LunarClient [AC-ON]"));
        } else {
            player.sendMessage(CC.translate(StringUtils.join(antiCheatPlayers(), "\n")));
        }
        player.sendMessage(CC.CHAT_BAR);
    }

    private List<String> nonAntiCheatPlayers() {
        List<String> players = new ArrayList<>();
        for (Player player : Utils.getOnlinePlayers()) {
            if (LunarClientAPI.getInstance().isRunningLunarClient(player)) {
                if (!LunarClientAPI.getInstance().isRunningAntiCheat(player)) {
                    players.add(CC.translate(" &7 ➥ " + player.getName()));
                }
            }
        }
        return players;
    }

    private List<String> antiCheatPlayers() {
        List<String> players = new ArrayList<>();
        for (Player player : Utils.getOnlinePlayers()) {
            if (LunarClientAPI.getInstance().isRunningLunarClient(player)) {
                if (LunarClientAPI.getInstance().isRunningAntiCheat(player)) {
                    players.add(CC.translate(" &7 ➥ " + player.getName()));
                }
            }
        }
        return players;
    }
}
