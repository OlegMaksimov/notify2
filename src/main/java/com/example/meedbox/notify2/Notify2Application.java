package com.example.meedbox.notify2;

import com.example.meedbox.notify2.DAO.ConnectionJDBC;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.nio.file.Paths;
import java.sql.SQLException;

//import com.example.meedbox.notify2.listener.EmployeesListener;
//import com.example.meedbox.notify2.listener.EmployeesListener;

@SpringBootApplication
public class Notify2Application {

	ConnectionJDBC connection;

		public static void main(String[] args) throws SQLException {
		SpringApplication.run(Notify2Application.class, args);
		ManagerApplication managerApplication = new ManagerApplication();
            managerApplication.subscibeNotification(managerApplication.getListSubscribe(Paths.get("tmp.txt")));

	}
	public void init(){

	}
}
