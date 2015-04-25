package xk.xact.core.tileentities;


import java.util.ArrayList;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 *
 *
 */
public abstract class TileMachine extends TileEntity {

	public abstract ArrayList<ItemStack> getDropItems();

	public abstract Container getContainerFor(EntityPlayer player);

	@SideOnly(Side.CLIENT)
	public abstract GuiContainer getGuiContainerFor(EntityPlayer player);

//	@Override
//	public void onDataPacket(INetworkManager net, Packet132TileEntityData packet) {
//		if( packet.actionType == 0 )
//			readFromNBT( packet.data );
//	}
//
//	@Override
//	public Packet getDescriptionPacket() {
//		NBTTagCompound nbt = new NBTTagCompound();
//		writeToNBT( nbt );
//		return new Packet132TileEntityData(xCoord, yCoord, zCoord, 0, nbt);
//	}

	public void onBlockUpdate(int type) { }

}