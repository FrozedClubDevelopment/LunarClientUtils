package club.frozed.lunarutils.utils.command;

import club.frozed.lunarutils.LunarClientUtils;

public abstract class BaseCommand {

    public LunarClientUtils plugin = LunarClientUtils.getInstance();

    public BaseCommand() {
        this.plugin.getCommandFramework().registerCommands(this);
    }

    public abstract void onCommand(CommandArgs cmd);
}
