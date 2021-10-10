package net.savagedev.mushroomspread.commands;

import net.savagedev.mushroomspread.MushroomSpread;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MushroomSpreadCommand implements CommandExecutor {
    private final MushroomSpread mushroomSpread;

    public MushroomSpreadCommand(MushroomSpread mushroomSpread) {
        this.mushroomSpread = mushroomSpread;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cInvalid arguments! Try: /mushroomspread <true|false>"));
            return true;
        }

        final boolean enabled = Boolean.parseBoolean(args[0]);
        if (enabled) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&aMushroom spread enabled!"));
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cMushroom spread disabled!"));
        }
        this.mushroomSpread.getConfig().set("enabled", enabled);
        this.mushroomSpread.saveConfig();
        return true;
    }
}
