package xk.xact.network;


import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.World;
import xk.xact.core.*;
import xk.xact.gui.*;

public class CommonProxy implements IGuiHandler {

	public void registerRenderInformation() { }

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// ID:
			// 0: crafter
			// 1: library
			// 2: chip
            // 3: craft pad

        if( ID == 0 ) { // Crafter
            TileMachine machine = (TileMachine) world.getBlockTileEntity(x, y, z);
            if( machine == null )
                return null;

            if( machine instanceof TileEncoder ) { // todo: remove
                return new ContainerEncoder((TileEncoder) machine, player);
            }
            if( machine instanceof TileCrafter ) {
                return new ContainerCrafter((TileCrafter) machine, player);
            }
        }

		if( ID == 1 ) { // Chip Case
			ChipCase chipCase = new ChipCase(player.inventory.getCurrentItem());
			return new ContainerCase(chipCase, player);
		}

		if( ID == 2 ) { // Chip (unused)
			ChipDevice chipDevice = new ChipDevice(player.inventory.getCurrentItem(), player);
			return new ContainerChip(chipDevice, player);
		}

        if( ID == 3 ) { // Craft Pad
            CraftPad craftPad = new CraftPad(player.inventory.getCurrentItem(), player);
            return new ContainerPad(craftPad, player);
        }

		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		// ID:
            // 0: crafter
            // 1: library
            // 2: chip
            // 3: craft pad

		if( ID == 0 ) { // Crafter
            TileMachine machine = (TileMachine) world.getBlockTileEntity(x, y, z);
            if( machine == null )
                return null;

            if( machine instanceof TileEncoder ) { // todo: remove
                return new GuiEncoder((TileEncoder) machine, player);
            }
            if( machine instanceof TileCrafter ) {
                return new GuiCrafter((TileCrafter) machine, player);
            }
        }

		if( ID == 1 ) { // Chip Case
			ChipCase chipCase = new ChipCase(player.inventory.getCurrentItem());
			return new GuiCase(new ContainerCase(chipCase, player));
		}

		if( ID == 2 ) { // Chip (unused)
			ChipDevice chipDevice = new ChipDevice(player.inventory.getCurrentItem(), player);
			return new GuiChip(chipDevice, new ContainerChip(chipDevice, player));
		}

        if( ID == 3 ) { // Craft Pad
            CraftPad craftPad = new CraftPad(player.inventory.getCurrentItem(), player);
            return new GuiPad(craftPad, new ContainerPad(craftPad, player));
        }

		return null;
	}

}
