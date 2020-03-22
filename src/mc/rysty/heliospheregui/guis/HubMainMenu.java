package mc.rysty.heliospheregui.guis;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import mc.rysty.heliospheregui.HelioSphereGUI;
import mc.rysty.heliospheregui.utils.SettingsManager;
import mc.rysty.heliospheregui.utils.Utils;

public class HubMainMenu implements Listener {

	@EventHandler
	public void onPlayerClick(PlayerInteractEvent e) {
		Player player = e.getPlayer();

		if (e.getItem() == null) {
			return;
		}
		ItemStack item = e.getItem();

		if (item.getItemMeta() == null) {
			return;
		}
		ItemMeta itemMeta = item.getItemMeta();

		if (itemMeta.getDisplayName() == null) {
			return;
		}
		String itemName = itemMeta.getDisplayName();
		String worldName = player.getWorld().getName();

		if (worldName.equalsIgnoreCase("Hub")) {
			if (itemName.equalsIgnoreCase(ChatColor.AQUA + "Main Menu")) {
				// Temporarily, the ChestCommands plugin will serve to display the MainMenu.
				if (Bukkit.getPluginManager().getPlugin("ChestCommands") != null) {
					String playerName = player.getName();

					Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "chestcommands open examplemenu " + playerName);
				}
				// openServerSelectorMenu(p);
			}
		}
	}

	@SuppressWarnings("deprecation")
	public static void openServerSelectorMenu(Player p) {
		HelioSphereGUI plugin = HelioSphereGUI.getInstance();
		FileConfiguration config = plugin.getConfig();
		FileConfiguration data = SettingsManager.getInstance().getData();
		Inventory serverSelectorMenu = Bukkit.createInventory(p, 54, ChatColor.DARK_AQUA + "Main Menu");
		ChatColor aqua = ChatColor.AQUA;
		ChatColor red = ChatColor.RED;
		ChatColor gray = ChatColor.GRAY;
		ChatColor darkAqua = ChatColor.DARK_AQUA;

		if (Bukkit.getWorld("Hub") != null) {
			// hub item
			World hubWorld = Bukkit.getWorld("Hub");
			ItemStack item = new ItemStack(Material.ENDER_EYE);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> itemLore = new ArrayList<>();
			int hubPlayers = hubWorld.getPlayers().size();
			itemLore.add(gray + "" + hubPlayers + " Currently connected");
			itemLore.add("");
			itemLore.add(gray + " > Click to warp to " + darkAqua + "The Hub");
			itemMeta.setDisplayName(aqua + "The Hub");
			itemMeta.setLore(itemLore);
			itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			item.setItemMeta(itemMeta);
			serverSelectorMenu.setItem(10, item);
		}

		if (Bukkit.getWorld("AugmentedSurvival") != null) {
			// augmented survival item
			World survivalWorld = Bukkit.getWorld("AugmentedSurvival");
			ItemStack item = new ItemStack(Material.GLOWSTONE_DUST);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> itemLore = new ArrayList<>();
			int survivalPlayers = survivalWorld.getPlayers().size();

			itemLore.add(gray + "" + survivalPlayers + " Currently connected");
			itemLore.add("");
			itemLore.add("");
			itemLore.add("");
			itemLore.add(data.getString("worlds.augmentedsurvival.closed") == "true"
					? red + "Currently closed for maintenance"
					: gray + " > Click to warp to " + darkAqua + "Augmented Survival");
			itemMeta.setDisplayName(aqua + "Augmented Survival");
			itemMeta.setLore(itemLore);
			itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			item.setItemMeta(itemMeta);
			serverSelectorMenu.setItem(11, item);
		}

		if (Bukkit.getWorld("Warzone") != null) {
			// warzone item
			World warzoneWorld = Bukkit.getWorld("Warzone");
			ItemStack item = new ItemStack(Material.FIRE_CHARGE);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> itemLore = new ArrayList<>();
			int warzonePlayers = warzoneWorld.getPlayers().size();
			itemLore.add(gray + "" + warzonePlayers + " Currently connected");
			itemLore.add("");
			itemLore.add("");
			itemLore.add("");
			itemLore.add(data.getString("worlds.warzone.closed") == "true" ? red + "Currently closed for maintenance"
					: gray + " > Click to warp to " + darkAqua + "Warzone");
			itemMeta.setDisplayName(aqua + "Warzone");
			itemMeta.setLore(itemLore);
			itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			item.setItemMeta(itemMeta);
			serverSelectorMenu.setItem(12, item);
		}

		if (Bukkit.getWorld("SkyForge") != null) {
			// skyforge item
			World skyforgeWorld = Bukkit.getWorld("SkyForge");
			ItemStack item = new ItemStack(Material.WHEAT_SEEDS);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> itemLore = new ArrayList<>();
			int skyforgePlayers = skyforgeWorld.getPlayers().size();
			itemLore.add(gray + "" + skyforgePlayers + " Currently connected");
			itemLore.add("");
			itemLore.add("");
			itemLore.add("");
			itemLore.add(data.getString("worlds.skyforge.closed") == "true" ? red + "Currently closed for maintenance"
					: gray + " > Click to warp to " + darkAqua + "SkyForge");
			itemMeta.setDisplayName(aqua + "SkyForge");
			itemMeta.setLore(itemLore);
			itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			item.setItemMeta(itemMeta);
			serverSelectorMenu.setItem(13, item);
		}

		if (Bukkit.getWorld("Moshpit") != null) {
			// moshpit item
			World moshPitWorld = Bukkit.getWorld("Moshpit");
			ItemStack item = new ItemStack(Material.FISHING_ROD);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> itemLore = new ArrayList<>();
			int moshpitPlayers = moshPitWorld.getPlayers().size();
			itemLore.add(gray + "" + moshpitPlayers + " Currently connected");
			itemLore.add("");
			itemLore.add("");
			itemLore.add("");
			itemLore.add(data.getString("worlds.moshpit.closed") == "true" ? red + "Currently closed for maintenance"
					: gray + " > Click to warp to " + darkAqua + "the Moshpit");
			itemMeta.setDisplayName(aqua + "The Moshpit");
			itemMeta.setLore(itemLore);
			itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			item.setItemMeta(itemMeta);
			serverSelectorMenu.setItem(14, item);
		}

		if (Bukkit.getWorld("Adventures") != null) {
			// adventures item
			World adventuresWorld = Bukkit.getWorld("Adventures");
			ItemStack item = new ItemStack(Material.GOLDEN_BOOTS);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> itemLore = new ArrayList<>();
			int adventuresPlayers = adventuresWorld.getPlayers().size();
			itemLore.add(gray + "" + adventuresPlayers + " Currently connected");
			itemLore.add("");
			itemLore.add("");
			itemLore.add("");
			itemLore.add(data.getString("worlds.adventures.closed") == "true" ? red + "Currently closed for maintenance"
					: gray + " > Click to warp to " + darkAqua + "Adventures");
			itemMeta.setDisplayName(aqua + "Adventures");
			itemMeta.setLore(itemLore);
			itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			item.setItemMeta(itemMeta);
			serverSelectorMenu.setItem(15, item);
		}

		if (Bukkit.getWorld("MinigamesHub") != null) {
			// minigames item
			World minigamesWorld = Bukkit.getWorld("MinigamesHub");
			ItemStack item = new ItemStack(Material.NETHER_STAR);
			ItemMeta itemMeta = item.getItemMeta();
			ArrayList<String> itemLore = new ArrayList<>();
			int minigamesPlayers = minigamesWorld.getPlayers().size();
			itemLore.add(gray + "" + minigamesPlayers + " Currently connected");
			itemLore.add("");
			itemLore.add(
					data.getString("worlds.minigameshub.closed") == "true" ? red + "Currently closed for maintenance"
							: gray + " > Click to warp to " + darkAqua + "Minigames Hub");
			itemMeta.setDisplayName(aqua + "Minigames Hub");
			itemMeta.setLore(itemLore);
			itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
			item.setItemMeta(itemMeta);
			serverSelectorMenu.setItem(28, item);

			if (data.getStringList("minigames").contains("tntRun")) {
				// tnt run item
				ItemStack item1 = new ItemStack(Material.TNT_MINECART);
				ItemMeta item1Meta = item1.getItemMeta();
				ArrayList<String> item1Lore = new ArrayList<>();
				item1Lore.add("");
				item1Lore.add("");
				item1Meta.setDisplayName(aqua + "TNT-Run");
				item1Meta.setLore(item1Lore);
				item1Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				item1.setItemMeta(item1Meta);
				serverSelectorMenu.setItem(29, item1);
			}

			if (data.getStringList("minigames").contains("survivalgames")) {
				// survivalgames item
				ItemStack item2 = new ItemStack(Material.IRON_HELMET);
				ItemMeta item2Meta = item2.getItemMeta();
				ArrayList<String> item2Lore = new ArrayList<>();
				item2Lore.add("");
				item2Lore.add("");
				item2Meta.setDisplayName(aqua + "The Survival Games");
				item2Meta.setLore(item2Lore);
				item2Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				item2.setItemMeta(item2Meta);
				serverSelectorMenu.setItem(30, item2);
			}

			if (data.getStringList("minigames").contains("sheepWars")) {
				// sheepwars item
				ItemStack item3 = new ItemStack(Material.SHEARS);
				ItemMeta item3Meta = item3.getItemMeta();
				ArrayList<String> item3Lore = new ArrayList<>();
				item3Lore.add("");
				item3Lore.add("");
				item3Meta.setDisplayName(aqua + "Sheep Wars");
				item3Meta.setLore(item3Lore);
				item3Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				item3.setItemMeta(item3Meta);
				serverSelectorMenu.setItem(31, item3);
			}

			if (data.getStringList("minigames").contains("slimeSpleef")) {
				// slime spleef item
				ItemStack item4 = new ItemStack(Material.SLIME_BALL);
				ItemMeta item4Meta = item4.getItemMeta();
				ArrayList<String> item4Lore = new ArrayList<>();
				item4Lore.add("");
				item4Lore.add("");
				item4Meta.setDisplayName(aqua + "Slime Spleef");
				item4Meta.setLore(item4Lore);
				item4Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				item4.setItemMeta(item4Meta);
				serverSelectorMenu.setItem(32, item4);
			}

			if (data.getStringList("minigames").contains("mobMadness")) {
				// mob madness item
				ItemStack item5 = new ItemStack(Material.ZOMBIE_HEAD);
				ItemMeta item5Meta = item5.getItemMeta();
				ArrayList<String> item5Lore = new ArrayList<>();
				item5Lore.add("");
				item5Lore.add("");
				item5Meta.setDisplayName(aqua + "Mob Madness");
				item5Meta.setLore(item5Lore);
				item5Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				item5.setItemMeta(item5Meta);
				serverSelectorMenu.setItem(33, item5);
			}

			if (data.getStringList("minigames").contains("snowballWarfare")) {
				// snowball warfare item
				ItemStack item6 = new ItemStack(Material.DIAMOND_HOE);
				ItemMeta item6Meta = item6.getItemMeta();
				ArrayList<String> item6Lore = new ArrayList<>();
				item6Lore.add("");
				item6Lore.add(Utils.chat(config.getString("guiMessages.snowballWarfare")));
				item6Meta.setDisplayName(aqua + "Snowball Warfare");
				item6Meta.setLore(item6Lore);
				item6Meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
				item6.setItemMeta(item6Meta);
				serverSelectorMenu.setItem(34, item6);
			}
		}

		// playerinfo item
		ItemStack playerInfoSkull = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta skullMeta = (SkullMeta) playerInfoSkull.getItemMeta();
		skullMeta.setOwner(p.getName());
		ArrayList<String> skullLore = new ArrayList<>();
		skullLore.add("");
		skullLore.add(gray + " > Click to view your player info");
		skullMeta.setLore(skullLore);
		skullMeta.setDisplayName(aqua + "Player Info");
		skullMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		playerInfoSkull.setItemMeta(skullMeta);
		serverSelectorMenu.setItem(47, playerInfoSkull);

		// preferences item
		ItemStack preferencesComparator = new ItemStack(Material.COMPARATOR);
		ItemMeta comparatorMeta = preferencesComparator.getItemMeta();
		ArrayList<String> comparatorLore = new ArrayList<>();
		comparatorLore.add("");
		comparatorLore.add(gray + " > Click to edit your preferences");
		comparatorMeta.setLore(comparatorLore);
		comparatorMeta.setDisplayName(aqua + "Preferences");
		comparatorMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		preferencesComparator.setItemMeta(comparatorMeta);
		serverSelectorMenu.setItem(49, preferencesComparator);

		// cosmetics item
		ItemStack cosmeticsCake = new ItemStack(Material.CAKE);
		ItemMeta cakeMeta = cosmeticsCake.getItemMeta();
		ArrayList<String> cakeLore = new ArrayList<>();
		cakeLore.add("");
		cakeLore.add(gray + " > Click to change your cosmetics");
		cakeMeta.setLore(cakeLore);
		cakeMeta.setDisplayName(aqua + "Cosmetics");
		cakeMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		cosmeticsCake.setItemMeta(cakeMeta);
		serverSelectorMenu.setItem(51, cosmeticsCake);

		// shop item
		ItemStack shopFrame = new ItemStack(Material.ITEM_FRAME);
		ItemMeta frameMeta = shopFrame.getItemMeta();
		ArrayList<String> frameLore = new ArrayList<>();
		frameLore.add("");
		frameLore.add(gray + " > Click to open the shop");
		frameMeta.setLore(frameLore);
		frameMeta.setDisplayName(aqua + "The Shop");
		frameMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		shopFrame.setItemMeta(frameMeta);
		serverSelectorMenu.setItem(53, shopFrame);

		// close item
		ItemStack closeBarrier = new ItemStack(Material.BARRIER);
		ItemMeta barrierMeta = closeBarrier.getItemMeta();
		ArrayList<String> barrierLore = new ArrayList<>();
		barrierLore.add("");
		barrierLore.add(gray + " > Click to close the menu");
		barrierMeta.setLore(barrierLore);
		barrierMeta.setDisplayName(red + "Close Menu");
		barrierMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		closeBarrier.setItemMeta(barrierMeta);
		serverSelectorMenu.setItem(45, closeBarrier);

		// coming soon item
		ItemStack comingSoonItem = new ItemStack(Material.GRAY_DYE);
		ItemMeta dyeMeta = comingSoonItem.getItemMeta();
		dyeMeta.setDisplayName(red + "Coming Soon!");
		ArrayList<String> dyeLore = new ArrayList<>();
		dyeLore.add("");
		dyeLore.add(gray + "What could this be? Who knows?");
		dyeMeta.setLore(dyeLore);
		comingSoonItem.setItemMeta(dyeMeta);
		serverSelectorMenu.setItem(16, comingSoonItem);

		p.openInventory(serverSelectorMenu);
	}
}
