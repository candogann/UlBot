package com.github.candogann09.anniversarybot;


import com.github.candogann09.anniversarybot.Commands.Admin.*;
import com.github.candogann09.anniversarybot.Database.DatabaseCore;
import com.github.candogann09.anniversarybot.Database.DatabaseCore.DBType;
import com.github.candogann09.anniversarybot.Listeners.Listener;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

import static com.github.candogann09.anniversarybot.Database.DatabaseActions.initDatabase;

/*
 * initialize the bot itself
 * */

public class Bot {

    // private static final boolean enableDatabase = true; @TODO: add disableDatabase support
    private static final DBType dbType = DBType.SQLite;
    private static DatabaseCore database = null;


    void run() throws LoginException { // Bot boot

        //Build client
        CommandClientBuilder client = new CommandClientBuilder()
                .setOwnerId(Config.get("OWNER_ID"))
                /*.setStatus(Config.getStatus())
                .setOwnerId(String.valueOf(config.getPrimaryOwner()))*/
                .setPrefix(Config.get("PREFIX"))
                .addCommands(
                        new Shutdown(), new Register(),
                        new DeleteDatabase(), new ReadTables(),
                        new ExecuteMethod()
                );

        // init database
        database = new DatabaseCore(dbType); // @TODO : mySQL support (much much later tho)
        initDatabase(); // see Database.InitializeDatabase

        JDABuilder builder;
        // connect JDA
        builder = JDABuilder.createLight(Config.get("TOKEN"))
                //.setEnabledIntents()  @TODO: study intents,
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.playing("onTest"))
                .addEventListeners(new Listener(), client.build());
        builder.build();

    }

    //
    // public JDABuilder getBuilder() {return builder;} // @Might Change: Delete this, if left unused
    public static DatabaseCore getDatabase() {
        return database;
    }

}
