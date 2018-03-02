package com.example.meedbox.notify2.service;

import oracle.jdbc.OracleStatement;
import oracle.jdbc.dcn.DatabaseChangeListener;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.driver.OracleConnection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.example.meedbox.notify2.factory.*;
import java.util.Properties;

public class ListenerService {

   public static void addListener(ListenerDB listener) {

       try {
           changeRegistration.addListener(listener);
           try(Statement stmt = listener.createStatement()) {
               ((OracleStatement) stmt).setDatabaseChangeRegistration(changeRegistration);
               try (ResultSet rs = stmt.executeQuery(sql)) {

               }
           }
           String[] tableNames = changeRegistration.getTables();
           for (int i = 0; i < tableNames.length; i++) {
               System.out.println(tableNames[i] + " has been registered.");
           }
       } catch (SQLException e) {
           e.printStackTrace();
       }

   }
}
