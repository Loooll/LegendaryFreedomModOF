package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.SENIOR, source = SourceType.BOTH)
@CommandParameters(description = "Senior Administration Management", usage = "/<command> [saadd | sadelete] <username> [kick] [gtfo] <<username>> <<reason>>]", aliases = "system")
public class Command_sra extends TFM_Command
{
    private Object reason;

    @Override
    public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {

        if (!TFM_AdminList.isSeniorAdmin(sender))
        {
            playerMsg(ChatColor.WHITE + "Unknown command. Type \"help\" for help.");
            return true;
        }

        if (args.length != 2)
        {
            return false;
        }

        if (args[0].equalsIgnoreCase("saadd"))
        {
            Player player = null;
            String playername = null;

            player = getPlayer(args[1]);

            if (player != null)
            {
                TFM_Util.adminAction(sender.getName(), "Adding " + player.getName() + " to the superadmin list.", true);
                TFM_AdminList.addSuperadmin(player);
            }
            else if (playername != null)
            {
                TFM_Util.adminAction(sender.getName(), "Adding " + playername + " to the superadmin list.", true);
                TFM_AdminList.addSuperadmin(player);
            }
            return true;
        }

        else if (args[0].equalsIgnoreCase("sadelete") || args[0].equalsIgnoreCase("del") || args[0].equalsIgnoreCase("remove"))
        {

            String targetName = args[1];

            targetName = getPlayer(targetName).getName();

            if (!TFM_AdminList.getLowercaseSuperNames().contains(targetName.toLowerCase()))
            {
                playerMsg("Superadmin not found: " + targetName);
                return true;
            }

            TFM_Util.adminAction(sender.getName(), "Removing " + targetName + " from the superadmin list", true);
            TFM_AdminList.removeSuperadmin(Bukkit.getOfflinePlayer(targetName));

            return true;
        }
    return true;
}
