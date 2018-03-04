package com.example.meedbox.notify2.listener;

import com.example.meedbox.notify2.DAO.ConnectionJDBC;
import oracle.jdbc.OracleConnection;
import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.DatabaseChangeListener;
import oracle.jdbc.dcn.DatabaseChangeRegistration;

import java.sql.SQLException;
import java.util.Properties;

public class Subscriber implements DatabaseChangeListener {

    String name;
    public static final OracleConnection connection = ConnectionJDBC.getConnection();

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
        Properties properties = new Properties();
        properties.setProperty(OracleConnection.DCN_NOTIFY_ROWIDS, "true");
        properties.setProperty(OracleConnection.DCN_QUERY_CHANGE_NOTIFICATION, "true");
        properties.setProperty(OracleConnection.NTF_TIMEOUT, "50");
        this.properties = properties;
        try {
            this.changeRegistration = connection.registerDatabaseChangeNotification(properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Subscriber(String name, String sql, String timeOut) {
        this.name = name;
        this.sql = sql;
        Properties properties = new Properties();
        properties.setProperty(OracleConnection.DCN_NOTIFY_ROWIDS, "true");
        properties.setProperty(OracleConnection.DCN_QUERY_CHANGE_NOTIFICATION, "true");
        properties.setProperty(OracleConnection.NTF_TIMEOUT, timeOut);
        this.properties = properties;
        try {
            this.changeRegistration = connection.registerDatabaseChangeNotification(properties);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Subscriber(String name, Properties properties) {
        this.name = name;
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
