package main.java.com.github.judgetread.NoDropItem.recipe;

import org.bukkit.Bukkit;
import org.bukkit.inventory.ShapedRecipe;

import main.java.com.github.judgetread.NoDropItem.config.Config;
import main.java.com.github.judgetread.NoDropItem.items.NDItem;

@SuppressWarnings("unused")
public class NDRecipe {

	private static NDRecipe instance;
	private ShapedRecipe sdRecipe;

	@SuppressWarnings("deprecation")
	public NDRecipe() {
		
		ShapedRecipe sdRecipe = new ShapedRecipe(NDItem.getInstance().getSdiItemStack());
		
		sdRecipe.shape("ABC","DEF","GHI");

		sdRecipe.setIngredient('A', Config.getInstance().getTopLeftMaterial());
		sdRecipe.setIngredient('B', Config.getInstance().getTopMiddleMaterial());
		sdRecipe.setIngredient('C', Config.getInstance().getTopRightMaterial());

		sdRecipe.setIngredient('D', Config.getInstance().getMiddleLeftMaterial());
		sdRecipe.setIngredient('E', Config.getInstance().getMiddleMaterial());
		sdRecipe.setIngredient('F', Config.getInstance().getMiddleRightMaterial());

		sdRecipe.setIngredient('G', Config.getInstance().getBottomLeftMaterial());
		sdRecipe.setIngredient('H', Config.getInstance().getBottomMiddleMaterial());
		sdRecipe.setIngredient('I', Config.getInstance().getBottomRightMaterial());

		Bukkit.getServer().addRecipe(sdRecipe);
	}
	
	public static NDRecipe getInstance() {
		if (instance == null) {
			instance = new NDRecipe();
		}
		return instance;
	}

	
}
