package model;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Alimento {
	private int id;
	private String nome;
	private int quantidade;
	private float valor;
	// private String urlImg;
	private String imagem_alimento;
	public String getImagem_alimento() {
		return imagem_alimento;
	}
	public void setImagem_alimento(String imagem_alimento) {
		this.imagem_alimento = imagem_alimento;
	}

	private int id_empresa;
	
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
	// public String getUrlImg() {
	// 	return urlImg;
	// }
	// public void setUrlImg(String urlImg) {
	// 	this.urlImg = urlImg;
	// }
	public int getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}
	
	@Override
	public String toString() {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
		  String json = mapper.writeValueAsString(this);
		  System.out.println(json);
		  return json;
		} catch (JsonProcessingException e) {
		   e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}

	
	
	

}
