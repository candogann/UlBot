package com.github.candogann09.anniversarybot.Commands.Admin;

import com.github.candogann09.anniversarybot.AnniversaryBot;
import com.github.candogann09.anniversarybot.Bot;
import com.github.candogann09.anniversarybot.Commands.Categories;
import com.github.candogann09.anniversarybot.Database.DatabaseCore;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;


import static com.github.candogann09.anniversarybot.AnniversaryBot.bot;
import static com.github.candogann09.anniversarybot.Database.DatabaseCore.convertResultSetIntoArray;

public class ExecuteMethod extends Command {


    public ExecuteMethod() {

        this.name = "exem";
        this.help = "This is a dev-only command, it is for testing methods easier without meddle with anything else. DONT RUN unless " +
                "you know exactly what you do.";
        this.category = Categories.ADMIN;
        this.botPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.userPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.ownerCommand = true;
        this.guildOnly = true;
    }

    @Override
    protected void execute(CommandEvent event) {
        // INFO: This is a dev-only command, it is for testing methods easier without meddle with anyting else.

        //Bot.getDatabase().getDataFromTable("ids","userid");
        convertResultSetIntoArray(bot.getDatabase().getDataFromTable("ids", "userid"));


    }
}
