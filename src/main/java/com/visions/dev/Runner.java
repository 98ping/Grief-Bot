package com.visions.dev;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import com.visions.dev.Commands.*;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.requests.GatewayIntent;
import net.dv8tion.jda.api.utils.cache.CacheFlag;

import javax.security.auth.login.LoginException;
import java.util.EnumSet;



public class Runner {
    public static void main(String[] args) throws LoginException {

        String token = "Your token";
        EnumSet<GatewayIntent> intents = EnumSet.of(
                GatewayIntent.GUILD_MESSAGES,
                GatewayIntent.GUILD_BANS,
                GatewayIntent.GUILD_MEMBERS,
                GatewayIntent.DIRECT_MESSAGES,
                GatewayIntent.GUILD_PRESENCES
        );



        CommandClientBuilder builder = new CommandClientBuilder();

        builder.setActivity(Activity.watching("https://github.com/Nopock/Grief-Bot/wiki"));

        builder.addCommand(new GriefCommands());
        builder.addCommand(new ClearChannelsCommand());
        builder.addCommand(new RolesCommand());
        builder.addCommand(new RenameAllCommand());
        builder.addCommand(new BanAllCommand());
        builder.addCommand(new DmAllCommand());



        builder.setOwnerId("Your discord id");
        builder.setPrefix(";");



        CommandClient commandClient = builder.build();


        JDA jda = JDABuilder.createLight(token, intents)
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .enableCache(CacheFlag.ONLINE_STATUS)
                .enableCache(CacheFlag.MEMBER_OVERRIDES)
                .enableCache(CacheFlag.CLIENT_STATUS)
                .setActivity(Activity.watching("Discord Servers"))
                .addEventListeners(
                        commandClient
                ).build();
        jda.updateCommands();

    }
}
