package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Pedido_alimento;

public class Pedido_alimentoDAO extends DAO {
	
	public Pedido_alimentoDAO(){
		super();
		conectar();
	}
	
	public void finalize() {
		close();
	}
	public boolean insert(Pedido_alimento pedido_alimento) {
		
		boolean status = false;
		try {
			String sql = "INSERT INTO pedido_alimento (quantidade,alimento_id,pedido_id) VALUES ("+pedido_alimento.getQuantidade()+","+
		pedido_alimento.getAlimento_id()+","+pedido_alimento.getPedido_id()+")";
			PreparedStatement st = conexao.prepareStatement(sql);
			st.executeUpdate();
			st.close();
			status = true;
		}catch (SQLException u) {
			throw new RuntimeException(u);
		}
		return status;
	}
	
}
