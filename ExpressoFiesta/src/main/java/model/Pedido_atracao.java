package model;

import java.io.IOException;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Pedido_atracao {
	private int pedido_id;
	private int atracao_id;
	public Pedido_atracao(int pedido_id, int atracao_id) {
		super();
		this.pedido_id = pedido_id;
		this.atracao_id = atracao_id;
	}
	public int getPedido_id() {
		return pedido_id;
	}
	public void setPedido_id(int pedido_id) {
		this.pedido_id = pedido_id;
	}
	public int getAtracao_id() {
		return atracao_id;
	}
	public void setAtracao_id(int atracao_id) {
		this.atracao_id = atracao_id;
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
	
	
}
