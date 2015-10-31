package me.StevenLawson.TotalFreedomMod.Commands;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "Information to be an admin!", usage = "/<command>", aliases = "admininfo")
public class Command_ai extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender_p.chat("Hai!I want to be admin!");
        sender_p.chat("Im going to do /ai now!");
        sender_p.chat("Hmm I'm going to read it");
        sender_p.chat("Please do not bother me!");
        sender.sendMessage(ChatColor.AQUA + "To be an admin, you would have to apply. Go to the forums!");
        sender.sendMessage(ChatColor.DARK_GREEN + "Out forum is 'legendary-freedom.boards.net'!");
        sender.sendMessage(ChatColor.AQUA + "You must have an admin recommendation");
        sender.sendMessage(ChatColor.RED + "I am going to show you a few tips on how to get one!");
        sender.sendMessage(ChatColor.DARK_PURPLE + "1. Always be respectful. 2.Never bug an admin for a recommendation");
        sender.sendMessage(ChatColor.RED + "3. Be helpful at all times! Follow these 3 tips and you might get an admin recommendation!");

        return true;
    }
}