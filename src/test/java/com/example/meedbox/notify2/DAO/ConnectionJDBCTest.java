package com.example.meedbox.notify2.DAO;

import oracle.jdbc.OracleConnection;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * Created by iMac on 04.03.2018.
 */
public class ConnectionJDBCTest {
    private final String URL = "jdbc:oracle:thin:@localhost:49161:xe";
    private final String USER = "HR";
    private final String PASS = "oracle";
    ConnectionJDBC connectionJDBC;

    @Before
    public void init() {
        connectionJDBC = new ConnectionJDBC(URL, USER, PASS);
    }

    @Test
    public void getConnection() throws Exception {

        OracleConnection conn = connectionJDBC.getConnection();
        assertNotNull(conn);

    }

}