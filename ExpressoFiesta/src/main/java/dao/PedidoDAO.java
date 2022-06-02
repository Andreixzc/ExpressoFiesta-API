package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.AlimentoQuantidade;


import model.Atracao;

import model.Pedido;

public class PedidoDAO extends DAO {

	public PedidoDAO() {
		super();
		conectar();
	}

	public void finalize() {
		close();
	}

	public boolean insert(Pedido pedido) {

		boolean status = false;
		try {
			String sql = "INSERT INTO pedido (data_pedido,total,local_id,usuario_id) VALUES ('"
					+ pedido.getData_pedido() + "'," + pedido.getTotal() + "," + pedido.getLocal_id() + ","
					+ pedido.getUsuario_id() + ")";
			
			PreparedStatement st = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.executeUpdate();
            int idPedido = 0;
            ResultSet generatedKeys = st.getGeneratedKeys();
            if (generatedKeys.next()) {
                idPedido = generatedKeys.getInt("id");
            }

			for (Atracao atracao : pedido.getAtracoes()) {
				String sql2 = "INSERT INTO pedido_atracao (pedido_id, atracao_id) VALUES ('" + idPedido + "',"
						+ atracao.getId()  + ")";
				PreparedStatement st2 = conexao.prepareStatement(sql2);
				st2.executeUpdate();
				st2.close();
			}

			for (AlimentoQuantidade alimentoQuantidade : pedido.getAlimentosQuantidade()) {
                String sql3 = "INSERT INTO pedido_alimento (quantidade, alimento_id, pedido_id) VALUES (" + alimentoQuantidade.getQuantidade() + ","
                        + alimentoQuantidade.getAlimento().getId() + "," + idPedido + ")";
                PreparedStatement st3 = conexao.prepareStatement(sql3);
                st3.executeUpdate();
                st3.close();
            }

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
			String sql = "DELETE from pedido where id = " + id;
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}

	public List<Pedido> listar() {
		String sql = "SELECT * FROM pedido";
		List<Pedido> retorno = new ArrayList<>();
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();
			while (resultado.next()) {
				Pedido pedido = new Pedido();
				pedido.setId(resultado.getInt("id"));
				pedido.setData_pedido(resultado.getDate("data_pedido").toLocalDate());
				pedido.setTotal(resultado.getFloat("total"));
				pedido.setLocal_id(resultado.getInt("local_id"));
				pedido.setUsuario_id(resultado.getInt("usuario_id"));
				retorno.add(pedido);
			}
			st.executeUpdate();
			st.close();

		} catch (Exception e) {
			System.out.println("Erro ao listar");
		}
		return retorno;

	}

	public Pedido buscar(int id) {
		Pedido pedido = new Pedido();
		String sql = "SELECT * FROM pedido where id = " + id;
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();
			while (resultado.next()) {
				pedido.setId(resultado.getInt("id"));
				pedido.setData_pedido(resultado.getDate("data_pedido").toLocalDate());
				pedido.setTotal(resultado.getFloat("total"));
				pedido.setLocal_id(resultado.getInt("local_id"));
				pedido.setUsuario_id(resultado.getInt("usuario_id"));
			}
			return pedido;

		} catch (SQLException u) {
			throw new RuntimeException();
		}
	}
}
