package model;

public class Pedido_alimento {
	private int quantidade;
	private int alimento_id;
	private int pedido_id;
	public Pedido_alimento(int quantidade, int alimento_id, int pedido_id) {
		super();
		this.quantidade = quantidade;
		this.alimento_id = alimento_id;
		this.pedido_id = pedido_id;
	}
	public  Pedido_alimento() {
		
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public int getAlimento_id() {
		return alimento_id;
	}
	public void setAlimento_id(int alimento_id) {
		this.alimento_id = alimento_id;
	}
	public int getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}
	@Override
	public String toString() {
		return "Pedido_alimento [quantidade=" + quantidade + ", alimento_id=" + alimento_id + ", pedido_id=" + pedido_id
				+ "]";
	}
	
	
}
