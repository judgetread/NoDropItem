package main.java.com.github.judgetread.NoDropItem.recipe;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ShapedRecipe;

import main.java.com.github.judgetread.NoDropItem.config.Config;
import main.java.com.github.judgetread.NoDropItem.items.NDItem;

@SuppressWarnings("unused")
public class NDRecipe {

	private static NDRecipe instance;
	private final ShapedRecipe sdRecipe;

	@SuppressWarnings("deprecation")
	public NDRecipe() {
		
		this.sdRecipe = new ShapedRecipe(new NDItem().getSdiItemStack());
		
		this.sdRecipe.shape("ABC","DEF","GHI");

		this.sdRecipe.setIngredient('A', Config.getInstance().getTopLeftMaterial());
		this.sdRecipe.setIngredient('B', Config.getInstance().getTopMiddleMaterial());
		this.sdRecipe.setIngredient('C', Config.getInstance().getTopRightMaterial());

		this.sdRecipe.setIngredient('D', Config.getInstance().getMiddleLeftMaterial());
		this.sdRecipe.setIngredient('E', Config.getInstance().getMiddleMaterial());
		this.sdRecipe.setIngredient('F', Config.getInstance().getMiddleRightMaterial());

		this.sdRecipe.setIngredient('G', Config.getInstance().getBottomLeftMaterial());
		this.sdRecipe.setIngredient('H', Config.getInstance().getBottomMiddleMaterial());
		this.sdRecipe.setIngredient('I', Config.getInstance().getBottomRightMaterial());

		Bukkit.getServer().addRecipe(this.sdRecipe);
	}
	
	public static NDRecipe getInstance() {
		if (instance == null) {
			instance = new NDRecipe();
		}
		return instance;
	}

	
}
