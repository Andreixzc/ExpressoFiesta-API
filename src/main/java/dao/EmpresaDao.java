package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

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
		System.out.println(sql);
		if (st.execute()) {
			return true;
		}
		return false;
	}
	
}
