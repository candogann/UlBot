package com.github.candogann09.anniversarybot;


/*
 *
 * init bot stuff
 *
 * @param logger : generic logger for this bot
 *
 * */


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class AnniversaryBot {

    public static final Logger log = (Logger) LoggerFactory.getLogger("Anniversary Bot"); // see line 22, we wanna use global logger @TODO: Add logger to all actions
    public static final Bot bot = new Bot(); // this is public so we can take it from everywhere without having to add it to all classes

    public static void main(String[] args) throws LoginException {

        bot.run();
    }

    // #GETTERS
    //public static Bot getBot() {return bot;} // we dont need it anymore
    public static Logger getLogger() {return log;}
}
