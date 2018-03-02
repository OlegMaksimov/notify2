package com.example.meedbox.notify2.DAO;

import oracle.jdbc.driver.OracleConnection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionJDBC {
    private OracleConnection connection;
    private String url, user, password;

    public ConnectionJDBC() {
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

    public OracleConnection getConnection(String url, String user, String pass) throws SQLException {
        return (OracleConnection) DriverManager.getConnection(url,user, pass);
    }
}
