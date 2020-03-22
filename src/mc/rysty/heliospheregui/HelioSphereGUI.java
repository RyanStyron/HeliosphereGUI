package mc.rysty.heliospheregui;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import mc.rysty.heliospheregui.clickevents.HubMainMenuClickEvent;
import mc.rysty.heliospheregui.clickevents.PlayerInfoClickEvent;
import mc.rysty.heliospheregui.commands.MainMenuCommand;
import mc.rysty.heliospheregui.commands.ToggleWorld;
import mc.rysty.heliospheregui.guis.HubMainMenu;
import mc.rysty.heliospheregui.utils.SettingsManager;

public class HelioSphereGUI extends JavaPlugin {

	public static HelioSphereGUI plugin;

	public static HelioSphereGUI getInstance() {
		return plugin;
	}

	PluginManager pm = Bukkit.getPluginManager();

	public void onEnable() {
		plugin = this;
		saveDefaultConfig();
		SettingsManager.getInstance().setup(this);

		new MainMenuCommand(this);
		new ToggleWorld(this);

		pm.registerEvents(new HubMainMenu(), this);
		pm.registerEvents(new HubMainMenuClickEvent(), this);
		pm.registerEvents(new PlayerInfoClickEvent(), this);

		System.out.println("HS-GUI enabled");
	}

	public void onDisable() {
		System.out.println("HS-GUI disabled");
	}
}
