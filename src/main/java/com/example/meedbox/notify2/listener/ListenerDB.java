package com.example.meedbox.notify2.listener;

import oracle.jdbc.dcn.DatabaseChangeEvent;
import oracle.jdbc.dcn.DatabaseChangeListener;

public class ListenerDB implements DatabaseChangeListener {

    String NAME = "DEFAILT LISTENER";

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    @Override
    public void onDatabaseChangeNotification(DatabaseChangeEvent databaseChangeEvent) {
        System.out.println("This is " + NAME);
    }
}
