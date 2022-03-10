package com.github.candogann09.anniversarybot.Database;

import com.github.candogann09.anniversarybot.AnniversaryBot;
import org.slf4j.Logger;

import java.io.File;
import java.sql.*;

public class DatabaseMain {

    /*
     * setting up database here
     * */

    public enum DBType {SQLite} // @TODO: in the future, i might implement MYSQL support too, so lets keep this here

    private final Logger log = AnniversaryBot.getLogger();
    private final String filePathofDatabase = "aBotDB.db";
    private Connection connectionDatabase = null;


    //@TODO: add config support

    public DatabaseMain(DBType dbtype) {
        try {

            File sqliteFile = new File(filePathofDatabase);
            log.info("SQLite file \"" + filePathofDatabase + "\" not found, creating file...");
            if (!sqliteFile.exists()) {
                boolean create = sqliteFile.createNewFile();
                if (!create) log.error("Could not create SQLite file at " + filePathofDatabase);
            }

            connectionDatabase = DriverManager.getConnection("jdbc:sqlite:" + filePathofDatabase);
            log.info("Successfully initialized database connection.");
        } catch (Exception e) {e.getStackTrace();}


    }

    public void disconnect() {
        try {
            connectionDatabase.clearWarnings();
            connectionDatabase.close();
            connectionDatabase = null;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(String sql) {
        try (PreparedStatement ps = connectionDatabase.prepareStatement(sql)) {
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void update(String sql, Object... preparedParameters) {
        try (PreparedStatement ps = connectionDatabase.prepareStatement(sql)) {
            int id = 1;
            for (Object preparedParameter : preparedParameters) {
                ps.setObject(id, preparedParameter);
                id++;
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ResultSet query(String sql, Object... preparedParameters) {
        try {
            PreparedStatement ps = connectionDatabase.prepareStatement(sql);
            int id = 1;
            for (Object preparedParameter : preparedParameters) {
                ps.setObject(id, preparedParameter);
                id++;
            }
            return ps.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getFilePathofDatabase() {
        return filePathofDatabase;
    }

    public Connection getConnectionDatabase() {
        return connectionDatabase;
    }

    public void setConnectionDatabase(Connection connectionDatabase) {
        this.connectionDatabase = connectionDatabase;
    }

    public boolean isConnected() {
        return connectionDatabase != null;
    }
}
