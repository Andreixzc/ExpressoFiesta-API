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
		String serverName = "ec2-52-20-166-21.compute-1.amazonaws.com";
		String mydatabase = "dfbvdl2ol0a25b";
		int porta = 5432;
		String url = "jdbc:postgresql://" + serverName + ":" + porta +"/" + mydatabase;
		String username = "gayjdxqlvajvtf";
		String password = "0532018243af88e2ca250c8e0f0b422af3c9f542af821f76e2a125804861af0d";
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