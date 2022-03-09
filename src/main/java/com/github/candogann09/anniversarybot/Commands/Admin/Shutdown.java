package com.github.candogann09.anniversarybot.Commands.Admin;

import com.github.candogann09.anniversarybot.Commands.Categories;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;

public class Shutdown extends Command {

    public Shutdown()
    {
        this.name = "shutdown";
        this.help = "Turns the bot off.";
        this.category = Categories.ADMIN;
        this.botPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.userPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.ownerCommand = false;
        this.guildOnly = false;
    }
    @Override
    protected void execute(CommandEvent event) {

        event.getTextChannel().sendMessage("Adios! \uD83D\uDC4B").complete();
        event.getJDA().shutdown();
        System.exit(0);

    }
}
