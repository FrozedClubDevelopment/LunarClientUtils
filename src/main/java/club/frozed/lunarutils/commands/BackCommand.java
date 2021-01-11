package club.frozed.lunarutils.commands;

import club.frozed.lunarutils.utils.CC;
import club.frozed.lunarutils.utils.command.BaseCommand;
import club.frozed.lunarutils.utils.command.Command;
import club.frozed.lunarutils.utils.command.CommandArgs;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.UUID;

/**
 * Created by Elb1to
 * Project: LunarClientUtils
 * Date: 1/11/2021 @ 12:45 PM
 */
public class BackCommand extends BaseCommand {

    public static HashMap<UUID, Location> playerLocation = new HashMap<>();

    @Command(name = "back", aliases = {"backpos", "goback"})

    @Override
    public void onCommand(CommandArgs cmd) {
        Player player = cmd.getPlayer();

        if (playerLocation.containsKey(player.getUniqueId())) {
            player.teleport(playerLocation.get(player.getUniqueId()));
            player.sendMessage(CC.translate("&aSending you back to your previous death location."));
        } else {
            player.sendMessage(CC.translate("&cYou have already used the /back command."));
        }

        playerLocation.remove(player.getUniqueId());
    }
}
