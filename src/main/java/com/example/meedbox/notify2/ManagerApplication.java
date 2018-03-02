package com.example.meedbox.notify2;

import com.example.meedbox.notify2.DAO.ConnectionJDBC;
import com.example.meedbox.notify2.service.ListenerService;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.driver.OracleConnection;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class ManagerApplication {
    private OracleConnection connection;
    private Path path;

    public ManagerApplication() {
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public OracleConnection getConnection(String url, String user, String pass) throws SQLException {
        if (this.connection == null)
            this.connection = new ConnectionJDBC().getConnection(url,user,pass);
        return connection;
    }

    public DatabaseChangeRegistration getChangeRegistration(Properties properties) throws SQLException {
        return connection.registerDatabaseChangeNotification(properties);
    }

    public void subscibeNotification(Map listSubscriber) {
        listSubscriber.forEach((k,v)->ListenerService.addListener());
    }

    public Map getListSubscribe(Path path) {
        return null;
    }

}
