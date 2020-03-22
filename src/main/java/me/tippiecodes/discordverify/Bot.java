package me.tippiecodes.discordverify;

import me.tippiecodes.discordverify.listeners.DiscordChatMessage;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Bot {
    public Main plugin;
    public JDA jda;
    public void bot(Main main){
        this.plugin = main;
        startBot();
    }

    private void startBot()
    {
        try {
            jda = JDABuilder.createDefault(plugin.getConfig().getString("bot.token"))
                    .addEventListeners(new DiscordChatMessage())
                    .build().awaitReady();
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }

}
