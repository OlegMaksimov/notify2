package com.example.meedbox.notify2;

import com.example.meedbox.notify2.DAO.ConnectionJDBC;
import com.example.meedbox.notify2.listener.Subscriber;
import com.example.meedbox.notify2.service.ListenerService;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.driver.OracleConnection;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.HashMap;
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
            this.connection = new ConnectionJDBC(url, user, pass).getConnection();
        return connection;
    }

    public DatabaseChangeRegistration getChangeRegistration(Properties properties) throws SQLException {
        return connection.registerDatabaseChangeNotification(properties);
    }

    public void subscibeNotification(Map<String, Subscriber> listSubscriber) {
        listSubscriber.forEach((k, v) -> ListenerService.addListener(v));
    }

    public Map getListSubscribe(Path path) {

        Map<String, Subscriber> map = new HashMap<>();

        return map;
    }

}
