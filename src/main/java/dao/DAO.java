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
		String serverName = "ec2-54-152-28-9.compute-1.amazonaws.com";
		String mydatabase = "dfnili95lf1t7n";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "mnsiezyticwpki";
		String password = "74240fa13d52453f3a07d6494cb26d74eb83fbadcbec169bc199e75d103f4c2f";
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
