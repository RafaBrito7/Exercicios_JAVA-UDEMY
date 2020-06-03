package application;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import db.Db;
import db.DbException;

public class Program {

	public static void main(String[] args) {

		Connection conn = null;
		Statement st = null;
		
		/*
		 * A transa��o � necess�ria para caso haja uma quebra ou um erro no meio do c�digo, todas as a��es ser�o executadas por completo
		 * ou nenhuma ser� executada (para que n�o haja a��es feitas pela metade)
		 */
		
		try {
			conn = Db.getConnection();
			
			conn.setAutoCommit(false); // As a��es ficaram pendentes de uma confirma��o manual pelo programador o false
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET "
					+ "BaseSalary = 2090 WHERE DepartmentId = 1");
			
			int rows2 = st.executeUpdate("UPDATE seller SET "
					+ "BaseSalary = 3090 WHERE DepartmentId = 2");
			
			conn.commit(); // Aqui estamos confirmando que as opera��es terminam aqui ou seja fim da transa��o
			
			System.out.println("Rows1 = " + rows1);
			System.out.println("Rows2 = " + rows2);
			
		} catch (SQLException e) { // Caso haja uma exce��o no c�digo, o m�todo rollback, far� com que execute novamente as opera��es
			try {
				conn.rollback();
				throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
				
			} catch (SQLException e1) {
				throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
			}
		}
		finally {
			Db.closeStatemente(st);
			Db.closeConnection();
		}
		
	}

}
