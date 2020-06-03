package application;

import java.sql.Connection;
import java.sql.SQLException;

import java.sql.PreparedStatement;

import db.Db;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = Db.getConnection();
			
			st= conn.prepareStatement(
					"UPDATE seller "
					+ "SET BaseSalary = BaseSalary + ? "
					+ "WHERE "
					+ "(DepartmentId = ? )");
			
			st.setDouble(1, 200.0);
			st.setInt(2, 2);
			
			int rowsAffected = st.executeUpdate();
			
			System.out.println("Done!Rows Affected: " + rowsAffected);
					
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			Db.closeConnection();
			Db.closeStatement(st);
		}
	}

}
