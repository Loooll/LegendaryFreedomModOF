package me.StevenLawson.TotalFreedomMod;

import me.StevenLawson.TotalFreedomMod.Config.TFM_ConfigEntry;
import static me.StevenLawson.TotalFreedomMod.TFM_Util.DEVELOPERS;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public enum TFM_PlayerRank
{
    DEVELOPER("a " + ChatColor.DARK_PURPLE + "Developer", ChatColor.DARK_PURPLE + "[Dev]"),
    IMPOSTOR("an " + ChatColor.YELLOW + ChatColor.UNDERLINE + "Impostor", ChatColor.YELLOW.toString() + ChatColor.UNDERLINE + "[IMP]"),
    NON_OP("a " + ChatColor.GREEN + "Non-OP", ChatColor.GREEN.toString()),
    OP("an " + ChatColor.RED + "OP", ChatColor.RED + "§8[§4Op§8]§c "),
    SUPER("a " + ChatColor.GOLD + "Super Admin", ChatColor.GOLD + "§8[§bSA§8]§c "),
    TELNET("a " + ChatColor.DARK_GREEN + "Super Telnet Admin", ChatColor.DARK_GREEN + "§8[§2STA§8]§c "),
    SENIOR("a " + ChatColor.LIGHT_PURPLE + "Senior Admin", ChatColor.LIGHT_PURPLE + "[SrA] "),
    OWNER("the " + ChatColor.BLUE + "Owner", ChatColor.BLUE + "[Owner]"),
    LEGENDARY("the " + ChatColor.BLUE + "§6LEG§5END§4ARY §4OWNER", ChatColor.BLUE + "§6[§4Le§6ge§5nd§bar§8y O§1wn§6er]§6 "),
    CONSOLE("The " + ChatColor.DARK_PURPLE + "Console", ChatColor.DARK_PURPLE + "[Console]"),
    LEADDEV("The " + ChatColor.DARK_PURPLE + "Lead Developer", ChatColor.DARK_PURPLE + "§8[§5Lead§8-§dDev§8]§c "),
    EXECUTIVE("a " + ChatColor.RED + "Executive", ChatColor.DARK_RED + "§8[§6Ex§5ecu§4tive§8]§c "),
    SYS("a " + ChatColor.DARK_RED + "System Admin", ChatColor.DARK_RED + "§8[§4Sys-Admin§8]§c "),
    LEADSYS("a " + ChatColor.DARK_RED + "Lead System Admin", ChatColor.DARK_RED + "§8[§fLea§7d-Sys-§8Adm§0in§8]§c "),
    SPECIALIST("a " + ChatColor.GOLD + "Specialist", ChatColor.GOLD + "§8[§6Spe§4cia§5list§8]§c "),
    CHEIFDEV("a " + ChatColor.GOLD + "CHEIFDEV", ChatColor.GOLD + "§8[§5Chief-Dev§8]§c "),
    COOWNER("the " + ChatColor.BLUE + "Co-Founder", ChatColor.BLUE + "§8[§9Co-Founder§8]§c ");
    private final String loginMessage;
    private final String prefix;

    private TFM_PlayerRank(String loginMessage, String prefix)
    {
        this.loginMessage = loginMessage;
        this.prefix = prefix;
    }

    public static String getLoginMessage(CommandSender sender)
    {
        // Handle console
        if (!(sender instanceof Player))
        {
            return fromSender(sender).getLoginMessage();
        }

        // Handle admins
        final TFM_Admin entry = TFM_AdminList.getEntry((Player) sender);
        if (entry == null)
        {
            // Player is not an admin
            return fromSender(sender).getLoginMessage();
        }

        // Custom login message
        final String loginMessage = entry.getCustomLoginMessage();

        if (loginMessage == null || loginMessage.isEmpty())
        {
            return fromSender(sender).getLoginMessage();
        }

        return ChatColor.translateAlternateColorCodes('&', loginMessage);
    }

    public static TFM_PlayerRank fromSender(CommandSender sender)
    {
        if (!(sender instanceof Player))
        {
            return CONSOLE;
        }

        if (TFM_AdminList.isAdminImpostor((Player) sender))
        {
            return IMPOSTOR;
        }

        if (DEVELOPERS.contains(sender.getName()))
        {
            return DEVELOPER;
        }
        if (sender.getName().equals("Captain_RedEye"))
        {
            return LEGENDARY;
        }

        final TFM_Admin entry = TFM_AdminList.getEntryByIp(TFM_Util.getIp((Player) sender));

        final TFM_PlayerRank rank;

        if (entry != null && entry.isActivated())
        {
            if (TFM_ConfigEntry.SERVER_OWNERS.getList().contains(sender.getName()))
            {
                return OWNER;
            }
            if (TFM_ConfigEntry.SERVER_EXECUTIVES.getList().contains(sender.getName()))
            {
                return EXECUTIVE;
            }
            if (TFM_ConfigEntry.SERVER_LEADDEV.getList().contains(sender.getName()))
            {
                return LEADDEV;
            }
            if (TFM_ConfigEntry.SERVER_CHEIFDEVS.getList().contains(sender.getName()))
            {
                return CHEIFDEV;
            }
            if (TFM_ConfigEntry.SERVER_SPECIALISTS.getList().contains(sender.getName()))
            {
                return SPECIALIST;
            }
            if (TFM_ConfigEntry.SERVER_SYSADMINS.getList().contains(sender.getName()))
            {
                return SYS;
            }
            if (TFM_ConfigEntry.SERVER_LEADSYS.getList().contains(sender.getName()))
            {
                return LEADSYS;
            }
            if (TFM_ConfigEntry.SERVER_COOWNER.getList().contains(sender.getName()))
            {
                return COOWNER;
            }
            if (entry.isSeniorAdmin())
            {
                rank = SENIOR;
            }
            else if (entry.isTelnetAdmin())
            {
                rank = TELNET;
            }
            else
            {
                rank = SUPER;
            }
        }
        else
        {
            if (sender.isOp())
            {
                rank = OP;
            }
            else
            {
                rank = NON_OP;
            }

        }
        return rank;
    }

    public String getPrefix()
    {
        return prefix;
    }

    public String getLoginMessage()
    {
        return loginMessage;
    }
}
