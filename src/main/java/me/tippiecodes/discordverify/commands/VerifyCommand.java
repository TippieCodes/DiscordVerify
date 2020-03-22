package me.tippiecodes.discordverify.commands;

import com.jagrosh.jdautilities.commons.utils.FinderUtil;
import me.tippiecodes.discordverify.Bot;
import me.tippiecodes.discordverify.Main;
import me.tippiecodes.discordverify.utils.Utils;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.User;
import org.apache.commons.lang.StringUtils;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VerifyCommand implements CommandExecutor {
    private Main plugin;
    private Bot bot;
    public VerifyCommand(Main plugin){
        this.plugin = plugin;
        plugin.getCommand("verify").setExecutor(this);
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command cmd, String label, String[] args) {
        if (!(commandSender instanceof Player)) {
            commandSender.sendMessage(Utils.chat("&cThis command cannot be used in console."));
            return true;
        }
        Player player = (Player) commandSender;

        if (player.hasPermission("discordverify.verify")){
            if (args.length == 0 | args.length > 1) {
                commandSender.sendMessage(Utils.chat("&cWrong usage! Correct usage: &b/verify <discord#tag>"));
                return true;
            }
            Guild guild = bot.getJda().getGuilds().get(0);
            User dUser = StringUtils.isNumeric(args[0]) ? bot.getJda().getUserById(args[0]) : null;
            if (dUser == null) {
                dUser = (User) FinderUtil.findMembers(args[0], guild);
            }
            if (dUser != null) {
                commandSender.sendMessage("User found: " + dUser.getName());
            } else {
                commandSender.sendMessage("User not found.");
            }
            player.sendMessage("hi!");
            return true;
        } else {
            commandSender.sendMessage(Utils.chat("&cYou do not have permission to use this command"));
        }
        return false;
    }
}
