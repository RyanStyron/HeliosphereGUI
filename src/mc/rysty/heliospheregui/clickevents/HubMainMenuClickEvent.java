package mc.rysty.heliospheregui.clickevents;

import org.bukkit.Bukkit;
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
import mc.rysty.heliospheregui.guis.PlayerInfoMenu;
import mc.rysty.heliospheregui.utils.SettingsManager;
import mc.rysty.heliospheregui.utils.Utils;

public class HubMainMenuClickEvent implements Listener {

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

		if (title.equalsIgnoreCase(ChatColor.DARK_AQUA + "Main Menu")) {

			e.setCancelled(true);

			Player player = (Player) e.getWhoClicked();
			boolean noWorldBypass = !player.hasPermission("hs.toggleworld.bypass");
			String worldTpMessage = Utils.chat(config.getString("teleported_world_message"));
			String worldClosedMessage = Utils.chat(config.getString("ToggleWorld.world_maintenance_enabled"));

			if (e.getCurrentItem() == null) {
				return;
			}
			ItemStack item = e.getCurrentItem();

			if (item.getType() == null) {
				return;
			}
			Material itemType = item.getType();

			if (itemType == Material.ENDER_EYE) {
				player.teleport(Bukkit.getWorld("Hub").getSpawnLocation());
				player.closeInventory();
				player.sendMessage(worldTpMessage.replaceAll("<world>", "Hub"));
			}

			if (itemType == Material.BLAZE_ROD) {
				if (noWorldBypass && data.getString("worlds.augmentedsurvival.closed") == "true") {
					player.sendMessage(worldClosedMessage.replaceAll("<world>", "Augmented Survival"));
					player.closeInventory();
				} else {
					player.teleport(Bukkit.getWorld("AugmentedSurvival").getSpawnLocation());
					player.closeInventory();
					player.sendMessage(worldTpMessage.replaceAll("<world>", "Augmented Survival"));
				}
			}

			if (itemType == Material.FIRE_CHARGE) {
				if (noWorldBypass && data.getString("worlds.warzone.closed") == "true") {
					player.sendMessage(worldClosedMessage.replaceAll("<world>", "Warzone"));
					player.closeInventory();
				} else {
					player.teleport(Bukkit.getWorld("Warzone").getSpawnLocation());
					player.closeInventory();
					player.sendMessage(worldTpMessage.replaceAll("<world>", "Warzone"));
				}
			}

			if (itemType == Material.WHEAT_SEEDS) {
				if (noWorldBypass && data.getString("worlds.skyforge.closed") == "true") {
					player.sendMessage(worldClosedMessage.replaceAll("<world>", "SkyForge"));
					player.closeInventory();
				} else {
					player.teleport(Bukkit.getWorld("SkyForge").getSpawnLocation());
					player.closeInventory();
					player.sendMessage(worldTpMessage.replaceAll("<world>", "SkyForge"));
				}
			}
			
			if (itemType == Material.FISHING_ROD) {
				if (noWorldBypass && data.getString("worlds.moshpit.closed") == "true") {
					player.sendMessage(worldClosedMessage.replaceAll("<world>", "The Moshpit"));
					player.closeInventory();
				} else {
					player.teleport(Bukkit.getWorld("Moshpit").getSpawnLocation());
					player.closeInventory();
					player.sendMessage(worldTpMessage.replaceAll("<world>", "The Moshpit"));
				}
			}
			
			if (itemType == Material.GOLDEN_BOOTS) {
				if (noWorldBypass && data.getString("worlds.adventures.closed") == "true") {
					player.sendMessage(worldClosedMessage.replaceAll("<world>", "Adventures"));
					player.closeInventory();
				} else {
					player.teleport(Bukkit.getWorld("Adventures").getSpawnLocation());
					player.closeInventory();
					player.sendMessage(worldTpMessage.replaceAll("<world>", "Adventures"));
				}
			}

			if (itemType == Material.NETHER_STAR) {
				if (noWorldBypass && data.getString("worlds.minigameshub.closed") == "true") {
					player.sendMessage(worldClosedMessage.replaceAll("<world>", "Minigames"));
					player.closeInventory();
				} else {
					player.teleport(Bukkit.getWorld("MinigamesHub").getSpawnLocation());
					player.closeInventory();
					player.sendMessage(worldTpMessage.replaceAll("<world>", "Minigames"));
				}
			}

			if (itemType == Material.TNT_MINECART) {
				
			}
			
			

			if (itemType == Material.PLAYER_HEAD) {
				PlayerInfoMenu.openPlayerInfoMenu(player);
			}

			if (itemType == Material.BARRIER) {
				player.closeInventory();
			}
		}
	}
}
