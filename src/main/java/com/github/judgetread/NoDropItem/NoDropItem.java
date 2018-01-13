package main.java.com.github.judgetread.NoDropItem;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import main.java.com.github.judgetread.NoDropItem.Listeners.NoDropItemListener;
import main.java.com.github.judgetread.NoDropItem.commands.CommandManager;
import main.java.com.github.judgetread.NoDropItem.config.Config;
import main.java.com.github.judgetread.NoDropItem.recipe.NDRecipe;
import main.java.com.github.judgetread.NoDropItem.sound.SoundPlayer;

public class NoDropItem extends JavaPlugin {

	private static NoDropItem instance;
	public boolean noErrorsInConfigFiles = true;
	private List<UUID> sdiMessagePlayer = new ArrayList<UUID>();

	@Override
	public void onEnable() {
		instance = this;

		Config.getInstance();
		if (!noErrorsInConfigFiles) {
			return;
		}

		if (Config.getInstance().getEnabled()) {
			SoundPlayer.getInstance();
			NDRecipe.getInstance();
			CommandManager.getInstance();
			Bukkit.getPluginManager().registerEvents(new NoDropItemListener(), this);
		}

	}

	public static NoDropItem getInstance() {
		return instance;
	}

	public List<UUID> getSdiMessagePlayer() {
		return sdiMessagePlayer;
	}

	public void debug(String message) {
		final Logger logger = this.getLogger();
		new BukkitRunnable() {
			@Override
			public void run() {
				logger.info(ChatColor.translateAlternateColorCodes('&', "[Debug] " + message));
			}
		}.runTask(this);
	}

}
