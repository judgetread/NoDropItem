package main.java.com.github.judgetread.NoDropItem.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import main.java.com.github.judgetread.NoDropItem.config.Config;
import main.java.com.github.judgetread.NoDropItem.items.NDItem;
import main.java.com.github.judgetread.NoDropItem.utils.StrUtils;

public class MainCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

		if (args.length >= 2) {

			switch (args[0].toUpperCase()) {

			case "GIVE":

				if (sender.hasPermission("nodropitem.give")) {
					if (Bukkit.getPlayer(args[1]) != null) {
						Player reciever = Bukkit.getPlayer(args[1]);
						if (reciever.isOnline()) {
							if (reciever.getInventory().firstEmpty() > -1) {
								reciever.getInventory().addItem(NDItem.getInstance().getSdiItemStack());
								sender.sendMessage(StrUtils.convertText(Config.getInstance().getSenderCompleted()));
								reciever.sendMessage(StrUtils.convertText(Config.getInstance().getReceiverCompleted()));
								break;
							} else {
								sender.sendMessage(StrUtils.convertText(Config.getInstance().getSenderInventoryFull()));
								break;
							}
						} else {
							sender.sendMessage(StrUtils.convertText(Config.getInstance().getSenderPlayerNotOnline()));
							break;
						}
					} else {
						sender.sendMessage(StrUtils.convertText(Config.getInstance().getSenderNoPlayerFound()));
						break;
					}
				} else {
					sender.sendMessage(StrUtils.convertText(Config.getInstance().getSenderNoPermission()));
					break;
				}
			default:
				sender.sendMessage(StrUtils.convertText(Config.getInstance().getSenderUnknowCommand()));
				break;
			}
		} else {
			sender.sendMessage(StrUtils.convertText(Config.getInstance().getSenderInvalidUsage()));
		}
		return false;
	}
}
