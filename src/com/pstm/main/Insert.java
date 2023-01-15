package com.pstm.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pstm.util.JdbcUtil;

public class Insert {

	public static void main(String[] args) {
		
		
		
		Connection connection = null;
		Statement statement = null;
		PreparedStatement ps = null;

		try {
			// connection established
			connection = JdbcUtil.getConnection();
			
			// creating prepared statement
			if(connection!=null) {
			String insertQuery = "Insert into student(id, name, age, city)values(?,?,?,?)";
			 ps = connection.prepareStatement(insertQuery);
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Id");
			int id = sc.nextInt();
			System.out.println("Enter the name");
			String name = sc.next();
			System.out.println("Enter the age");
			int age = sc.nextInt();
			System.out.println("Enter the city");
			String city = sc.next();
			
			//set if ps not = null
			if(ps!=null) {
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, age);
			ps.setString(4, city);

			int row = ps.executeUpdate();
			System.out.println("No of Rows updated::" + row);
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		
		JdbcUtil.cleanUp(connection, statement, null);

		
		
		

	}

}
