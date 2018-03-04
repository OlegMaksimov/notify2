package com.example.meedbox.notify2.DAO;

import oracle.jdbc.driver.OracleConnection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Locale;

public class ConnectionJDBC {
    private OracleConnection connection;
    private static String url = "jdbc:oracle:thin:@localhost:49161:xe", user = "HR", password = "oracle";

    private ConnectionJDBC() {
    }

    public ConnectionJDBC(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }


    public void setConnection(OracleConnection connection) {
        this.connection = connection;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static OracleConnection getConnection() {
        Locale.setDefault(Locale.ENGLISH);
        try {
            return (OracleConnection) DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}
