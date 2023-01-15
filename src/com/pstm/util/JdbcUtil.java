package com.pstm.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
	public static Connection getConnection() {

		FileInputStream fis = null;
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			// properties for connection
			fis = new FileInputStream("Application.properties");
			Properties properties = new Properties();
			properties.load(fis);

			String url = properties.getProperty("url");
			String userName = properties.getProperty("username");
			String passWord = properties.getProperty("password");
			

			// Get the connection
			connection = DriverManager.getConnection(url, userName, passWord);

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return connection;

	}

	public static void cleanUp(Connection connection, Statement statement, ResultSet resultSet) {

		if (connection != null)
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		if (statement != null)
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		if (resultSet != null)
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}
