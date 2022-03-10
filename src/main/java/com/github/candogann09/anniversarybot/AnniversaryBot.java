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
    public static void main(String[] args) throws LoginException {

        new Bot().run();
    }


    public static Logger getLogger() {
        return logger;
    }
}
