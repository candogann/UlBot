package com.github.candogann09.anniversarybot.Database;

import java.sql.ResultSet;
import java.sql.SQLException;

import static com.github.candogann09.anniversarybot.AnniversaryBot.bot;
import static com.github.candogann09.anniversarybot.AnniversaryBot.log;

public class DatabaseActions {


    //
    // first table will server and user id table, where it will take server and user ids,
    // second table will be usernames table, where it will contain usernames and userids on their respective server

    public static void initDatabase() {
        // by default, ever user will be added to database
        bot.getDatabase().executeSQL("CREATE TABLE IF NOT EXISTS ids (serverid varchar(18), userid varchar(18));");
    }

    public static void addIdsTable(String serverid, String userid) {
        bot.getDatabase().executeSQL("INSERT INTO ids (serverid, userid) VALUES("+serverid+", "+ userid+")");
    }

    public static boolean isInTable(ResultSet rs, String column, String key) {
        try {
        while(rs.next()) {
            if(rs.getString(column) ==key ) {
                return true;
            }
        }} catch (SQLException e) {
            log.error("SQLException at isInTable,key: " + key);
        }
        return false;
    }
}
