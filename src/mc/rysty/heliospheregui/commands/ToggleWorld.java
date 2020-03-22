package mc.rysty.heliospheregui.commands;

import java.util.Collection;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import mc.rysty.heliospheregui.HelioSphereGUI;
import mc.rysty.heliospheregui.utils.SettingsManager;
import mc.rysty.heliospheregui.utils.Utils;

public class ToggleWorld implements CommandExecutor {

	HelioSphereGUI plugin = HelioSphereGUI.getInstance();
	FileConfiguration config = plugin.getConfig();
	SettingsManager settings = SettingsManager.getInstance();
	FileConfiguration data = settings.getData();

	public ToggleWorld(HelioSphereGUI plugin) {
		plugin.getCommand("toggleworld").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("toggleworld")) {
			String noPermMessage = Utils.chat(config.getString("no_perm_message"));

			if (sender.hasPermission("hs.toggleworld")) {
				if (args.length == 1) {
					String arg = args[0].toLowerCase();
					String worldClosedMessage = Utils.chat(config.getString("ToggleWorld.world_maintenance_enabled"));
					String worldOpenMessage = Utils.chat(config.getString("ToggleWorld.world_maintenance_disabled"));
					Collection<? extends Player> onlinePlayers = Bukkit.getOnlinePlayers();

					if (Bukkit.getWorld(arg) == null) {
						sender.sendMessage(Utils.chat(config.getString("ToggleWorld.world_provided_error")));
						return false;
					} else {
						if (data.getString("worlds." + arg + ".closed") != null) {
							data.set("worlds." + arg + ".closed", null);
							settings.saveData();
							Bukkit.broadcastMessage(
									worldOpenMessage.replaceAll("<world>", Bukkit.getWorld(arg).getName()));
							onlinePlayers.forEach(
									players -> players.playSound(players.getLocation(), "block.note_block.harp", 2, 1));
						} else {
							data.set("worlds." + arg + ".closed", true);
							settings.saveData();
							for (Player p : Bukkit.getOnlinePlayers()) {
								if (p.getLocation().getWorld().getName().equalsIgnoreCase(arg)) {
									p.teleport(Bukkit.getWorld("Hub").getSpawnLocation());
								}
							}
							Bukkit.broadcastMessage(
									worldClosedMessage.replaceAll("<world>", Bukkit.getWorld(arg).getName()));
							onlinePlayers.forEach(
									players -> players.playSound(players.getLocation(), "block.note_block.harp", 2, 1));
						}
					}
				} else if (args.length < 1) {
					sender.sendMessage(Utils.chat(config.getString("ToggleWorld.not_enough_args")));
				} else if (args.length > 1) {
					sender.sendMessage(Utils.chat(config.getString("ToggleWorld.too_many_args")));
				}
			} else {
				sender.sendMessage(noPermMessage);
			}
		}
		return false;
	}

}
