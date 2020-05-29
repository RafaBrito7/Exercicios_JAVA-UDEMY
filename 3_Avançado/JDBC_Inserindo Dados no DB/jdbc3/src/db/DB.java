package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DB {
	
	// Objeto de conex�o com o Banco de Dados do JDBC
	private static Connection conn = null;
	
	// M�todo para Conectar com o banco de dados
	public static Connection getConnection() {
		try {
			if (conn == null) {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url,props);
			}
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		
		return conn;
	}
	
	// M�todo para fechar a conex�o com o Banco de Dados
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	
	// Criar m�todos auxiliares para carregar as informa��es do db.properties
	private static Properties loadProperties() {
		try (FileInputStream fs = new FileInputStream("db.properties")){
			Properties props = new Properties(); 
			props.load(fs);
			return props;
			
		} catch (IOException e) {
			throw new DbException(e.getMessage());
		}
	}
	
	// M�todos Auxiliares para fechamento de Objetos Statement e ResultSet
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

}
