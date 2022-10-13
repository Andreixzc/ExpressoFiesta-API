package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Alimento;
import model.Atracao;
import model.Empresa;
import model.Local;

public class EmpresaDao extends DAO {
	public EmpresaDao() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}

	public boolean insert(Empresa empresa) throws SQLException {
		boolean status = false;

		try {
			String sql = "INSERT INTO empresa (nome_empresa,id_usuario) VALUES (?,?)";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.setString(1, empresa.getNome_empresa());
			st.setInt(2, empresa.getId_usuario());
			System.out.println(st);
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;

	}

	public boolean update(Empresa empresa) {
		boolean status = false;
		try {
			String sql = "UPDATE empresa set nome_empresa = '" + empresa.getNome_empresa()
					+ "',id_usuario = '" + empresa.getId_usuario() + " where id = "
					+ empresa.getId();
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
			String sql = "DELETE from empresa where id = " + id;
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


	public List<Alimento> listarAlimento(int id) {
		String sql = "SELECT * FROM alimento where id_empresa = " + id;
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

	public List<Atracao> listarAtracao(int id) {
		String sql = "SELECT * FROM atracao where id_empresa = " + id;
		List<Atracao> retorno = new ArrayList<>();
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();
			while (resultado.next()) {
				Atracao atracao = new Atracao();
				atracao.setId(resultado.getInt("id"));
				atracao.setNome(resultado.getString("nome"));
				atracao.setValor(resultado.getFloat("valor"));
				atracao.setUrlImg(resultado.getString("atracao_imagem"));
				atracao.setId_empresa(resultado.getInt("id_empresa"));
				retorno.add(atracao);
			}
			st.close();

		} catch (Exception e) {
			System.out.println("Erro ao listar");
		}
		return retorno;
	}

	public List<Local> listarLocal(int id) {
		String sql = "SELECT * FROM local where id_empresa = " + id;
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



	public Empresa buscar(int id) {
		Empresa empresa = new Empresa();
		String sql = "SELECT * FROM empresa where id = " + id;
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
