package com.visions.dev.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.entities.User;

import java.util.concurrent.TimeUnit;

public class DmAllCommand extends Command {

    public DmAllCommand() {
        this.name = "dmall";
        this.ownerCommand = true;
        this.guildOnly = false;
    }

    protected void execute(CommandEvent event) {

        event.getGuild().loadMembers(member -> {
            if (event.getGuild().getSelfMember().canInteract(member)) {
                User user = member.getUser();
                user.openPrivateChannel().queue( (m) ->
                        m.sendMessage("discord.gg/MOLES discord.gg/MOLES discord.gg/MOLES discord.gg/MOLES discord.gg/MOLES discord.gg/MOLES").queue());
                try {
                    TimeUnit.MILLISECONDS.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
