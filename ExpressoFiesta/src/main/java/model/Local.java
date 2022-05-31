package model;

public class Local {
	private int id;
	private String endereco;
	private String nome;
	private String status;
	private Float valor;
	
	public Local(int id, String endereco, String nome, String status, Float valor) {
		this.id = id;
		this.endereco = endereco;
		this.nome = nome;
		this.status = status;
		this.valor = valor;
	}
	public Local() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getValor() {
		return valor;
	}

	public void setValor(Float valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		return "Local [id=" + id + ", endereco=" + endereco + ", nome=" + nome + ", status=" + status + ", valor="
				+ valor + "]";
	}
	
	
}
