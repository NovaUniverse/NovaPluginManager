package net.zeeraa.novapluginmanager.command.novapluginmanager;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.permissions.PermissionDefault;

import net.zeeraa.novacore.spigot.command.AllowedSenders;
import net.zeeraa.novacore.spigot.command.NovaCommand;
import net.zeeraa.novapluginmanager.NovaPluginManager;
import net.zeeraa.novapluginmanager.command.novapluginmanager.disable.DisableSubCommand;
import net.zeeraa.novapluginmanager.command.novapluginmanager.enable.EnableSubCommand;

public class NovaPluginManagerCommand extends NovaCommand {
	public NovaPluginManagerCommand() {
		super("novapluginmanager", NovaPluginManager.getInstance());

		setPermission("novapluginmanager.command.novapluginmanager");
		setPermissionDefaultValue(PermissionDefault.OP);
		setAllowedSenders(AllowedSenders.ALL);
		setEmptyTabMode(true);
		addHelpSubCommand();
		setDescription("main command for nova plugin manager");

		addSubCommand(new EnableSubCommand());
		addSubCommand(new DisableSubCommand());

		setAliases(NovaCommand.generateAliasList("npm"));
	}

	@Override
	public boolean execute(CommandSender sender, String commandLabel, String[] args) {
		sender.sendMessage(ChatColor.GOLD + "Use " + ChatColor.AQUA + "/novapluginmanager help " + ChatColor.GOLD + "for help");
		return true;
	}
}