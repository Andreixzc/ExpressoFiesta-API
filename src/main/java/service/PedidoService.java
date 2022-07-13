package service;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import dao.AlimentoDAO;
import dao.AtracaoDAO;
import dao.PedidoDAO;
import model.Alimento;
import model.AlimentoQuantidade;
import model.Atracao;
import model.Pedido;
import spark.Request;
import spark.Response;

public class PedidoService {
	private PedidoDAO pedidoDAO = new PedidoDAO();
	
	 private void setReponseHeaders(Response response) {
			response.header("Content-Type", "application/json");
			response.header("Content-Encoding", "UTF-8");
			response.header("Access-Control-Allow-Credentials", "true");
	        response.header("Access-Control-Allow-Origin", "*");
	        response.header("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE, PATCH");
	        response.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Authorization, "
	                + "Content-Type, Accept, X-CSRF-TOKEN, Cache-Control, DNT, X-CustomHeader, Keep-Alive, "
	                + "User-Agent, If-Modified-Since, Content-Range, Range");
	        response.header("Access-Control-Max-Age", "3600");
	        response.type("application/json");
		}
	
	private Pedido buscarPorId(Request request) {
		int id = Integer.parseInt(request.params(":id"));
		return pedidoDAO.buscar(id);
	}
	
	public Pedido get(Request request, Response response) {
		setReponseHeaders(response);
		Pedido pedido = buscarPorId(request);
		if (pedido != null) {
			response.status(200);
			return pedido;
		}else {
			response.status(404);
			return null;
		}
	}
	
	public List<Pedido> getAll(Request request, Response response) {
		setReponseHeaders(response);
		return pedidoDAO.listar();
	}

	public Pedido insert(Request request,Response response) {
		setReponseHeaders(response);

		// alimentosQuantidade= 1,10,2,16 codigos
		// atracoes=1,2,3,4 codigos
		String data = request.queryParams("data_pedido");
		float total = Float.parseFloat(request.queryParams("total"));
		int local_id = Integer.parseInt(request.queryParams("local_id"));
		int usuario_id = Integer.parseInt(request.queryParams("usuario_id"));
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-d");
		LocalDate dataFinal = LocalDate.parse(data, formatter);
		///////////////////////////////////////////////////////
		String atracoes = request.queryParams("atracoes_id");
		//id do pedido | id atracao
		String alimentos = request.queryParams("alimentos_id");
		//Quantidade alimento | id alimento| id do pedido
		
		String vetAlimentos[] = alimentos.split(",");
		String vetAtracoes[] = atracoes.split(",");
		
		int[] vetAlimentoParser = new int[vetAlimentos.length];
		int[] vetparser = new int[vetAtracoes.length];
		Pedido pedido = new Pedido(-1, dataFinal, total, local_id, usuario_id);
		
		for (int i = 0; i < vetAlimentoParser.length; i++) {
			vetAlimentoParser[i] = Integer.parseInt(vetAlimentos[i]);//id dos alimentos
		}
		int j = 1;
		for (int i = 0; i < vetAlimentoParser.length; i = i+2) {
			
			AlimentoDAO alimentoDAO = new AlimentoDAO();
			Alimento alimento = alimentoDAO.buscar(vetAlimentoParser[i]);//Pega o objeto alimento do id pegado no parametro
			int qnt = vetAlimentoParser[j];//Pega quantidade dos indices impares
			AlimentoQuantidade alimentoQuantidade = new AlimentoQuantidade(alimento, qnt);//instancia o objeto passando pro construtor o objeto e a quantidade
			pedido.getAlimentosQuantidade().add(alimentoQuantidade);//adiciona o alimento instanciado ao arraylist
			j = j + 2;
			//j = quantidade indice impar
			//i = id do alimento indice par
		}
		
		for (int i = 0; i < vetAtracoes.length; i++) {
			vetparser[i] = Integer.parseInt(vetAtracoes[i]);//converte a string do parametro em um array de int referente ao id das atracoes
		}
		
		for (int i = 0; i < vetparser.length; i++) {
			AtracaoDAO atracaoDAO = new AtracaoDAO();
			Atracao atracao = atracaoDAO.buscar(vetparser[i]);
			pedido.getAtracoes().add(atracao);	//Instancia e adiciona as atracoes ao pedido percorrendo o array;
		}
		
		////////////////////////////////////////////////////////////////
		if (pedidoDAO.insert(pedido)) {
			response.status(201);
			return pedido;
		}else {
			response.status(404);
			return null;
		}
	}
	
	public Pedido update(Request request, Response response) {
		setReponseHeaders(response);
		Pedido pedido = buscarPorId(request);
		
		if (pedido != null) {
			String data = request.queryParams("data_pedido");
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/d");
			LocalDate dataFinal = LocalDate.parse(data, formatter);
			pedido.setData_pedido(dataFinal);
			
			pedido.setTotal(Float.parseFloat(request.queryParams("total")));
			pedido.setLocal_id(Integer.parseInt(request.queryParams("local_id")));
			pedido.setUsuario_id(Integer.parseInt(request.queryParams("usuario_id")));
			response.status(200);
			return pedido;
		}else {
			response.status(404);
			return null;
		}
	}
	
	public String delete(Request request, Response response) {
		Pedido pedido = buscarPorId(request);
		
		if (pedido != null) {
			pedidoDAO.delete(pedido.getId());
			response.status(200);
			return "Pedidi de id " + pedido.getId() + " excluido!";
		}else {
			response.status(404);
			return "Pedido nao encontrado";
		}
	}
}
