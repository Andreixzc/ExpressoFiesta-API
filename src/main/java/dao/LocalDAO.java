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
			String sql = "INSERT INTO local (endereco,nome,status,valor,local_imagem,id_empresa) VALUES (?,?,?,?,?,?)";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, local.getEndereco());
			st.setString(2, local.getNome());
			st.setString(3, local.getStatus());
			st.setFloat(4, local.getValor());
			st.setString(5, local.getUrlImg());
			st.setInt(6, local.getId_empresa());
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
			String sql = "UPDATE local set endereco = ?,nome = ?, status = ?,valor = ?,local_imagem = ?,id_empresa = ? where id = ?";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, local.getEndereco());
			st.setString(2, local.getNome());
			st.setString(3, local.getStatus());
			st.setFloat(4, local.getValor());
			st.setString(5, local.getUrlImg());
			st.setInt(6, local.getId_empresa());
			st.setInt(7, local.getId());
			st.executeUpdate();
			st.close();
			status = true;
			
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(int id) {
		boolean status = false;
		
		try {
			String sql = "DELETE from local where id = "+id;
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
				local.setUrlImg(resultado.getString("local_imagem"));
				local.setId_empresa(resultado.getInt("id_empresa"));
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
			while (resultado.next()) {
			local.setId(resultado.getInt("id"));
			local.setEndereco(resultado.getString("endereco"));
			local.setNome(resultado.getString("nome"));
			local.setStatus(resultado.getString("status"));
			local.setValor(resultado.getFloat("valor"));
			local.setUrlImg(resultado.getString("local_imagem"));
			local.setId_empresa(resultado.getInt("id_empresa"));
			}
			return local;
			
		} catch (SQLException u) {
			throw new RuntimeException();
		}
	}
	
	
	


}
