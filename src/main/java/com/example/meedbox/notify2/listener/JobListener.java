package com.example.meedbox.notify2.listener;

import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.DatabaseChangeListener;

public class JobListener implements DatabaseChangeListener{
    @Override
    public void onDatabaseChangeNotification(DatabaseChangeEvent databaseChangeEvent) {
        System.out.println("This LOCATIONS Listener");
    }
}
