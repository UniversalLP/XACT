package xk.xact.core;


import net.minecraft.src.EntityPlayer;
import net.minecraft.src.Item;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;
import xk.xact.XActMod;

import java.util.List;

// temporarily used to develop the library.
public class ItemCase extends Item {

	public ItemCase(int itemID) {
		super(itemID);
		this.setItemName("chipLibrary" );
		this.setIconIndex(2); // todo
		this.setMaxStackSize(1);
		this.setTextureFile(XActMod.TEXTURE_ITEMS);
		this.setCreativeTab(XActMod.xactTab);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
	    // Show how many chips are stored.
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		player.openGui(XActMod.instance, 1, world, 0, 0, 0);
		return itemStack;
	}


}
