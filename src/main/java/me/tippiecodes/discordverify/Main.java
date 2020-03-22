package me.tippiecodes.discordverify;

import me.tippiecodes.discordverify.commands.VerifyCommand;
import me.tippiecodes.discordverify.listeners.DiscordChatMessage;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public class Main extends JavaPlugin {

    public Main plugin;
    @Override
    public void onLoad() {
        saveDefaultConfig();
        new Bot(this);
        new VerifyCommand(this);
    }


}
