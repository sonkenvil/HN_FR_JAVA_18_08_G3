package com.fsoft.project.db;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class DbHelper {
	private static Connection connection;
	private static String DRIVER;
	private static String USER;
	private static String PASSWORD;
	private static String URL;

	public static Connection getConnection() {
		configDatabase();
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void configDatabase() {
		Properties properties = new Properties();
		try {
			properties.load(DbHelper.class.getResourceAsStream("/dbconfig.properties"));
			DRIVER = properties.getProperty("driver");
			USER = properties.getProperty("username");
			PASSWORD = properties.getProperty("password");
			URL = properties.getProperty("url");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
