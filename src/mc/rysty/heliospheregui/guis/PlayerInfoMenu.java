package mc.rysty.heliospheregui.guis;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

import mc.rysty.heliospheregui.utils.Utils;

public class PlayerInfoMenu {

	@SuppressWarnings("deprecation")
	public static void openPlayerInfoMenu(Player player) {
		Inventory playerInfoMenu = Bukkit.createInventory(player, 36, ChatColor.DARK_AQUA + "Player Info");
		ChatColor aqua = ChatColor.AQUA;
		ChatColor red = ChatColor.RED;
		ChatColor gray = ChatColor.GRAY;
		ChatColor white = ChatColor.WHITE;
		String pName = player.getName();

		// friends list item
		ItemStack friendListFlower = new ItemStack(Material.SUNFLOWER);
		ItemMeta flowerMeta = friendListFlower.getItemMeta();
		flowerMeta.setDisplayName(aqua + "Friends List");
		ArrayList<String> flowerLore = new ArrayList<>();
		flowerLore.add("");
		flowerLore.add(gray + " > Click to view your friends list");
		flowerMeta.setLore(flowerLore);
		flowerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		friendListFlower.setItemMeta(flowerMeta);
		playerInfoMenu.setItem(10, friendListFlower);

		// player stats item
		ItemStack playerStatsNametag = new ItemStack(Material.NAME_TAG);
		ItemMeta nametagMeta = playerStatsNametag.getItemMeta();
		nametagMeta.setDisplayName(aqua + "Player Stats");
		ArrayList<String> tagLore = new ArrayList<>();
		tagLore.add("");
		tagLore.add(gray + " > Click to view your stats from each game");
		nametagMeta.setLore(tagLore);
		nametagMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		playerStatsNametag.setItemMeta(nametagMeta);
		playerInfoMenu.setItem(12, playerStatsNametag);

		// achievements item
		ItemStack achievementsSaddle = new ItemStack(Material.SADDLE);
		ItemMeta saddleMeta = achievementsSaddle.getItemMeta();
		saddleMeta.setDisplayName(aqua + "Achievements");
		ArrayList<String> saddleLore = new ArrayList<>();
		saddleLore.add("");
		saddleLore.add(gray + " > Click to view your achievements list");
		saddleMeta.setLore(saddleLore);
		saddleMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		achievementsSaddle.setItemMeta(saddleMeta);
		playerInfoMenu.setItem(14, achievementsSaddle);
		
		// party item
		ItemStack rankClock = new ItemStack(Material.CLOCK);
		ItemMeta clockMeta = rankClock.getItemMeta();
		clockMeta.setDisplayName(aqua + "Player Rank");
		ArrayList<String> clockLore = new ArrayList<>();
		clockLore.add("");
		clockLore.add(red + "You are not in a party!");
		clockMeta.setLore(clockLore);
		clockMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		rankClock.setItemMeta(clockMeta);
		playerInfoMenu.setItem(16, rankClock);

		// player item
		ItemStack playerItemSkull = new ItemStack(Material.PLAYER_HEAD);
		SkullMeta skullMeta = (SkullMeta) playerItemSkull.getItemMeta();
		skullMeta.setOwner(pName);
		ArrayList<String> skullLore = new ArrayList<>();
		skullLore.add("");
		if (Bukkit.getPluginManager().getPlugin("HS-Ranks") != null) {
			FileConfiguration ranksConfig = Bukkit.getPluginManager().getPlugin("HS-Ranks").getConfig();
			String playerGroup = ranksConfig.getString("Players." + pName + ".group");

			skullLore.add(white + "Group: "
					+ (ranksConfig.getString("Players." + pName + ".prefix") != null
							? Utils.chat(ranksConfig.getString("Players." + pName + ".prefix"))
							: Utils.chat(ranksConfig.getString("Groups." + playerGroup + ".prefix"))));
		}
		skullLore.add(white + "Title: ");
		skullLore.add(white + "Coins: " + ChatColor.YELLOW);
		skullLore.add(white + "Server Score: " + ChatColor.GREEN);
		skullMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		skullMeta.setLore(skullLore);
		skullMeta.setDisplayName(aqua + pName);
		playerItemSkull.setItemMeta(skullMeta);
		playerInfoMenu.setItem(35, playerItemSkull);

		// back item
		ItemStack backBarrier = new ItemStack(Material.BARRIER);
		ItemMeta barrierMeta = backBarrier.getItemMeta();
		ArrayList<String> barrierLore = new ArrayList<>();
		barrierLore.add("");
		barrierLore.add(gray + " > Click to go back to the main menu");
		barrierMeta.setLore(barrierLore);
		barrierMeta.setDisplayName(red + "Back");
		barrierMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
		backBarrier.setItemMeta(barrierMeta);
		playerInfoMenu.setItem(27, backBarrier);

		player.openInventory(playerInfoMenu);
	}
}
