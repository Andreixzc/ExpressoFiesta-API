package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Pedido {
	private int id;
	private LocalDate data_pedido;
	private float total;
	private int local_id;
	private int usuario_id;
	private List<Atracao> atracoes = new ArrayList<>(); // passar somente os ids
	private List<AlimentoQuantidade> alimentosQuantidade = new ArrayList<>();  // passar somente os ids
	
	public Pedido(int id, LocalDate data_pedido, float total, int local_id, int usuario_id) {
		this.id = id;
		this.data_pedido = data_pedido;
		this.total = total;
		this.local_id = local_id;
		this.usuario_id = usuario_id;
	}
	public List<AlimentoQuantidade> getAlimentosQuantidade() {
		return alimentosQuantidade;
	}
	public void setAlimentosQuantidade(List<AlimentoQuantidade> alimentosQuantidade) {
		this.alimentosQuantidade = alimentosQuantidade;
	}
	public Pedido() {
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getData_pedido() {
		return data_pedido;
	}
	public void setData_pedido(LocalDate date) {
		this.data_pedido = date;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public int getLocal_id() {
		return local_id;
	}
	public void setLocal_id(int local_id) {
		this.local_id = local_id;
	}
	public int getUsuario_id() {
		return usuario_id;
	}
	public void setUsuario_id(int usuario_id) {
		this.usuario_id = usuario_id;
	}
    public List<Atracao> getAtracoes() {
        return atracoes;
    }
    public void setAtracoes(List<Atracao> atracoes) {
        this.atracoes = atracoes;
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
