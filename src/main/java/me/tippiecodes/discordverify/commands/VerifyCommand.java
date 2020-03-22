package me.tippiecodes.discordverify.commands;

import me.tippiecodes.discordverify.Main;
import me.tippiecodes.discordverify.utils.Utils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VerifyCommand implements CommandExecutor {
    private Main plugin;

    public VerifyCommand(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("verify").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(Utils.chat("&cThis command cannot be used in console."));
            return true;
        }
        Player player = (Player) commandSender;

        if (player.hasPermission("discordverify.verify")){

            return true;
        } else {
            commandSender.sendMessage(Utils.chat("&cYou do not have permission to use this command"));
        }
        return false;
    }
}
