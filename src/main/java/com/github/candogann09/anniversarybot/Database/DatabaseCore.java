package com.github.candogann09.anniversarybot.Database;

import java.io.File;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import static com.github.candogann09.anniversarybot.AnniversaryBot.log;

public class DatabaseCore {

    /*
     * setting up database here
     * */

    public enum DBType {SQLite/*, MySQL*/} // @TODO: in the future, i might implement MYSQL support too, so lets keep this here

    private final String filePathOfDatabase = "aBotDB.db";
    private Connection connectionDatabase = null;


    //@TODO: add config support
    //@TODO: Review and rewrite database

    public DatabaseCore(DBType dbtype) {
        try {
            File sqliteFile = new File(filePathOfDatabase);

            if (!sqliteFile.exists()) {

                log.info("SQLite file \"" + filePathOfDatabase + "\" not found, creating file...");
                boolean create = sqliteFile.createNewFile();
                if (!create) log.error("Could not create SQLite file at " + filePathOfDatabase);

            }

            connectionDatabase = DriverManager.getConnection("jdbc:sqlite:" + filePathOfDatabase);
            log.info("Successfully initialized database connection.");

        }

        catch (SQLException | IOException e) {
            e.getStackTrace();
            log.error("SQL or IO Exception at DatabaseCore.java constructor.");
        }
    }

    public void disconnect() {
        log.info("Logging out from database");
        try {
            connectionDatabase.clearWarnings();
            connectionDatabase.close();
            connectionDatabase = null;
            log.info("Logged out from database");
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("SQL Exception at disconnect() method from DatabaseCore.java");
        }
    }


    public void executeSQL(String sql) { // generic execute command, useful for debugging and fast writing @TODO: rewrite code and evade using this

        try (PreparedStatement ps = connectionDatabase.prepareStatement(sql)) {
            log.info("Executing sql command: " + sql);
            ps.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("SQL Exception at executeSQL() method from DatabaseCore.java");
        }
    }

    public void update(String sql) { // updates data, dont returns anything
        try (PreparedStatement ps = connectionDatabase.prepareStatement(sql)) {
            log.info("Executing sql update command: " + sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("SQL Exception at update() method from DatabaseCore.java");
        }
    }

    public void update(String sql, Object... preparedParameters) { // pP version of update, @TODO: study about pP
        try (PreparedStatement ps = connectionDatabase.prepareStatement(sql)) {
            int id = 1;
            for (Object preparedParameter : preparedParameters) {
                ps.setObject(id, preparedParameter);
                id++;
            }
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            log.error("SQL Exception at update() method from DatabaseCore.java");
        }
    }
    public ResultSet query(String sql, Object... preparedParameters) { // @TODO study this
        try {
            log.info("Executing sql query command: " + sql);
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

    //Database actions, @TODO: Make them a seperate class, test if that fucks things up.

    public  ResultSet getDataFromTable(String table, String column) { //@TODO: rewrite this
        String sql = "SELECT "+ column +" FROM "+ table;
        try {

            ResultSet rs = this.query(sql);

            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            log.error("SQL Exception at createStatementForGetFromTable() method from DatabaseCore.java");

        }

        log.error("Couldn't retrieve data from table. Reason can either be non-existant table or column, returning null.");
        return null;
    }

    // @param: key is what we look for, table is which table we looking that, column is what column we look from table
    public boolean isKeyInTable(String key, String table, String column) {

        ResultSet dataCollection = getDataFromTable(table,column);

        try {

        while(dataCollection.next()) {
            if(dataCollection.getString(column) == key)
            {return true;}

            else
            {return false;}
        }
        } catch (SQLException e) {log.error("SQL Exception at getDataFromKey() from DatabaseCore.java");}

        log.error("Something went wrong in isKeyInTable! May god help you because we don't know what went wrong lol. Returning false.");
        return false;
    }

    public static String[] convertResultSetIntoArray(ResultSet rs) { // typically we only get one column of resultset a time, if it leads to perf issues it will be dealt
        try {
            String[] ix = new String[rs.getMetaData().getColumnDisplaySize(1)];
            System.out.println(ix.length);
        } catch(Exception e) {
            //TODO: exception handling
        }

        return null;// return null for a while cuz reasons
    }

    // @GETTERS
    public String getFilePathOfDatabase() {return filePathOfDatabase;}
    public Connection getConnectionDatabase() {return connectionDatabase;}
    public boolean isConnected() {return connectionDatabase != null;}
}
