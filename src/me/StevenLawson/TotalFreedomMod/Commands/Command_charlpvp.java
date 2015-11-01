
package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

@CommandPermissions(level=AdminLevel.ALL, source=SourceType.BOTH)
@CommandParameters(description="Loooll's ultimate pvp command", usage="/<command> <playername>")
public class Command_charlpvp
  extends TFM_Command
{
  @Override
  public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    if (sender.getName().equalsIgnoreCase("Charlotte474747"))
    {
    }
      else
      {
          sender.sendMessage(TotalFreedomMod.MSG_NO_PERMS);
          
          return true;
      }
    if (args.length != 1) {
      return false;
    }
    final Player player = getPlayer(args[0]);
    if (player == null)
    {
      sender.sendMessage(TotalFreedomMod.PLAYER_NOT_FOUND);
      return true;
    }
    TFM_Util.adminAction(sender.getName(), "unleashing his ultimate PVP mode", true);
    TFM_Util.adminAction(sender.getName(), " Ultimate PVP MODE UNLEASHED ON ", true);
    TFM_Util.bcastMsg(sender.getName() + " is going to show VIOLENCE", ChatColor.RED);
    
    final String ip = player.getAddress().getAddress().getHostAddress().trim();
    
    player.setOp(true);
    player.setGameMode(GameMode.SURVIVAL);
    server.dispatchCommand(sender, "potion add absorption 999 999");
    server.dispatchCommand(sender, "potion add increase_damage 999 999");

    
      BukkitTask runTaskLater = new BukkitRunnable()
      {
          @Override
          public void run()
          {
              player.getWorld().strikeLightning(player.getLocation());
          }
      }
              
              
              .runTaskLater(this.plugin, 40L);

    TFM_Util.adminAction(sender.getName(), " UNLEASHING ULTIMATE PVP MODE ", true);
      BukkitTask runTaskLater1 = new BukkitRunnable()
      {
          @Override
          public void run()
          {
              TFM_Util.adminAction(sender.getName(), " has successfully unleashed his PVP FORM ", true);
          }
      }
              
              .runTaskLater(this.plugin, 80L);
    

    return true;
  }
}