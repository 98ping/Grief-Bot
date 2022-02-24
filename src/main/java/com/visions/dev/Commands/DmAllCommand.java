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
                        m.sendMessage("GRIEFED BY discord.gg/minehut").queue());
            }
        });
    }
}
