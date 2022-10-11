package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Empresa;

public class EmpresaDao extends DAO {
	public EmpresaDao(){
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public boolean insert(Empresa empresa) throws SQLException {
		
		String sql = "INSERT INTO empresa nome_empresa,id_usuario VALUES (?,?)";
		PreparedStatement st = conexao.prepareStatement(sql);
		st.setString(1, empresa.getNome_empresa());
		st.setInt(2, empresa.getId_usuario());
		return st.execute();
		
	}
	
	public boolean update(Empresa empresa) {
		boolean status = false;
		try {
			String sql = "UPDATE empresa set nome_empresa = '"+empresa.getNome_empresa()+"',id_usuario = '"+empresa.getId_usuario()+
					" where id = "+empresa.getId();
			PreparedStatement st = conexao.prepareStatement(sql);
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
			String sql = "DELETE from empresa where id = "+id;
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public List<Empresa> listar() {
		String sql = "SELECT * FROM empresa";
		List<Empresa> retorno = new ArrayList<>();
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();
			while (resultado.next()) {
				Empresa empresa = new Empresa();
				empresa.setId(resultado.getInt("id"));
				empresa.setNome_empresa(resultado.getString("nome_empresa"));
				empresa.setId_usuario(resultado.getInt("id_usuario"));
				retorno.add(empresa);
			}
			st.close();
			
		} catch (Exception e) {
			System.out.println("Erro ao listar");
		}
		return retorno;
		
	}
	public Empresa buscar(int id) {
		Empresa empresa = new Empresa();
		String sql = "SELECT * FROM empresa where id = "+id;
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();
			while (resultado.next()) {
			empresa.setId(resultado.getInt("id"));
			empresa.setNome_empresa(resultado.getString("nome_empresa"));
			empresa.setId_usuario(resultado.getInt("id_usuario"));
			}
			return empresa;
			
		} catch (SQLException u) {
			throw new RuntimeException();
		}
	}
	
}
