package com.example.meedbox.notify2.listener;

import oracle.jdbc.OracleConnection;
import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.DatabaseChangeListener;
import oracle.jdbc.dcn.DatabaseChangeRegistration;

import java.sql.SQLException;
import java.util.Properties;

public class Subscriber implements DatabaseChangeListener {

    String name;
    OracleConnection connection;
    DatabaseChangeRegistration changeRegistration;
    String sql;
    Properties properties;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public OracleConnection getConnection() {
        return connection;
    }

    public void setConnection(OracleConnection connection) {
        this.connection = connection;
    }

    public DatabaseChangeRegistration getChangeRegistration() {
        return changeRegistration;
    }

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Properties getProperties() {
        return properties;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    public Subscriber(String name, String sql) {
        this.name = name;
        this.sql = sql;
        this.properties.setProperty(OracleConnection.DCN_NOTIFY_ROWIDS, "true");
        this.properties.setProperty(OracleConnection.DCN_QUERY_CHANGE_NOTIFICATION, "true");
        try {
            this.changeRegistration = connection.registerDatabaseChangeNotification(properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Subscriber(String name, String sql, String timeOut) {
        this.name = name;
        this.sql = sql;
        this.properties.setProperty(OracleConnection.DCN_NOTIFY_ROWIDS, "true");
        this.properties.setProperty(OracleConnection.DCN_QUERY_CHANGE_NOTIFICATION, "true");
        this.properties.setProperty(OracleConnection.NTF_TIMEOUT, timeOut);
        try {
            this.changeRegistration = connection.registerDatabaseChangeNotification(properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Subscriber(String name, OracleConnection connection, Properties properties) {
        this.name = name;
        this.connection = connection;
        this.properties = properties;
        try {
            this.changeRegistration = connection.registerDatabaseChangeNotification(properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onDatabaseChangeNotification(DatabaseChangeEvent databaseChangeEvent) {
        System.out.println("This is " + name);
    }
}
