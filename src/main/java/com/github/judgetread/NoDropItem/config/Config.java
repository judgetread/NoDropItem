package main.java.com.github.judgetread.NoDropItem.config;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;
import org.bukkit.Sound;

/** @formatter:off */
public class Config extends AutoUpdateConfigLoader {

	private static Config instance;

	private Config() {
		super("config.yml");
		validate();
	}

	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}

	@Override
	protected boolean validateKeys() {
		List<String> reason = new ArrayList<String>();
		
		return noErrorsInConfig(reason);
	}

	@Override
	protected void loadKeys() {
	}
	

	public Boolean getEnabled() { return config.getBoolean("Settings.Enabled");}
	public Boolean getConsumeItem() { return config.getBoolean("Settings.Consume Item");}

	public Boolean getChatEnabled() { return config.getBoolean("Settings.Chat.Enabled");}
	public List<String> getChatMessage() { return config.getStringList("Settings.Chat.Usage Message");}

	public String getReceiverCompleted() { return config.getString("Settings.Chat.Command Messages.ReceiverCompleted");}
	public String getSenderCompleted() { return config.getString("Settings.Chat.Command Messages.SenderCompleted");}
	public String getSenderInventoryFull() { return config.getString("Settings.Chat.Command Messages.SenderInventoryFull");}
	public String getSenderPlayerNotOnline() { return config.getString("Settings.Chat.Command Messages.SenderPlayerNotOnline");}
	public String getSenderNoPlayerFound() { return config.getString("Settings.Chat.Command Messages.SenderNoPlayerFound");}
	public String getSenderUnknowCommand() { return config.getString("Settings.Chat.Command Messages.SenderUnknowCommand");}
	public String getSenderInvalidUsage() { return config.getString("Settings.Chat.Command Messages.SenderInvalidUsage");}
	public String getSenderNoPermission() { return config.getString("Settings.Chat.Command Messages.SenderNoPermission");}
	
	public String getItemDisplayName() { return config.getString("Settings.Item.Display Name");}	
	public Material getItemMaterial() { return Material.valueOf(config.getString("Settings.Item.Material"));}
	public Integer getItemAmount() { return config.getInt("Settings.Item.Amount");}
	public List<String> getItemLore() { return config.getStringList("Settings.Item.Lore");}	
	
	public Boolean getSoundEnabled() { return config.getBoolean("Settings.Sounds.Enabled"); }
	public Sound getSound() { return Sound.valueOf(config.getString("Settings.Sounds.Sound")); }
	public String getSoundVolume() { return config.getString("Settings.Sounds.Volume");}
	public String getSoundPitch() { return config.getString("Settings.Sounds.Pitch");}

	public Material getTopLeftMaterial() { return Material.valueOf(config.getString("Settings.Crafting.Crafting Pattern.TopLeft"));}
	public Material getTopMiddleMaterial() { return Material.valueOf(config.getString("Settings.Crafting.Crafting Pattern.TopMiddle"));}
	public Material getTopRightMaterial() { return Material.valueOf(config.getString("Settings.Crafting.Crafting Pattern.TopRight"));}
	public Material getMiddleLeftMaterial() { return Material.valueOf(config.getString("Settings.Crafting.Crafting Pattern.MiddleLeft"));}
	public Material getMiddleMaterial() { return Material.valueOf(config.getString("Settings.Crafting.Crafting Pattern.Middle"));}
	public Material getMiddleRightMaterial() { return Material.valueOf(config.getString("Settings.Crafting.Crafting Pattern.MiddleRight"));}
	public Material getBottomLeftMaterial() { return Material.valueOf(config.getString("Settings.Crafting.Crafting Pattern.BottomLeft"));}
	public Material getBottomMiddleMaterial() { return Material.valueOf(config.getString("Settings.Crafting.Crafting Pattern.BottomMiddle"));}
	public Material getBottomRightMaterial() { return Material.valueOf(config.getString("Settings.Crafting.Crafting Pattern.BottomRight"));}

	
}