package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Atracao;

public class AtracaoDAO extends DAO {
	
	public AtracaoDAO(){
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public boolean insert(Atracao atracao) {
		
		boolean status = false;
		try {
			// String sql = "INSERT INTO atracao (nome,valor) VALUES ('"+atracao.getNome()+"'," + atracao.getValor()+")";
			// PreparedStatement st = conexao.prepareStatement(sql);
			String sql = "INSERT INTO atracao (nome,valor,atracao_imagem,id_empresa) VALUES (?,?,?,?)";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, atracao.getNome());
			st.setFloat(2, atracao.getValor());
			st.setString(3, atracao.getAtracao_imagem());
			st.setInt(4, atracao.getId_empresa());
			st.executeUpdate();
			st.close();
			status = true;
		}catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	public boolean update(Atracao atracao) {
		boolean status = false;
		try {
			String sql = "Update atracao set nome = ?, valor = ?, atracao_imagem = ?, id_empresa = ? where id = ?";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, atracao.getNome());
			st.setFloat(2, atracao.getValor());
			st.setString(3, atracao.getAtracao_imagem());
			st.setInt(4, atracao.getId_empresa());
			st.setInt(5, atracao.getId());
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
			String sql = "DELETE from atracao where id = "+id;
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public List<Atracao> listar() {
		String sql = "SELECT * FROM atracao";
		List<Atracao> retorno = new ArrayList<>();
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();
			while (resultado.next()) {
				Atracao atracao = new Atracao();
				atracao.setId(resultado.getInt("id"));
				atracao.setNome(resultado.getString("nome"));
				atracao.setValor(resultado.getFloat("valor"));
				atracao.setAtracao_imagem(resultado.getString("atracao_imagem"));
				atracao.setId_empresa(resultado.getInt("id_empresa"));
				retorno.add(atracao);
			}
			st.close();
			
		} catch (Exception e) {
			System.out.println("Erro ao listar");
		}
		return retorno;
		
	}
	
	public Atracao buscar(int id) {
		Atracao atracao = new Atracao();
		String sql = "SELECT * FROM atracao where id = "+id;
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();
			
			while (resultado.next()) {
			atracao.setId(resultado.getInt("id"));
			atracao.setNome(resultado.getString("nome"));
			atracao.setValor(resultado.getFloat("valor"));
			atracao.setAtracao_imagem(resultado.getString("atracao_imagem"));
			atracao.setId_empresa(resultado.getInt("id_empresa"));
			}
			return atracao;
			
		} catch (SQLException u) {
			throw new RuntimeException();
		}
	}

}
