package main.java.com.github.judgetread.NoDropItem.items;

import main.java.com.github.judgetread.NoDropItem.config.Config;
import main.java.com.github.judgetread.NoDropItem.utils.StrUtils;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class NDItem {

	private final ItemStack itemStack;
	private final ItemMeta itemMeta;

	public NDItem() {
		this.itemStack = new ItemStack(Config.getInstance().getItemMaterial());
		this.itemStack.setAmount(Config.getInstance().getItemAmount());
		
		this.itemMeta = this.itemStack.getItemMeta();
		this.itemMeta.setDisplayName(StrUtils.convertText(Config.getInstance().getItemDisplayName()));
		this.itemMeta.setLore(StrUtils.convertText(Config.getInstance().getItemLore()));
		
		for(ItemFlag f :ItemFlag.values()) { this.itemMeta.addItemFlags(f);}
		
		this.itemStack.setItemMeta(this.itemMeta);
		
	}
	
	public ItemStack getSdiItemStack() {
		return this.itemStack;
	}
	
	
}
