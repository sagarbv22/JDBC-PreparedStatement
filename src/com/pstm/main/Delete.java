package com.pstm.main;

import java.sql.*;
import java.util.Scanner;

import com.pstm.util.JdbcUtil;

public class Delete {

	public static void main(String[] args) {

		Connection connection = null;
		Statement statement = null;
		PreparedStatement ps = null;

		try {
			// connection established
			
			
			connection = JdbcUtil.getConnection();
			
			// creating prepared statement
			if(connection!=null) {
			String deleteQuery = "Delete from student where id = ?";
			 ps = connection.prepareStatement(deleteQuery);
			}
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the Id");
			int id = sc.nextInt();
			
			//set if ps not = null
			if(ps!=null) {
			ps.setInt(1, id);

			int row = ps.executeUpdate();
			System.out.println("No of Rows updated::" + row);
			}
		} catch (SQLException s) {
			s.printStackTrace();
		}
		
		JdbcUtil.cleanUp(connection, statement, null);

	}

}
