package model;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Empresa {
	private int id;
	private String nome_empresa;
	private int id_usuario;
	
	public Empresa(int id, String nome_empresa,int id_usuario) {
		this.id = id;
		this.nome_empresa = nome_empresa;
		this.setId_usuario(id_usuario);
	}
	
	public Empresa() {};
	
	public String getNome_empresa() {
		return nome_empresa;
	}
	public void setNome_empresa(String nome_empresa) {
		this.nome_empresa = nome_empresa;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
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

	public int getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}

}
