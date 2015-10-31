package me.StevenLawson.TotalFreedomMod.Commands;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "About the server", usage = "/<command>", aliases = "about")
public class Command_about extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender.sendMessage(ChatColor.AQUA + "Welcome to §6Legendary§5Freedom§4!");
        sender.sendMessage(ChatColor.AQUA + "The Owner is Captain_Redeye");
        sender.sendMessage(ChatColor.LIGHT_PURPLE + "If you'd like to apply for admin, type /ai");
        sender.sendMessage(ChatColor.BLUE + "This server has alot of features!");
        sender.sendMessage(ChatColor.DARK_RED + "---ABOUT CUSTOM COMMANDS---");
        sender.sendMessage(ChatColor.BLUE + "Loooll coded these commands: /poop /redeyehammer /party.Much more epic commands will COME!");

        return true;
    }
}

