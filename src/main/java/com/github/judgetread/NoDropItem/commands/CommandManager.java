package main.java.com.github.judgetread.NoDropItem.commands;

import org.bukkit.command.PluginCommand;

import main.java.com.github.judgetread.NoDropItem.NoDropItem;

public class CommandManager {

	private static NoDropItem plugin = NoDropItem.getInstance();
	private static CommandManager instance;

	public CommandManager() {
		registerCommands();
	}
	
	public static CommandManager getInstance() {
		if (instance == null) {
			instance = new CommandManager();
		}
		return instance;
	}

	private static void registerCommands() {
		PluginCommand command = plugin.getCommand("nodropitem");
		command.setExecutor(new MainCommand());
   }

}
