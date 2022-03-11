package com.github.candogann09.anniversarybot.Commands.Admin;

import com.github.candogann09.anniversarybot.AnniversaryBot;
import com.github.candogann09.anniversarybot.Bot;
import com.github.candogann09.anniversarybot.Commands.Categories;
import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;
import net.dv8tion.jda.api.Permission;
import org.slf4j.Logger;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.github.candogann09.anniversarybot.AnniversaryBot.bot;

public class ReadTables extends Command {


    public ReadTables() {
        this.name = "readtables";
        this.help = "Reads tables for guild if not exists.";
        this.category = Categories.ADMIN;
        this.botPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.userPermissions = new Permission[]{Permission.MESSAGE_SEND};
        this.ownerCommand = true;
        this.guildOnly = true;
    }


    @Override
    protected void execute(CommandEvent event) {

        // @TODO: Rewrite this after db review.
        ResultSet rs = null;
        try {
            rs = bot.getDatabase().getConnectionDatabase().getMetaData().getTables(null, null, null, null);

            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        ;
    }
}
