package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

@CommandPermissions(level = AdminLevel.SUPER, source = SourceType.BOTH)
@CommandParameters(description = "Shortcut to enable/disable WorldEdit.", usage = "/<command>")
public class Command_wetoggle extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Plugin targetPlugin = server.getPluginManager().getPlugin("WorldEdit");
        if (targetPlugin != null)
        {
            PluginManager pluginManager = plugin.getServer().getPluginManager();

            boolean enabled = targetPlugin.isEnabled();
            if (enabled)
            {
                pluginManager.disablePlugin(targetPlugin);
            }
            else
            {
                pluginManager.enablePlugin(targetPlugin);
            }

            TFM_Util.adminAction(sender.getName(), (!enabled ? "Enabled " : "Disabled ") + "WorldEdit.", true);
        }
        else
        {
            playerMsg(targetPlugin + " is not installed on this server.");
        }

        return true;
    }
}
