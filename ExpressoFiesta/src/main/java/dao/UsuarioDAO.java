package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		String sql = "Update usuario set email = ?, login = ?, nome = ?, senha = ? where id = ?";
		PreparedStatement st = conexao.prepareStatement(sql);
		st.setString(1, usuario.getEmail());
		st.setString(2, usuario.getLogin());
		st.setString(3, usuario.getNome());
		st.setString(4, usuario.getSenha());
		st.setInt(5, usuario.getId());
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
			}
			return usuario;
			
		} catch (SQLException u) {
			throw new RuntimeException();
		}
	}
	
	

	
	
	
	
	
	
	
}
