package service;

import java.util.List;

import dao.AtracaoDAO;
import model.Atracao;
import spark.Request;
import spark.Response;

public class AtracaoService {
	
	
	private AtracaoDAO atracaoDAO = new AtracaoDAO();
	
	private void setReponseHeaders(Response response) {
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");
	}
	
	private Atracao buscarPorId(Request request) {
		int id = Integer.parseInt(request.params(":id"));
		return atracaoDAO.buscar(id);
	}
	
	public Atracao get(Request request, Response response) {
		setReponseHeaders(response);
		Atracao atracao = buscarPorId(request);

		if (atracao != null) {
			response.status(200); // success
			return atracao;
		} else {
			response.status(404); // 404 Not found
			return null;
		}
	}
	
	public List<Atracao> getAll(Request request, Response response) {
		setReponseHeaders(response);
		return atracaoDAO.listar();
	}
	
	public Atracao insert(Request request, Response response) {
		setReponseHeaders(response);

		String nome = request.queryParams("nome");;
		float valor = Float.parseFloat(request.queryParams("valor"));

		Atracao atracao = new Atracao(-1, nome,valor);

		if (atracaoDAO.insert(atracao)) {
			response.status(201);
			return atracao;
		} else {
			response.status(404);
			return null;
		}
	}
	
	public Atracao update(Request request, Response response) {
		setReponseHeaders(response);
		Atracao atracao = buscarPorId(request);

		if (atracao != null) {
			atracao.setNome(request.queryParams("nome"));
			atracao.setValor(Float.parseFloat(request.queryParams("valor")));
			atracaoDAO.update(atracao);
			response.status(200);
			return atracao;
		} else {
			response.status(404);
			return null;
		}
	}
	public String delete(Request request, Response response) {
		Atracao atracao = buscarPorId(request);

		if (atracao != null) {
			atracaoDAO.delete(atracao.getId());
			response.status(200);
			return "Local com id " + atracao.getId() + " excluído!";
		} else {
			response.status(404);
			return "Local não encontrado";
		}
	}
	
	
	
	


}
