package club.frozed.lunarutils.utils.command;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Command Framework - Command <br>
 * The command annotation used to designate methods as commands. All methods
 * should have a single CommandArgs argument
 *
 * @author minnymin3
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Command {

    /**
     * The name of the command. If it is a sub command then its values would be
     * separated by periods. ie. a command that would be a subcommand of test
     * would be 'test.subcommandname'
     *
     * @return string string
     */
    public String name();

    /**
     * Gets the required permission of the command
     *
     * @return string string
     */
    public String permission() default "";

    /**
     * The message sent to the player when they do not have permission to
     * execute it
     *
     * @return string string
     */
    public String noPerm() default "§cYou do not have permission to perform that action";

    /**
     * A list of alternate names that the command is executed under. See
     * name() for details on how names work
     *
     * @return string [ ]
     */
    public String[] aliases() default {};

    /**
     * The description that will appear in /help of the command
     *
     * @return string string
     */
    public String description() default "";

    /**
     * The usage that will appear in /help (commandname)
     *
     * @return string string
     */
    public String usage() default "";

    /**
     * Whether or not the command is available to players only
     *
     * @return boolean boolean
     */
    public boolean inGameOnly() default false;
}
