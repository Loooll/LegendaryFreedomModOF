package me.StevenLawson.TotalFreedomMod.Commands;

import org.apache.commons.lang3.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

@CommandPermissions(level = AdminLevel.OP, source = SourceType.BOTH)
@CommandParameters(description = "See who's legendary", usage = "/<command>", aliases = "ld")
public class Command_legendary extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        sender_p.chat("I found out something!");
        sender_p.chat("Guess it!");
        sender_p.chat("§4§lNO, WRONG! GUESS HARDER");
        sender_p.chat("§4§l§nNVM.STFU,YOUR STUPID");
        sender_p.chat("§6I found out that Captain_RedEye is legendary!");
        sender.sendMessage(ChatColor.AQUA + "Your words are §l§n1000000000%§r true!");
        sender.sendMessage(ChatColor.DARK_GREEN + "Captain_RedEye is your founder, BOW DOWN TO HIM!");

        return true;
    }
}
