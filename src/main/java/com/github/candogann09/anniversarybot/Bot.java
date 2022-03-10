package com.github.candogann09.anniversarybot;


import com.github.candogann09.anniversarybot.Commands.Admin.Shutdown;
import com.github.candogann09.anniversarybot.Database.DatabaseMain;
import com.github.candogann09.anniversarybot.Database.DatabaseMain.DBType;
import com.github.candogann09.anniversarybot.Listeners.Listener;
import com.jagrosh.jdautilities.command.CommandClientBuilder;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

/*
 * init the bot itself
 *
 * @param client : Our client builder, we will set up our client here(caches, ownerid, prefix for commands and commands too)
 * @param builder : our JDA builder, backbone of whole bot. it will connect us to discord
 * */

public class Bot {

    private static final boolean enableDatabase = true;
    private static DBType dbType = DBType.SQLite;
    private static DatabaseMain database = null;

    public static DatabaseMain getDatabase() {
        return database;
    }

    void run() throws LoginException {

        CommandClientBuilder client = new CommandClientBuilder()
                .setOwnerId(Config.get("OWNER_ID"))
                /*.setActivity(Activity.playing(config.getPlaying()))
                .setStatus(Config.getStatus())
                .setEmojis(Const.SUCCESS_E, Const.WARN_E, Const.ERROR_E)
                .setLinkedCacheSize(40)
                .setOwnerId(String.valueOf(config.getPrimaryOwner()))

                .setServerInvite("https://discord.gg/5rw6Tur")
                .setGuildSettingsManager(getGuildSettingsDataManager())
                .setCoOwnerIds(coOwners)
                //.setScheduleExecutor(botScheduler)*/
                .setPrefix(Config.get("PREFIX"))
                .addCommands(new Shutdown());




        JDABuilder builder = JDABuilder.createLight(Config.get("TOKEN"))
                //.setEnabledIntents()
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.playing("onTest"))
                .addEventListeners(new Listener(), client.build());
        builder.build();

    }
}
