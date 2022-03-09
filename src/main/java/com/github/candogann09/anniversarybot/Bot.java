package com.github.candogann09.anniversarybot;


import com.github.candogann09.anniversarybot.Listeners.Listener;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Activity;

import javax.security.auth.login.LoginException;

/*
 * init the bot itself
 * */

public class Bot {


    void run() throws LoginException {
        JDABuilder builder = JDABuilder.createLight("OTUxMTkyNDkxMDQ5MjUwODM2.Yij5Cg.x8ypfvtaX4dPSch5eQU8v-rMFKA")
                //.setEnabledIntents()
                .setStatus(OnlineStatus.DO_NOT_DISTURB)
                .setActivity(Activity.playing("onTest"))
                .addEventListeners(new Listener());

        builder.build();
    }
}
