package model;

public class Atracao {
	private int id;
	private String nome;
	private float valor;
	
	
	public Atracao(int id, String nome, float valor) {
		this.id = id;
		this.nome = nome;
		this.valor = valor;
	}
	
	public Atracao() {
		this.id = -1;
		this.nome = "";
		this.valor = -1;
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
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	@Override
	public String toString() {
		return "Atracao [id=" + id + ", nome=" + nome + ", valor=" + valor + "]";
	}
	
}
