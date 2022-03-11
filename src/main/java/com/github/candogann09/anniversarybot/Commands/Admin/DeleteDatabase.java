package com.github.candogann09.anniversarybot.Commands.Admin;

import com.github.candogann09.anniversarybot.AnniversaryBot;
import com.github.candogann09.anniversarybot.Bot;
import com.github.candogann09.anniversarybot.Commands.Categories;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import org.slf4j.Logger;

import static com.github.candogann09.anniversarybot.AnniversaryBot.log;


public class DeleteDatabase extends Command {


    public DeleteDatabase()
    {
        this.name = "deletedatabase";
        this.help = "Deletes database for guild if it exists.";
        this.category = Categories.ADMIN;
        this.botPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.userPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.ownerCommand = true;
        this.guildOnly = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        // TODO: Rewrite this after db review.
        log.info("Deleted Database for guild: " + event.getGuild().getName() + " id of guild is: "
                + event.getGuild().getId());

    }
}
