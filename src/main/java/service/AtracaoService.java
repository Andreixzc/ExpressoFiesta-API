package service;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import dao.AtracaoDAO;
import model.Atracao;
import spark.Request;
import spark.Response;

public class AtracaoService {
	
	
	private AtracaoDAO atracaoDAO = new AtracaoDAO();

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
	
	public Atracao insert(Request request, Response response) throws JsonParseException, JsonMappingException, IOException {
		setReponseHeaders(response);

//		String nome = request.queryParams("nome");;
//		float valor = Float.parseFloat(request.queryParams("valor"));
//		Atracao atracao = new Atracao(-1, nome,valor);
		String body = request.body();
		ObjectMapper mapper = new ObjectMapper();
		Atracao atracao = mapper.readValue(body, Atracao.class);

		if (atracaoDAO.insert(atracao)) {
			response.status(201);
			return atracao;
		} else {
			response.status(404);
			return null;
		}
	}
	
	public Atracao update(Request request, Response response) throws JsonParseException, JsonMappingException, IOException {
		setReponseHeaders(response);
		Atracao atracao = buscarPorId(request);

		if (atracao != null) {
//			atracao.setNome(request.queryParams("nome"));
//			atracao.setValor(Float.parseFloat(request.queryParams("valor")));
			String body = request.body();
			ObjectMapper mapper = new ObjectMapper();
			Atracao atracao2 = mapper.readValue(body, Atracao.class);
			
			atracaoDAO.update(atracao2);
			response.status(200);
			
			return atracao;
		} else {
			response.status(404);
			return null;
		}
	}
	public String delete(Request request, Response response) {
		setReponseHeaders(response);
		Atracao atracao = buscarPorId(request);

		if (atracao != null) {
			atracaoDAO.delete(atracao.getId());
			response.status(200);
			return "Local com id " + atracao.getId() + " excluido!";
		} else {
			response.status(404);
			return "Local nao encontrado";
		}
	}
	
	
	
	


}
