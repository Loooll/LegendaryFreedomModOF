package me.StevenLawson.TotalFreedomMod.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

@CommandPermissions(level = AdminLevel.ALL, source = SourceType.ONLY_IN_GAME)
@CommandParameters(description = "What do you think this is?", usage = "/<command>")
public class Command_nubparty extends TFM_Command
{
    @Override
    public boolean run(CommandSender sender, Player sender_p, Command cmd, String commandLabel, String[] args, boolean senderIsConsole)
    {
        Player player = Bukkit.getPlayer(sender.getName());
        PlayerInventory inv = player.getInventory();
        ItemStack dirt = new ItemStack(Material.DIRT, 500);
        ItemStack dead = new ItemStack(Material.DEAD_BUSH, 1);
        ItemStack bee = new ItemStack(Material.BEACON, 1);
        for (Enchantment ench : Enchantment.values())
        {
            if (ench.equals(Enchantment.LOOT_BONUS_MOBS) || ench.equals(Enchantment.LOOT_BONUS_BLOCKS))
            {
                continue;
            }
            dirt.addUnsafeEnchantment(ench, 1);
            dead.addUnsafeEnchantment(ench, 32767);
            bee.addUnsafeEnchantment(ench, 32767);
        }

        if (inv.contains(dirt))
        {
        }
        else
        {
            inv.addItem(dirt);
        }

        if (inv.contains(dead))
        {
        }
        else
        {
            inv.addItem(dead);
        }

        if (inv.contains(bee))
        {
        }
        else
        {
            inv.addItem(bee);
        }
        for (Enchantment ench : Enchantment.values())
        {
            if (ench.equals(Enchantment.LOOT_BONUS_MOBS) || ench.equals(Enchantment.LOOT_BONUS_BLOCKS))
            {
                continue;
            }
        }
        sender.sendMessage(ChatColor.RED + "Spare the dirt more, nubs..");
        return true;
    }
}