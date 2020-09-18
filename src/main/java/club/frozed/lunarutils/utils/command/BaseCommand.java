package club.frozed.lunarutils.utils.command;

import club.frozed.lunarutils.LunarClientUtils;

/**
 * The type Base command.
 */
public abstract class BaseCommand {

    /**
     * The Plugin.
     */
    public LunarClientUtils plugin = LunarClientUtils.getInstance();

    /**
     * Instantiates a new Base command.
     */
    public BaseCommand() {
        this.plugin.getCommandFramework().registerCommands(this);
    }

    /**
     * On command.
     *
     * @param cmd the cmd
     */
    public abstract void onCommand(CommandArgs cmd);
}
