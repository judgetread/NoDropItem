package main.java.com.github.judgetread.NoDropItem.items;

import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import main.java.com.github.judgetread.NoDropItem.config.Config;
import main.java.com.github.judgetread.NoDropItem.utils.StrUtils;

public class NDItem {

	private static NDItem instance;
	private ItemStack itemStack;
	private ItemMeta itemMeta;

	private NDItem() {
		this.itemStack = new ItemStack(Config.getInstance().getItemMaterial());
		this.itemStack.setAmount(Config.getInstance().getItemAmount());
		
		this.itemMeta = this.itemStack.getItemMeta();
		this.itemMeta.setDisplayName(StrUtils.convertText(Config.getInstance().getItemDisplayName()));
		this.itemMeta.setLore(StrUtils.convertText(Config.getInstance().getItemLore()));
		
		for(ItemFlag f :ItemFlag.values()) { itemMeta.addItemFlags(f);}
		
		this.itemStack.setItemMeta(itemMeta);
		
	}

	public static NDItem getInstance() {
		if (instance == null) {
			instance = new NDItem();
		}
		return instance;
	}
	
	public ItemStack getSdiItemStack() {
		return itemStack;
	}
	
	
}
