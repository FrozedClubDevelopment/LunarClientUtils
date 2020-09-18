package club.frozed.lunarutils.utils;

import org.bukkit.ChatColor;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Cc.
 */
public class CC {

    /**
     * The constant MENU_BAR.
     */
    public static final String MENU_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH.toString() + "------------------------";
    /**
     * The constant CHAT_BAR.
     */
    public static final String CHAT_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH.toString() + "------------------------------------------------";
    /**
     * The constant SB_BAR.
     */
    public static final String SB_BAR = ChatColor.GRAY.toString() + ChatColor.STRIKETHROUGH.toString() + "----------------------";

    /**
     * Translate string.
     *
     * @param in the in
     * @return the string
     */
    public static String translate(String in) {
        return ChatColor.translateAlternateColorCodes('&', in);
    }

    /**
     * Translate list.
     *
     * @param lines the lines
     * @return the list
     */
    public static List<String> translate(List<String> lines) {
        List<String> toReturn = new ArrayList<>();

        for (String line : lines) {
            toReturn.add(ChatColor.translateAlternateColorCodes('&', line));
        }

        return toReturn;
    }

    /**
     * Translate list.
     *
     * @param lines the lines
     * @return the list
     */
    public static List<String> translate(String[] lines) {
        List<String> toReturn = new ArrayList<>();

        for (String line : lines) {
            if (line != null) {
                toReturn.add(ChatColor.translateAlternateColorCodes('&', line));
            }
        }

        return toReturn;
    }
}
