package net.savagedev.mushroomspread.listeners;

import net.savagedev.mushroomspread.MushroomSpread;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockSpreadEvent;

public class MushroomSpreadListener implements Listener {
    private final MushroomSpread mushroomSpread;

    public MushroomSpreadListener(MushroomSpread mushroomSpread) {
        this.mushroomSpread = mushroomSpread;
    }

    @EventHandler
    public void on(BlockSpreadEvent event) {
        if (this.mushroomSpread.getConfig().getBoolean("enabled")) {
            return; // Mushroom spread enabled.
        }

        // The resulting block's type.
        final Material material = event.getBlock().getType();

        // It's a mushroom. Cancel the event.
        if (material == Material.BROWN_MUSHROOM || material == Material.RED_MUSHROOM) {
            event.setCancelled(true);
        }
    }
}
