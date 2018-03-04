package com.example.meedbox.notify2;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * Created by iMac on 04.03.2018.
 */
public class ManagerApplicationTest {
    ManagerApplication managerApplication;

    @Before
    public void setUp() throws Exception {
        managerApplication = new ManagerApplication();
    }

    @Test
    public void getChangeRegistration() throws Exception {

    }

    @Test
    public void subscibeNotification() throws Exception {

    }

    @Test
    public void getListSubscribe() throws Exception {
        Path path = Paths.get("tmp.txt");
        System.out.println(path.toAbsolutePath());
        Map map = managerApplication.getListSubscribe(path);
        assertNotNull(map);

    }

}