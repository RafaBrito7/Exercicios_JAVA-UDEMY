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
		 * A transação é necessária para caso haja uma quebra ou um erro no meio do código, todas as ações serão executadas por completo
		 * ou nenhuma será executada (para que não haja ações feitas pela metade)
		 */
		
		try {
			conn = Db.getConnection();
			
			conn.setAutoCommit(false); // As ações ficaram pendentes de uma confirmação manual pelo programador o false
			
			st = conn.createStatement();
			
			int rows1 = st.executeUpdate("UPDATE seller SET "
					+ "BaseSalary = 2090 WHERE DepartmentId = 1");
			
			int rows2 = st.executeUpdate("UPDATE seller SET "
					+ "BaseSalary = 3090 WHERE DepartmentId = 2");
			
			conn.commit(); // Aqui estamos confirmando que as operações terminam aqui ou seja fim da transação
			
			System.out.println("Rows1 = " + rows1);
			System.out.println("Rows2 = " + rows2);
			
		} catch (SQLException e) { // Caso haja uma exceção no código, o método rollback, fará com que execute novamente as operações
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
