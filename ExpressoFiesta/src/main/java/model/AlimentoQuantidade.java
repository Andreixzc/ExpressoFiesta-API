package model;

public class AlimentoQuantidade {

	private Alimento alimento;
	private int quantidade;

	public AlimentoQuantidade(Alimento alimento, int quantidade) {
		this.alimento = alimento;
		this.quantidade = quantidade;
	}

	public Alimento getAlimento() {
		return alimento;
	}

	public void setAlimento(Alimento alimento) {
		this.alimento = alimento;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}
