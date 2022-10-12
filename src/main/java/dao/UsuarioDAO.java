package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.core.Tuple;

import model.Usuario;
import service.Criptografar;

	public class UsuarioDAO extends DAO {
		public UsuarioDAO(){
			super();
			conectar();
		}
		
		public void finalize() {
			close();
		}
	public Usuario validaCredenciais(Usuario usuario) {
		try {
			String sql = "Select * from usuario where login = ? and senha = ?";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, usuario.getLogin());
			st.setString(2, usuario.getSenha());
			ResultSet resultSet = st.executeQuery();
			if (resultSet.next() ) {    
				int id = resultSet.getInt("id");
				return buscar(id);
			} 
			st.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return null;
	}
	
	
	public boolean insert(Usuario usuario) {		
			usuario.setSenha(Criptografar.criptografar(usuario.getSenha()));
			boolean status = false;
			try {
				String sql = "INSERT INTO usuario (email,login,nome,senha) VALUES ('"+usuario.getEmail()
				+"', '"+usuario.getLogin()+"','"+usuario.getNome()+"', '"
				+usuario.getSenha()+"')";
				PreparedStatement st = conexao.prepareStatement(sql);
				st.executeUpdate();
				st.close();
				status = true;
			}catch (SQLException u) {
				throw new RuntimeException(u);
			}
			return status;
		}

	public boolean update(Usuario usuario) {
		boolean status = false;
		try {
			String sql = "Update usuario set email = ?, login = ?, nome = ?, senha = ?,vendedor = ? where id = ?";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, usuario.getEmail());
			st.setString(2, usuario.getLogin());
			st.setString(3, usuario.getNome());
			st.setString(4, usuario.getSenha());
			st.setString(5, usuario.getVendedor());
			st.setInt(6, usuario.getId());
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
			String sql = "DELETE from usuario where id = "+id;
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public List<Usuario> listar() {
		String sql = "SELECT * FROM usuario";
		List<Usuario> retorno = new ArrayList<>();
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();
			while (resultado.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(resultado.getInt("id"));
				usuario.setEmail(resultado.getString("email"));
				usuario.setLogin(resultado.getString("login"));
				usuario.setNome(resultado.getString("nome"));
				usuario.setSenha(resultado.getString("senha"));
				usuario.setVendedor(resultado.getString("vendedor"));
				retorno.add(usuario);
			}
			st.close();
			
		} catch (Exception e) {
			System.out.println("Erro ao listar");
		}
		return retorno;
		
	}
	public Usuario buscar(int id) {
		Usuario usuario = new Usuario();
		String sql = "SELECT * FROM usuario where id = "+id;
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();
			while (resultado.next()) {
			usuario.setId(resultado.getInt("id"));
			usuario.setEmail(resultado.getString("email"));
			usuario.setLogin(resultado.getString("login"));
			usuario.setNome(resultado.getString("nome"));
			usuario.setSenha(resultado.getString("senha"));
			usuario.setVendedor(resultado.getString("vendedor"));
			}
			return usuario;
			
		} catch (SQLException u) {
			throw new RuntimeException();
		}
	}
		
}
