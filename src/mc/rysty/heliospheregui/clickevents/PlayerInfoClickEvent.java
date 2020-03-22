package mc.rysty.heliospheregui.clickevents;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;

import mc.rysty.heliospheregui.HelioSphereGUI;
import mc.rysty.heliospheregui.guis.HubMainMenu;
import mc.rysty.heliospheregui.utils.SettingsManager;

public class PlayerInfoClickEvent implements Listener {

	HelioSphereGUI plugin = HelioSphereGUI.getInstance();
	FileConfiguration config = plugin.getConfig();
	SettingsManager settings = SettingsManager.getInstance();
	FileConfiguration data = settings.getData();

	@EventHandler
	public void onClick(InventoryClickEvent e) {
		if (e.getInventory() == null) {
			return;
		}
		if (e.getView() == null) {
			return;
		}
		InventoryView view = e.getView();

		if (view.getTitle() == null) {
			return;
		}
		String title = view.getTitle();
		Player player = (Player) e.getWhoClicked();

		if (title.equalsIgnoreCase(ChatColor.DARK_AQUA + "Player Info")) {

			e.setCancelled(true);

			if (e.getCurrentItem() == null) {
				return;
			}
			ItemStack item = e.getCurrentItem();

			if (item.getType() == null) {
				return;
			}
			Material itemType = item.getType();

			if (itemType == Material.BARRIER) {
				HubMainMenu.openServerSelectorMenu(player);
			}
		}
	}
}
