package service;

import java.util.List;

import dao.LocalDAO;
import model.Local;
import spark.Request;
import spark.Response;

public class LocalService {
	
	private LocalDAO localDAO = new LocalDAO();
	
	private void setReponseHeaders(Response response) {
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
	}
	
	private Local buscarPorId(Request request) {
		int id = Integer.parseInt(request.params(":id"));
		return localDAO.buscar(id);
	}
	public Local get(Request request, Response response) {
		setReponseHeaders(response);
		Local local = buscarPorId(request);

		if (local != null) {
			response.status(200);
			return local;
		} else {
			response.status(404);
			return null;
		}
	}
	
	public List<Local> getAll(Request request, Response response) {
		setReponseHeaders(response);
		return localDAO.listar();
	}
	
	public Local insert(Request request, Response response) {
		setReponseHeaders(response);

		String endereco = request.queryParams("endereco");
		String nome = request.queryParams("nome");
		String status = request.queryParams("status");
		float valor = Float.parseFloat(request.queryParams("valor"));
		
		Local local = new Local(-1, endereco, nome, status, valor);

		if (localDAO.insert(local)) {
			response.status(201);
			return local;
		} else {
			response.status(404);
			return null;
		}
	}
	
	public String delete(Request request, Response response) {
		Local local = buscarPorId(request);
		
		if (local != null) {
			localDAO.delete(local.getId());
			response.status(200);
			return "Local de ID " + local.getId() + " excluído!";	
		}else {
			response.status(404);
			return "Local não encontrado";
		}
	}
	
	
	
	
	
}
	
	
