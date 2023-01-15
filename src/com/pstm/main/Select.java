package com.pstm.main;

import java.sql.*;
import java.util.Scanner;

import com.pstm.util.JdbcUtil;

public class Select {

	public static void main(String[] args) {

		Connection connection = null;
		PreparedStatement ps = null;
		ResultSet resultSet = null;

		// establish the connection
		connection = JdbcUtil.getConnection();

		try {

			if (connection != null) {
				// prepareStatement
				String selectQuery = "select id,name,age,city from student where id=?";
				ps = connection.prepareStatement(selectQuery);
			}

			if (ps != null) {
				// take the input
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter the id");
				int id = sc.nextInt();

				ps.setInt(1, id);
			}

			// Execute the query
			resultSet = ps.executeQuery();

			// process the resultSet
			if(resultSet!=null) {
				System.out.println("Id\tName\tAge\tCity");
				System.out.println("------------------------------");
				if (resultSet.next()) {
					System.out.println(resultSet.getInt(1) + "\t" + resultSet.getString(2) + "\t" + resultSet.getInt(3)
							+ "\t" + resultSet.getString(4));
				} else
					System.out.println("Record not found");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
