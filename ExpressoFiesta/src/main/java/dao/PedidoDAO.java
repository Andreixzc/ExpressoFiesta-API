package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Pedido;

public class PedidoDAO extends DAO {
	
	
	public PedidoDAO(){
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	
	public boolean insert(Pedido pedido) {
		
		boolean status = false;
		try {
			String sql = "INSERT INTO pedido (data_pedido,total,local_id,usuario_id) VALUES ('"+pedido.getData_pedido()+"',"+pedido.getTotal()+","+
			pedido.getLocal_id()+","+pedido.getUsuario_id()+")";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		}catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
	public boolean delete(Pedido pedido) {
		boolean status = false;
		
		try {
			String sql = "DELETE from pedido where id = "+pedido.getId();
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
				pedido.setData_pedido(resultado.getDate("data_pedido"));
				pedido.setTotal(resultado.getInt("total"));
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
		String sql = "SELECT * FROM pedido where id = "+id;
		try {
			PreparedStatement st = conexao.prepareStatement(sql);
			ResultSet resultado = st.executeQuery();
			pedido.setId(resultado.getInt("id"));
			pedido.setData_pedido(resultado.getDate("data_pedido"));
			pedido.setTotal(resultado.getInt("total"));
			pedido.setLocal_id(resultado.getInt("local_id"));
			pedido.setUsuario_id(resultado.getInt("usuario_id"));
			return pedido;
			
		} catch (SQLException u) {
			throw new RuntimeException();
		}
	}
	
	
	
}
