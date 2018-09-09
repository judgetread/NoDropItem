package main.java.com.github.judgetread.NoDropItem.Listeners;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

import main.java.com.github.judgetread.NoDropItem.NoDropItem;
import main.java.com.github.judgetread.NoDropItem.config.Config;
import main.java.com.github.judgetread.NoDropItem.items.NDItem;
import main.java.com.github.judgetread.NoDropItem.sound.SoundPlayer;
import main.java.com.github.judgetread.NoDropItem.utils.StrUtils;

public class NoDropItemListener implements Listener {

    private static final NoDropItem plugin = NoDropItem.getInstance();
    private final NDItem ndiItem = new NDItem();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        if ((event.getEntity() instanceof Player)) {
            Player player = event.getEntity();

            for (int i = 0; i < player.getInventory().getSize(); i++) {
                ItemStack inventoryItem = player.getInventory().getItem(i);

                if (inventoryItem != null && inventoryItem.isSimilar(this.ndiItem.getSdiItemStack())) {

                    if (Config.getInstance().getConsumeItem()) {
                        inventoryItem.setAmount(inventoryItem.getAmount() - 1);
                        if (inventoryItem.getAmount() < 1) {
                            inventoryItem.setType(Material.AIR);
                        }
                        player.getInventory().setItem(i, inventoryItem);
                    }

                    if (Config.getInstance().getRestoreInventory()) {
                        event.setKeepInventory(true);
                    }

                    if (Config.getInstance().getRestoreXPLevels()) {
                        event.setKeepLevel(true);
                    }

                    plugin.getSdiMessagePlayer().add(player.getUniqueId());
                    break;
                }
            }

        }
    }

    @EventHandler
    public void onPlayerRespawn(PlayerRespawnEvent e) {
        Player player = e.getPlayer();

        if (plugin.getSdiMessagePlayer().contains(player.getUniqueId())) {

            plugin.getSdiMessagePlayer().remove(player.getUniqueId());

            if (Config.getInstance().getChatEnabled()) {
                Config.getInstance().getChatMessage().forEach((str) -> {
                    player.sendMessage(StrUtils.convertText(str));
                });
            }

            SoundPlayer.getInstance().playSound(player);
        }

    }

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event) {
        if (event.hasItem()) {
            if (event.getItem().isSimilar(this.ndiItem.getSdiItemStack())) {
                event.setCancelled(true);
            }
        }
    }

}
