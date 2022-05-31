package model;

import java.sql.Date;

public class Pedido {
	private int id;
	private Date data_pedido;
	private int total;
	private int local_id;
	private int usuario_id;
	public Pedido(int id, Date data_pedido, int total, int local_id, int usuario_id) {
		super();
		this.id = id;
		this.data_pedido = data_pedido;
		this.total = total;
		this.local_id = local_id;
		this.usuario_id = usuario_id;
	}
	public  Pedido() {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData_pedido() {
		return data_pedido;
	}
	public void setData_pedido(Date data_pedido) {
		this.data_pedido = data_pedido;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getLocal_id() {
		return local_id;
	}
	public void setLocal_id(int local_id) {
		this.local_id = local_id;
	}
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", data_pedido=" + data_pedido + ", total=" + total + ", local_id=" + local_id
				+ ", usuario_id=" + usuario_id + "]";
	}
	
	
}
