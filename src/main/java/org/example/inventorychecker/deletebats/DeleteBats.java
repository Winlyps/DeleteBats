package org.example.inventorychecker.deletebats;// DeleteBats.java
import org.bukkit.Bukkit;
import org.bukkit.entity.Bat;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DeleteBats extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        // Remove existing bats from the world
        for (Entity entity : Bukkit.getWorlds().get(0).getEntities()) {
            if (entity instanceof Bat) {
                entity.remove();
            }
        }

        // Prevent new bats from spawning
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        if (event.getEntity() instanceof Bat) {
            event.setCancelled(true);
        }
    }
}





