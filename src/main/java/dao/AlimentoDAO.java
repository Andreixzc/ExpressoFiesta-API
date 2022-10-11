package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Alimento;

public class AlimentoDAO extends DAO {
	
	public AlimentoDAO(){
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public boolean insert(Alimento alimento) {
		
		boolean status = false;
		try {
			String sql = "INSERT INTO alimento (nome,quantidade,valor,imagem_alimento,id_empresa) VALUES (?,?,?,?,?)";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, alimento.getNome());
			st.setInt(2, alimento.getQuantidade());
			st.setFloat(3, alimento.getValor());
			st.setString(4, alimento.getUrlImg());
			st.setInt(5, alimento.getId_empresa());
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean update(Alimento alimento) {
		boolean status = false;
		try {
			String sql = "UPDATE alimento set nome = ?,quantidade = ?,valor = ?, imagem_alimento = ?, id_empresa = ? where id = ?";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, alimento.getNome());
			st.setInt(2, alimento.getQuantidade());
			st.setFloat(3, alimento.getValor());
			st.setString(4, alimento.getUrlImg());
			st.setInt(5, alimento.getId_empresa());
			st.setInt(6, alimento.getId());
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
			String sql = "DELETE from alimento where id = "+id;
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public List<Alimento> listar() {
		String sql = "SELECT * FROM alimento";
		List<Alimento> retorno = new ArrayList<>();	
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();
			while (resultado.next()) {
				Alimento alimento = new Alimento();
				alimento.setId(resultado.getInt("id"));
				alimento.setNome(resultado.getString("nome"));
				alimento.setQuantidade(resultado.getInt("quantidade"));
				alimento.setValor(resultado.getFloat("valor"));
				alimento.setUrlImg(resultado.getString("imagem_alimento"));
				alimento.setId_empresa(resultado.getInt("id_empresa"));
				retorno.add(alimento);
			}
			st.close();
			
		} catch (Exception e) {
			System.out.println("Erro ao listar");
		}
		return retorno;
		
	}
	
	public Alimento buscar(int id) {
		Alimento alimento = new Alimento();
		String sql = "SELECT * FROM alimento where id = "+id;
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();

			while (resultado.next()) {
				alimento.setId(resultado.getInt("id"));
				alimento.setNome(resultado.getString("nome"));
				alimento.setQuantidade(resultado.getInt("quantidade"));
				alimento.setValor(resultado.getFloat("valor"));
				alimento.setUrlImg(resultado.getString("imagem_alimento"));
				alimento.setId_empresa(resultado.getInt("id_empresa"));
			}
			
			return alimento;
		} catch (SQLException u) {
			throw new RuntimeException();
		}
	}
}
