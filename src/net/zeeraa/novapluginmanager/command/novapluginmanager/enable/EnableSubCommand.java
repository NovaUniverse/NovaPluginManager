package net.zeeraa.novapluginmanager.command.novapluginmanager.enable;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionDefault;
import org.bukkit.plugin.Plugin;

import net.zeeraa.novacore.spigot.command.AllowedSenders;
import net.zeeraa.novacore.spigot.command.NovaSubCommand;

public class EnableSubCommand extends NovaSubCommand {

	public EnableSubCommand() {
		super("enable");

		setPermission("novapluginmanager.command.novapluginmanager.enable");
		setPermissionDefaultValue(PermissionDefault.OP);
		setAllowedSenders(AllowedSenders.ALL);
		setFilterAutocomplete(true);
		addHelpSubCommand();
		setDescription("enable a plugin");
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		if (args.length == 0) {
			sender.sendMessage(ChatColor.RED + "Please provide a plugin to enable");
		} else {
			Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin(args[0]);

			if (plugin == null) {
				sender.sendMessage(ChatColor.RED + "Could not find a plugin named " + args[0]);
			} else {
				if (plugin.isEnabled()) {
					sender.sendMessage(ChatColor.RED + "That plugin is already enabled");
				} else {
					Bukkit.getServer().getPluginManager().enablePlugin(plugin);
					sender.sendMessage(ChatColor.GREEN + plugin.getName() + " enabled");
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public List<String> tabComplete(CommandSender sender, String alias, String[] args) throws IllegalArgumentException {
		List<String> result = new ArrayList<String>();

		for (Plugin plugin : Bukkit.getServer().getPluginManager().getPlugins()) {
			if (!plugin.isEnabled()) {
				result.add(plugin.getName());
			}
		}

		return result;
	}
}