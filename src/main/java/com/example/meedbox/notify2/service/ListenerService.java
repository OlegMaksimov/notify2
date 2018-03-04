package com.example.meedbox.notify2.service;

import com.example.meedbox.notify2.listener.Subscriber;
import oracle.jdbc.OracleStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ListenerService {

    public static void addListener(Subscriber subscriber) {

       try {
           subscriber.getChangeRegistration().addListener(subscriber);
           try (Statement stmt = subscriber.getConnection().createStatement()) {
               ((OracleStatement) stmt).setDatabaseChangeRegistration(subscriber.getChangeRegistration());
               try (ResultSet rs = stmt.executeQuery(subscriber.getSql())) {

               }
           }
           String[] tableNames = subscriber.getChangeRegistration().getTables();
           for (int i = 0; i < tableNames.length; i++) {
               System.out.println(tableNames[i] + " has been registered.");
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

   }
}
