package me.tippiecodes.discordverify;

import me.tippiecodes.discordverify.commands.VerifyCommand;
import me.tippiecodes.discordverify.listeners.DiscordChatMessage;
import me.tippiecodes.discordverify.utils.Utils;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import org.bukkit.Bukkit;

import javax.security.auth.login.LoginException;

public class Bot {
    public Main plugin;
    public JDA jda;
    public Bot(Main main){
        this.plugin = main;
        startBot();
    }

    private void startBot()
    {
        try {
            jda = JDABuilder.createDefault(plugin.getConfig().getString("bot.token"))
                    .addEventListeners(new DiscordChatMessage())
                    .setActivity(Activity.streaming(plugin.getConfig().getString("bot.status"), plugin.getConfig().getString("bot.statuswebsite")))
                    .build().awaitReady();
            Bukkit.getServer().getConsoleSender().sendMessage(Utils.chat("&a[DiscordVerify] Successfully logged into discord!"));
        } catch (LoginException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Guild getMainGuild() {
        if (jda == null) return null;
        return jda.getGuilds().get(0);
    }
    public JDA getJda() {
        return jda;
    }
}
