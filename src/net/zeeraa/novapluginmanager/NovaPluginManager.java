package net.zeeraa.novapluginmanager;

import org.bukkit.plugin.java.JavaPlugin;

import net.zeeraa.novacore.spigot.command.CommandRegistry;
import net.zeeraa.novapluginmanager.command.novapluginmanager.NovaPluginManagerCommand;

public class NovaPluginManager extends JavaPlugin {
	private static NovaPluginManager instance;
	
	public static NovaPluginManager getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		NovaPluginManager.instance = this;
		
		CommandRegistry.registerCommand(new NovaPluginManagerCommand());
	}
}