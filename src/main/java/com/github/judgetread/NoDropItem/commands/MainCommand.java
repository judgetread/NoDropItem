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

    private final Config config;

    /**
     * Constructor.
     */
    public MainCommand() {
        this.config = Config.getInstance();
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length >= 2) {

            if (!args[0].equalsIgnoreCase("GIVE")) {
                this.sendMsg(sender, this.config.getSenderUnknowCommand());
                return true;
            }

            if (!sender.hasPermission("nodropitem.give")) {
                this.sendMsg(sender, this.config.getSenderNoPermission());
                return true;
            }

            if (Bukkit.getPlayer(args[1]) == null) {
                this.sendMsg(sender, this.config.getSenderNoPlayerFound());
                return true;
            }

            Player receiver = Bukkit.getPlayer(args[1]);

            if (!receiver.isOnline()) {
                this.sendMsg(sender, this.config.getSenderPlayerNotOnline());
                return true;
            }

            if (receiver.getInventory().firstEmpty() < 0) {
                this.sendMsg(sender, this.config.getSenderInventoryFull());
                return true;
            }

            /* Give item */
            receiver.getInventory().addItem(new NDItem().getSdiItemStack());
            
            this.sendMsg(sender, this.config.getSenderCompleted());
            receiver.sendMessage(StrUtils.convertText(this.config.getReceiverCompleted()));
            return true;
        }

        this.sendMsg(sender, this.config.getSenderInvalidUsage());
        return true;
    }

    /**
     * Send message to user of the command.
     * 
     * @param sender Who ran the command.
     * @param msg  Message to send.
     */
    public void sendMsg(CommandSender sender, String msg) {
        if (sender instanceof Player) {
            sender.sendMessage(StrUtils.convertText(msg));
        } else {
            Bukkit.getServer().getConsoleSender().sendMessage(StrUtils.convertText(msg));
        }
        
    }
}
