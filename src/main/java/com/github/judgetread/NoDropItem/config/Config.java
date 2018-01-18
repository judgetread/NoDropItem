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
		
		/* Check Amount */
		if(config.getInt("Settings.Item.Amount") < 1 || config.getInt("Settings.Item.Amount") > 64 ) {
			reason.add("Settings.Item.Amount: Invalid amount entered. Must be between 1 & 64");
		}
		
		/* Check Materials */
		if(!validateMaterial(config.getString("Settings.Item.Material"))) {reason.add("Settings.Item.Material: Invalid material name entered.");}
		if(!validateMaterial(config.getString("Settings.Crafting.Crafting Pattern.TopLeft"))) {reason.add("Settings.Crafting.Crafting Pattern.TopLeft: Invalid material name entered.");}
		if(!validateMaterial(config.getString("Settings.Crafting.Crafting Pattern.TopMiddle"))) {reason.add("Settings.Crafting.Crafting Pattern.TopMiddle: Invalid material name entered.");}
		if(!validateMaterial(config.getString("Settings.Crafting.Crafting Pattern.TopRight"))) {reason.add("Settings.Crafting.Crafting Pattern.TopRight: Invalid material name entered.");}
		if(!validateMaterial(config.getString("Settings.Crafting.Crafting Pattern.MiddleLeft"))) {reason.add("Settings.Crafting.Crafting Pattern.MiddleLeft: Invalid material name entered.");}
		if(!validateMaterial(config.getString("Settings.Crafting.Crafting Pattern.Middle"))) {reason.add("Settings.Crafting.Crafting Pattern.Middle: Invalid material name entered.");}
		if(!validateMaterial(config.getString("Settings.Crafting.Crafting Pattern.MiddleRight"))) {reason.add("Settings.Crafting.Crafting Pattern.MiddleRight: Invalid material name entered.");}
		if(!validateMaterial(config.getString("Settings.Crafting.Crafting Pattern.BottomLeft"))) {reason.add("Settings.Crafting.Crafting Pattern.BottomLeft: Invalid material name entered.");}
		if(!validateMaterial(config.getString("Settings.Crafting.Crafting Pattern.BottomMiddle"))) {reason.add("Settings.Crafting.Crafting Pattern.BottomMiddle: Invalid material name entered.");}
		if(!validateMaterial(config.getString("Settings.Crafting.Crafting Pattern.BottomRight"))) {reason.add("Settings.Crafting.Crafting Pattern.BottomRight: Invalid material name entered.");}
		
		/* check sound */
		boolean foundSound = false;
			for(Sound s :Sound.values()) {
				if(s.toString().equalsIgnoreCase(config.getString("Settings.Sounds.Sound"))) {
					foundSound = true;
				}
			}
		if(!foundSound) {reason.add("Settings.Sounds.Sound: Invalid sound name entered.");}
		
		return noErrorsInConfig(reason);
	}
	
	private boolean validateMaterial(String material) {
		boolean foundMaterial = false;
		for(Material m :Material.values()) {
			if(m.toString().equalsIgnoreCase(material)) {
				foundMaterial = true;
			}
		}
		return foundMaterial;
	}

	@Override
	protected void loadKeys() {
	}
	

	public Boolean getEnabled() { return config.getBoolean("Settings.Enabled", true);}
	public Boolean getRestoreInventory() { return config.getBoolean("Settings.Keep Inventory", true);}
	public Boolean getRestoreXPLevels() { return config.getBoolean("Settings.Keep XP Levels", true);}
	public Boolean getConsumeItem() { return config.getBoolean("Settings.Consume Item", true);}

	public Boolean getChatEnabled() { return config.getBoolean("Settings.Chat.Enabled");}
	public List<String> getChatMessage() { return config.getStringList("Settings.Chat.Usage Message");}

	public String getReceiverCompleted() { return config.getString("Settings.Chat.Command Messages.ReceiverCompleted","");}
	public String getSenderCompleted() { return config.getString("Settings.Chat.Command Messages.SenderCompleted","");}
	public String getSenderInventoryFull() { return config.getString("Settings.Chat.Command Messages.SenderInventoryFull","");}
	public String getSenderPlayerNotOnline() { return config.getString("Settings.Chat.Command Messages.SenderPlayerNotOnline","");}
	public String getSenderNoPlayerFound() { return config.getString("Settings.Chat.Command Messages.SenderNoPlayerFound","");}
	public String getSenderUnknowCommand() { return config.getString("Settings.Chat.Command Messages.SenderUnknowCommand","");}
	public String getSenderInvalidUsage() { return config.getString("Settings.Chat.Command Messages.SenderInvalidUsage","");}
	public String getSenderNoPermission() { return config.getString("Settings.Chat.Command Messages.SenderNoPermission","");}
	
	public String getItemDisplayName() { return config.getString("Settings.Item.Display Name","");}	
	public Material getItemMaterial() { return Material.valueOf(config.getString("Settings.Item.Material", "END_CRYSTAL"));}
	public Integer getItemAmount() { return config.getInt("Settings.Item.Amount", 1);}
	public List<String> getItemLore() { return config.getStringList("Settings.Item.Lore");}	
	
	public Boolean getSoundEnabled() { return config.getBoolean("Settings.Sounds.Enabled", true); }
	public Sound getSound() { return Sound.valueOf(config.getString("Settings.Sounds.Sound", "ENTITY_GHAST_SCREAM")); }
	public float getSoundVolume() { return (float) config.getDouble("Settings.Sounds.Volume", 1.0);}
	public float getSoundPitch() { return (float) config.getDouble("Settings.Sounds.Pitch", 1.0);}

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