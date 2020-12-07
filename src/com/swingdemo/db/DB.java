package com.swingdemo.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {

	public static Connection createConnection() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/swingdb", "root", "1234");

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

}
