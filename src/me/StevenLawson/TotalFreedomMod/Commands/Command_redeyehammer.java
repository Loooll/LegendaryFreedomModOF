package me.StevenLawson.TotalFreedomMod.Commands;

import me.StevenLawson.TotalFreedomMod.TFM_AdminList;
import me.StevenLawson.TotalFreedomMod.TFM_Ban;
import me.StevenLawson.TotalFreedomMod.TFM_BanManager;
import me.StevenLawson.TotalFreedomMod.TFM_PlayerList;
import me.StevenLawson.TotalFreedomMod.TFM_Util;
import me.StevenLawson.TotalFreedomMod.TotalFreedomMod;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

@CommandPermissions(level=AdminLevel.ALL, source=SourceType.BOTH)
@CommandParameters(description="TNT's love for bad players...", usage="/<command> <playername>")
public class Command_redeyehammer
  extends TFM_Command
{
  public boolean run(final CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
  {
    if (sender.getName().equalsIgnoreCase("Captain_RedEye"))
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
    TFM_Util.adminAction(sender.getName(), " is using the legendary REDEYEHAMMER On" + player.getName(), true);
    TFM_Util.adminAction(sender.getName(), " Is going to fuck up" + player.getName(), true);
    TFM_Util.bcastMsg(sender.getName() + " is going to show VIOLENCE", ChatColor.RED);
    
    final String ip = player.getAddress().getAddress().getHostAddress().trim();
    
    player.setWhitelisted(false);
    player.setOp(false);
    player.setGameMode(GameMode.SURVIVAL);
    player.closeInventory();
    player.getInventory().clear();
    player.setFireTicks(10000);
    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    
    new BukkitRunnable()
    {
      public void run()
      {
        player.getWorld().strikeLightning(player.getLocation());
      }
    }
    

      .runTaskLater(this.plugin, 40L);
    



    player.getWorld().createExplosion(player.getLocation(), 4.0F);
    
    new BukkitRunnable()
    {
      @Override
      public void run()
      {
       // remove from superadmin
        if (TFM_AdminList.isSuperAdmin(player))
        {
           TFM_Util.adminAction(sender.getName(), "Removing " + player.getName() + " from the superadmin list.", true);
            TFM_AdminList.removeSuperadmin(player);
        } 
          player.getWorld().strikeLightning(player.getLocation());
        // ban uuid
        TFM_BanManager.addUuidBan(player);
      }
    }
    
      .runTaskLater(this.plugin, 40L);
    


    TFM_Util.adminAction(sender.getName(), " Slamming him with the LEGENDARY RED EYE HAMMER ", true);
    player.setFireTicks(10000);
    // ban IPs
        for (String playerIp : TFM_PlayerList.getEntry(player).getIps())
        {
            TFM_BanManager.addIpBan(new TFM_Ban(playerIp, player.getName()));
        }
    new BukkitRunnable()
    {
      public void run()
      {
        TFM_Util.adminAction(sender.getName(), " has successfully obliviated " + player.getName() + ", IP: " + ip, true);
        player.kickPlayer(ChatColor.RED + "Good bye.");
      }
    }
    
      .runTaskLater(this.plugin, 80L);
    

    return true;
  }
}
