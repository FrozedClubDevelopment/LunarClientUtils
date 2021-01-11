package club.frozed.lunarutils;

import club.frozed.lunarutils.commands.BackCommand;
import club.frozed.lunarutils.commands.LunarClientCommand;
import club.frozed.lunarutils.player.PlayerListener;
import club.frozed.lunarutils.utils.command.CommandFramework;
import lombok.Getter;
import lombok.Setter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

@Getter @Setter
public final class LunarClientUtils extends JavaPlugin {

    @Getter public static LunarClientUtils instance;
    private CommandFramework commandFramework;

    @Override
    public void onEnable() {
        instance = this;

        commandFramework = new CommandFramework(this);
        commandFramework.registerCommands(new BackCommand());
        commandFramework.registerCommands(new LunarClientCommand());

        Bukkit.getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {
        instance = null;
    }
}
