package mc.rysty.heliospheregui.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import mc.rysty.heliospheregui.HelioSphereGUI;
import mc.rysty.heliospheregui.guis.HubMainMenu;


public class MainMenuCommand implements CommandExecutor {
	
	HelioSphereGUI plugin = HelioSphereGUI.getInstance();
	
	public MainMenuCommand(HelioSphereGUI plugin) {
		plugin.getCommand("mainmenu").setExecutor(this);
	}

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("mainmenu")) {
			Player p = (Player) sender;
			
			HubMainMenu.openServerSelectorMenu(p);
		}
		return false;
	}

}
