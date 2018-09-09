package main.java.com.github.judgetread.NoDropItem.sound;

import main.java.com.github.judgetread.NoDropItem.config.Config;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class SoundPlayer {

	private static SoundPlayer instance;
	private final boolean enabled;
	private final Sound sound;
	private final float volume;
	private final float pitch;
	
	private SoundPlayer() {
		this.enabled = Config.getInstance().getSoundEnabled();
		this.sound = Config.getInstance().getSound();
		this.volume = Config.getInstance().getSoundVolume();
		this.pitch = Config.getInstance().getSoundPitch();
	}

	public static SoundPlayer getInstance() {
		if (instance == null) {
			instance = new SoundPlayer();
		}
		return instance;
	}
	
	public void playSound(Player player) {
		if(player.isOnline() && this.enabled) {
			player.playSound(player.getLocation(), this.sound, this.volume, this.pitch);
		}
	}
}
