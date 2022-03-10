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

    private static final Logger logger = (Logger) LoggerFactory.getLogger("Anniversary Bot");
    private static final Bot bot = new Bot();
    public static void main(String[] args) throws LoginException {

        bot.run();
    }

    public static Bot getBot() {
        return bot;
    }

    public static Logger getLogger() {
        return logger;
    }
}
