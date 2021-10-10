package net.savagedev.mushroomspread;

import net.savagedev.mushroomspread.commands.MushroomSpreadCommand;
import net.savagedev.mushroomspread.listeners.MushroomSpreadListener;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class MushroomSpread extends JavaPlugin {
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.initListeners();
        this.initCommands();
    }

    private void initListeners() {
        final PluginManager pluginManager = this.getServer().getPluginManager();
        pluginManager.registerEvents(new MushroomSpreadListener(this), this);
    }

    private void initCommands() {
        final PluginCommand command = this.getCommand("mushroomspread");
        if (command == null) {
            this.getLogger().log(Level.SEVERE, "Unable to register command! Is it in the plugin.yml?");
        } else {
            command.setExecutor(new MushroomSpreadCommand(this));
        }
    }
}
