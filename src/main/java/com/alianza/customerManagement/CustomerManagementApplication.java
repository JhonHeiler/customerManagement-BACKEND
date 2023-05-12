package com.alianza.customerManagement;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.Statement;

@SpringBootApplication
@Component
public class CustomerManagementApplication {
	@Autowired
	private DataSource dataSource;
	public static void main(String[] args) {
		SpringApplication.run(CustomerManagementApplication.class, args);

	}
		@PostConstruct
		public void initializeDatabase() throws Exception {
			try (Connection conn = dataSource.getConnection();
				 Statement stmt = conn.createStatement()) {
				stmt.executeUpdate("INSERT INTO CLIENT (EMAIL,END_DATE,NAME,PHONE,SHARED_KEY,START_DATE) VALUES ('jhon.heiler@gmail.com','12-05-2023','Jhon Heiler','3234960276','jhonH','11-05-2023')");

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
}





