package me.tippiecodes.discordverify;

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
        try {
            startBot();
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void startBot()
            throws LoginException, InterruptedException
    {
        JDA api = JDABuilder.createDefault(plugin.getConfig().getString("bot.token"))
                .addEventListeners(new DiscordChatMessage())
                .build().awaitReady();
    }

}
