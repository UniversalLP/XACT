package xk.xact.recipes;


import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.world.World;
import xk.xact.inventory.InventoryUtils;
import xk.xact.util.FakeCraftingInventory;

public class RecipeUtils {


	public static boolean matchesIngredient(CraftRecipe recipe, ItemStack ingredient, ItemStack otherStack, World world) {
		try {
			IRecipe iRecipe = recipe.getRecipePointer().getIRecipe();

			int ingredientIndex = getIngredientIndex( recipe, ingredient );
			if( ingredientIndex == -1 )
				return false;

			FakeCraftingInventory craftingGrid = FakeCraftingInventory.emulateContents( recipe.getIngredients() );
			craftingGrid.setInventorySlotContents( ingredientIndex, otherStack );

			if( !iRecipe.matches( craftingGrid, world ) )
				return false;

			ItemStack nominalResult = recipe.getResult();
			ItemStack realResult = iRecipe.getCraftingResult( craftingGrid );

			return InventoryUtils.similarStacks( nominalResult, realResult, false );
		} catch( NullPointerException npe ) {
			return false;
		}
	}

	public static int getIngredientIndex(CraftRecipe recipe, ItemStack ingredient) {
		ItemStack[] ingredients = recipe.getIngredients();
		int size = ingredients.length;
		for( int i = 0; i < size; i++ ) {
			if( ingredients[i] != null && ingredients[i].isItemEqual( ingredient ) )
				return i;
		}
		return -1;
	}


	public static CraftRecipe getRecipe(ItemStack recipeChip, World world) {
		CraftRecipe recipe = CraftManager.decodeRecipe( recipeChip );
		if( recipe != null ) {
			if( recipe.validate( world ) )
				return recipe;
		}
		return null;
	}

	public static CraftRecipe getRecipe(ItemStack[] gridContents, World world) {
		CraftRecipe recipe = CraftManager.generateRecipe( gridContents, world );
		if( recipe != null ) {
			if( recipe.validate( world ) )
				return recipe;
		}
		return null;
	}

	public static ItemStack[] ingredients(Object... objects) {
		ItemStack[] retValue = new ItemStack[objects.length];
		for( int i = 0; i < objects.length; i++ ) {
			Object o = objects[i];
			if( o == null ) {
				retValue[i] = null;
			} else {
				if( o instanceof Item ) {
					retValue[i] = new ItemStack( (Item) o );
					continue;
				}
				if( o instanceof Block ) {
					retValue[i] = new ItemStack( (Block) o );
				}
				if( o instanceof ItemStack )
					retValue[i] = (ItemStack) o;
			}
		}
		return retValue;
	}

}
