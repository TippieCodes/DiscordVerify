package me.tippiecodes.discordverify;

import me.tippiecodes.discordverify.listeners.DiscordChatMessage;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import org.bukkit.plugin.java.JavaPlugin;

import javax.security.auth.login.LoginException;

public class Main extends JavaPlugin {

    private Main plugin;

    @Override
    public void onLoad() {
        saveDefaultConfig();
    }

    public void main(String[] arguments)
            throws LoginException, InterruptedException
    {
        JDA api = JDABuilder.createDefault(this.getConfig().getString("bot.token"))
                .addEventListeners(new DiscordChatMessage())
                .build().awaitReady();
    }

}
