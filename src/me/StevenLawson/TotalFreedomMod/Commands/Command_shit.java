
package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "Shits at someone", usage = "/<command> <playername>")
public class Command_shit extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        if (args.length != 1)
        {
            return false;
        }

        Player player = getPlayer(args[0]);

        // if the player is not online
        if (player == null)
        {
            playerMsg("That player is not online.");
            playerMsg("You can't shit at offline players.", ChatColor.YELLOW);
            return true;
        }

        TFM_Util.adminAction(sender.getName(), "Shits on " + player.getName() + "'s head", false);

        return true;
    }
}
