package com.github.candogann09.anniversarybot.Commands.Admin;

import com.github.candogann09.anniversarybot.Bot;
import com.github.candogann09.anniversarybot.Commands.Categories;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;

import static com.github.candogann09.anniversarybot.AnniversaryBot.log;


public class Register extends Command {

    public Register() {
        this.name = "register";
        this.help = "Register database for guild if not exists.";
        this.category = Categories.ADMIN;
        this.botPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.userPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.ownerCommand = true;
        this.guildOnly = true;
    }

    @Override
    protected void execute(CommandEvent event) {

        String id = event.getGuild().getId();
        String uid = event.getAuthor().getId();

        Bot.getDatabase().update("INSERT INTO ids (serverid, userid)\n" +
                "VALUES(" +id +", "+ uid + ");");
        log.info("Created Database for guild: " + event.getGuild().getName() + " id of guild is: " + event.getGuild().getId());
 // @TODO: Rewrite this after database review
    }
}
