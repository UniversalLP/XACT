package xk.xact.plugin.appliedenergistics;


import cpw.mods.fml.common.Loader;
import xk.xact.api.plugin.XACTPlugin;
import xk.xact.plugin.PluginManager;
import xk.xact.plugin.appliedenergistics.inventory.AEInventory;
import xk.xact.util.Utils;

/**
 * Plug-in for being able to pull crafting ingredients from the Applied Energistics network.
 * This might take a while to update
 * @author Xhamolk_
 */
public class PluginForAppliedEnergistics implements XACTPlugin {

	@Override
	public void initialize() {
//		if( Loader.isModLoaded( "appliedenergistics2" ) ) {
//			Utils.log( "Applied Energistics mod detected. Initializing plug-in..." );
////			PluginManager.registerInventoryAdapter( ITileInterfaceApi.class, new AEInventory.Provider() );
//			PluginManager.aeProxy = new AEProxy();
//		} else {
//			Utils.log( "Applied Energistics mod not detected. Plug-in not initialized." );
//		}
	}

}
