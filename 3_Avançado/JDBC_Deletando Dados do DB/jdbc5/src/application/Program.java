package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.Db;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement st = null;
		
		try {
			conn = Db.getConnection();
			
			st = conn.prepareStatement(
					"DELETE FROM seller "
					+ "WHERE "
					+ "Id = ?");
			
			st.setInt(1, 7);
			
			int rows = st.executeUpdate();
			
			System.out.println("DONE! Rows Affected: " + rows);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			Db.closeConnection();
			Db.closeStatemente(st);
		}
	}

}
