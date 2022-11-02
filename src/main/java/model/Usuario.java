package model;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Usuario {
	private int id;
	private String email;
	private String login;
	private String nome;
	private String senha;
	private String vendedor;

	
	public Usuario(int id, String email, String login, String nome, String senha, String vendedor) {
		super();
		this.id = id;
		this.email = email;
		this.login = login;
		this.nome = nome;
		this.senha = senha;
		this.vendedor = vendedor;
	}
	public Usuario(String login,String senha) {
		this.login = login;
		this.senha = senha;
	}
	public Usuario () {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
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
	public String getVendedor() {
		return vendedor;
	}
	public void setVendedor(String vendedor) {
		this.vendedor = vendedor;
	}
	
	
}
