package club.frozed.lunarutils.commands;

import club.frozed.lunarutils.utils.CC;
import club.frozed.lunarutils.utils.command.BaseCommand;
import club.frozed.lunarutils.utils.command.Command;
import club.frozed.lunarutils.utils.command.CommandArgs;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;

/**
 * Created by Elb1to
 * Project: LunarClientUtils
 * Date: 1/11/2021 @ 12:45 PM
 */
public class BackCommand extends BaseCommand {

    public static HashMap<Player, Location> playerLocation = new HashMap<>();

    @Command(name = "back", aliases = {"backpos", "goback"})

    @Override
    public void onCommand(CommandArgs cmd) {
        Player player = cmd.getPlayer();

        player.teleport(playerLocation.get(player));
        player.sendMessage(CC.translate("&aSending you back to your previous death location."));
    }
}
