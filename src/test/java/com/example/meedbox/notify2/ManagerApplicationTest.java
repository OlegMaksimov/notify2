package com.example.meedbox.notify2;

import com.example.meedbox.notify2.listener.Subscriber;
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
    Path path;

    @Before
    public void setUp() throws Exception {
        managerApplication = new ManagerApplication();
        path = Paths.get("tmp.txt");
    }

    @Test
    public void getChangeRegistration() throws Exception {

    }

    @Test
    public void subscibeNotification() throws Exception {
        Map<String, Subscriber> map = managerApplication.getListSubscribe(path);
        managerApplication.subscibeNotification(map);

    }

    @Test
    public void getListSubscribe() throws Exception {
        Map map = managerApplication.getListSubscribe(path);
        assertNotNull(map);

    }

}