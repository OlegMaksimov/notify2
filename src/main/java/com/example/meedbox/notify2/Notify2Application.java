package com.example.meedbox.notify2;

import com.example.meedbox.notify2.DAO.ConnectionJDBC;
import com.example.meedbox.notify2.listener.EmployeesListener;
import com.example.meedbox.notify2.listener.JobListener;
import com.example.meedbox.notify2.service.ListenerService;
import oracle.jdbc.dcn.DatabaseChangeRegistration;
import oracle.jdbc.driver.OracleConnection;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

@SpringBootApplication
public class Notify2Application {

	ConnectionJDBC connection;

		public static void main(String[] args) throws SQLException {
		SpringApplication.run(Notify2Application.class, args);
		ManagerApplication managerApplication = new ManagerApplication();
//		managerApplication.getConnection("jdbc:oracle:thin:@192.168.2.91:49161:xe", "hr", "oracle");
//		Properties dbProperties;
//		String sql;
//		dbProperties = new Properties();
//		dbProperties.setProperty(OracleConnection.DCN_NOTIFY_ROWIDS, "true");
//		dbProperties.setProperty(OracleConnection.DCN_QUERY_CHANGE_NOTIFICATION, "true");
//		dbProperties.setProperty(OracleConnection.NTF_TIMEOUT, "100");
//		DatabaseChangeRegistration changeRegistration = oracleConnection.registerDatabaseChangeNotification(dbProperties);
//		DatabaseChangeRegistration changeRegistration1 = oracleConnection.registerDatabaseChangeNotification(dbProperties);
//				JOB
//		sql = " SELECT CITY FROM LOCATIONS";
		ListenerService.addListener(oracleConnection,changeRegistration,new JobListener(),sql);
//		EMPLOYER
//		sql = " SELECT DEPARTMENT_NAME FROM DEPARTMENTS";
		ListenerService.addListener(oracleConnection,changeRegistration1,new EmployeesListener(),sql);
	}
	public void init(){

	}
}
