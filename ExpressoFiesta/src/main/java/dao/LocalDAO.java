package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Local;

public class LocalDAO extends DAO {
	public LocalDAO(){
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public boolean insert(Local local) {
		
		boolean status = false;
		try {
			String sql = "INSERT INTO local (endereco,nome,status,valor) VALUES ('"+local.getEndereco()
			+"', '"+local.getNome()+"','"+local.getStatus()+"', "
			+local.getValor()+")";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		}catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	
	public boolean update(Local local) {
		boolean status = false;
		try {
			String sql = "UPDATE local set endereco = '"+local.getEndereco()+"',nome = '"+local.getNome()+"', status = '"+local.getStatus()+"',valor = "+local.getValor()+
					" where id = "+local.getId();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
			
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(Local local) {
		boolean status = false;
		
		try {
			String sql = "DELETE from local where id = "+local.getId();
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public List<Local> listar() {
		String sql = "SELECT * FROM local";
		List<Local> retorno = new ArrayList<>();
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();
			while (resultado.next()) {
				Local local = new Local();
				local.setId(resultado.getInt("id"));
				local.setEndereco(resultado.getString("endereco"));
				local.setNome(resultado.getString("nome"));
				local.setStatus(resultado.getString("status"));
				local.setValor(resultado.getFloat("valor"));
				retorno.add(local);
			}
			st.close();
			
		} catch (Exception e) {
			System.out.println("Erro ao listar");
		}
		return retorno;
		
	}
	public Local buscar(int id) {
		Local local = new Local();
		String sql = "SELECT * FROM local where id = "+id;
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();
			local.setId(resultado.getInt("id"));
			local.setEndereco(resultado.getString("endereco"));
			local.setNome(resultado.getString("nome"));
			local.setStatus(resultado.getString("status"));
			local.setValor(resultado.getFloat("valor"));
			return local;
			
		} catch (SQLException u) {
			throw new RuntimeException();
		}
	}
	
	
	


}
