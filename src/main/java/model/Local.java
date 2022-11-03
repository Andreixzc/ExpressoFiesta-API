package model;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.annotate.JacksonAnnotation;
import org.codehaus.jackson.map.ObjectMapper;

public class Local {
	private int id;
	private String endereco;
	private String nome;
	private String status;
	private Float valor;
	// private String urlImg;
	//sd
	private String local_imagem;
	private int id_empresa;
	
	public int getId_empresa() {
		return id_empresa;
	}
	public void setId_empresa(int id_empresa) {
		this.id_empresa = id_empresa;
	}

	public Local() {
		
	}

	public Local(int id, String endereco, String nome, String status, Float valor,
			String local_imagem, int id_empresa) {
		this.id = id;
		this.endereco = endereco;
		this.nome = nome;
		this.status = status;
		this.valor = valor;
		this.local_imagem = local_imagem;
		this.id_empresa = id_empresa;
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
	// public String getUrlImg() {
	// 	return urlImg;
	// }
	// public void setUrlImg(String urlImg) {
	// 	this.urlImg = urlImg;
	// }
	
	@Override
	public String toString() {
		
		ObjectMapper mapper = new ObjectMapper();
		try {
		  String json = mapper.writeValueAsString(this);
		  return json;
		} catch (JsonProcessingException e) {
		   e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "";
	}
	public String getLocal_imagem() {
		return local_imagem;
	}
	public void setLocal_imagem(String local_imagem) {
		this.local_imagem = local_imagem;
	}
	
}
