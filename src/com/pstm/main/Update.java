package com.pstm.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.pstm.util.JdbcUtil;

public class Update {

	public static void main(String[] args) {
		
		Connection connection = null;
		Statement statement = null;
		PreparedStatement ps = null;

		try {
			// connection established
			
			
			connection = JdbcUtil.getConnection();
			
			// creating prepared statement
			if(connection!=null) {						//  1            2
			String updateQuery = "Update student set city = ? where id = ?";
			 ps = connection.prepareStatement(updateQuery);
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Id");
			int id = sc.nextInt();
			System.out.println("Enter the city");
			String city = sc.next();
			
			//set if ps not = null
			if(ps!=null) {
			ps.setInt(2, id);
			ps.setString(1, city);

			int row = ps.executeUpdate();
			System.out.println("No of Rows updated::" + row);
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		
		//closing the connection
		JdbcUtil.cleanUp(connection, statement, null);

	}

}
