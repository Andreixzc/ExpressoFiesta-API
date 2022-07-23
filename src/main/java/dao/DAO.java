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
		String serverName = "ec2-3-213-228-206.compute-1.amazonaws.com";
		String mydatabase = "dcqh0plipq7ec0";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "jmhvaisapilrzz";
		String password = "00083e90b3cffb1385fc2197a1972772c1437fe0d4b185ed0cc774efc04b5093";
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
