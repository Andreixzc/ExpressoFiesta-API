package model;

public class Alimento {
	private int id;
	private String nome;
	private int quantidade;
	private float valor;
	
	public Alimento() {
		this.id = 0;
		this.nome = "";
		this.quantidade = 0;
		this.valor = 0;
	}
	public Alimento(int id, String nome, int quantidade, float valor) {
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.valor = valor;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Alimento [id=" + id + ", nome=" + nome + ", quantidade=" + quantidade + ", valor=" + valor + "]";
	}
	
	
	

}
