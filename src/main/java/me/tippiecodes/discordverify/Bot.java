package me.tippiecodes.discordverify;

import me.tippiecodes.discordverify.commands.VerifyCommand;
import me.tippiecodes.discordverify.listeners.DiscordChatMessage;
import me.tippiecodes.discordverify.utils.Utils;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import javax.security.auth.login.LoginException;

public class Bot extends ListenerAdapter implements Listener {
    public Main plugin;
    public JDA jda;
    public Bot(Main main){
        this.plugin = main;
        startBot();
        jda.addEventListener(this);
        jda.addEventListener(new DiscordChatMessage());
    }

    private void startBot()
    {
        try {
            jda = JDABuilder.createDefault(plugin.getConfig().getString("bot.token"))
                    .setActivity(Activity.streaming(plugin.getConfig().getString("bot.status"), plugin.getConfig().getString("bot.statuswebsite")))
                    .build();
            Bukkit.getServer().getConsoleSender().sendMessage(Utils.chat("&a[DiscordVerify] Successfully logged into discord!"));
        } catch (LoginException e) {
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

    @EventHandler
    public void chatEvent(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        TextChannel text = jda.getTextChannelById("689799839231508488");
        text.sendMessage("icansendmessagesyeey " + message).queue();
    }
}
