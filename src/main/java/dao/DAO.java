package dao;

import java.sql.*;

public class DAO {
	protected Connection conexao;
	
	public DAO() {
		conexao = null;
	}
	
	public boolean conectar() {
//		String driverName = "org.postgresql.Driver";                    
//		String serverName = "localhost";
//		String mydatabase = "festa";
//		int porta = 5432;
//		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
//		String username = "ti2cc";
//		String password = "ti@cc";
//		boolean status = false;
		
		
		String driverName = "org.postgresql.Driver";                    
		String serverName = "ec2-34-235-198-25.compute-1.amazonaws.com";
		String mydatabase = "d8d32s0qkdea6a";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "ephcdhqxvzjrpp";
		String password = "4cb7bc32b93973b89c4965f49593945c99d351a36d34f76d882e592f8c78e7a6";
		boolean status = false;

		try {
			Class.forName(driverName);
			conexao = DriverManager.getConnection(url, username, password);
			status = (conexao == null);
			System.out.println("Conexão efetuada com o postgres!");
		} catch (ClassNotFoundException e) { 
			System.err.println("Conexão NÃO efetuada com o postgres -- Driver não encontrado -- " + e.getMessage());
		} catch (SQLException e) {
			System.err.println("Conexão NÃO efetuada com o postgres -- " + e.getMessage());
		}

		return status;
	}
	
	public boolean close() {
		boolean status = false;

		try {
			conexao.close();
			status = true;
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}
		return status;
	}
}
