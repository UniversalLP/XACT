package xk.xact.client.gui.hooks;

import xk.xact.client.gui.tab.TabBase;

import java.util.List;

/**
 * Mark for GUIs that will use tabs.
 * @author Xhamolk_
 */
public interface TabbedGui {

	public List<TabBase> getTabs();

}