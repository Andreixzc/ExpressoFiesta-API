package service;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import dao.AlimentoDAO;
import model.Alimento;
import spark.Request;
import spark.Response;

public class AlimentoService {

	private AlimentoDAO alimentoDAO = new AlimentoDAO();

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

	private Alimento buscarPorId(Request request) {
		int id = Integer.parseInt(request.params(":id"));
		return alimentoDAO.buscar(id);
	}

	public Alimento get(Request request, Response response) {
		setReponseHeaders(response);
		Alimento alimento = buscarPorId(request);

		if (alimento != null) {
			response.status(200); // success
			return alimento;
		} else {
			response.status(404); // 404 Not found
			return null;
		}
	}

	public List<Alimento> getAll(Request request, Response response) {
		setReponseHeaders(response);
		return alimentoDAO.listar();
	}

	public Alimento insert(Request request, Response response) throws JsonParseException, JsonMappingException, IOException {
		setReponseHeaders(response);

//		String nome = request.queryParams("nome");
//		int quantidade = Integer.parseInt(request.queryParams("quantidade"));
//		float valor = Float.parseFloat(request.queryParams("valor"));
//		Alimento alimento = new Alimento(-1, nome, quantidade, valor);
		String body = request.body();
		ObjectMapper mapper = new ObjectMapper();
		Alimento alimento = mapper.readValue(body, Alimento.class);

		if (alimentoDAO.insert(alimento)) {
			response.status(201); // 201 Created
			return alimento;
		} else {
			response.status(404); // 404 Not found
			return null;
		}
	}

	public Alimento update(Request request, Response response) throws JsonParseException, JsonMappingException, IOException {
		setReponseHeaders(response);
		Alimento alimento = buscarPorId(request);

		if (alimento != null) {
//			alimento.setNome(request.queryParams("nome"));
//			alimento.setValor(Float.parseFloat(request.queryParams("valor")));
//			alimento.setQuantidade(Integer.parseInt(request.queryParams("quantidade")));
			String body = request.body();
			ObjectMapper mapper = new ObjectMapper();
			Alimento alimento2 = mapper.readValue(body, Alimento.class);
			alimentoDAO.update(alimento2);
			response.status(200); // success
			return alimento;
		} else {
			response.status(404); // 404 Not found
			return null;
		}
	}

	public String delete(Request request, Response response) {
		Alimento alimento = buscarPorId(request);

		if (alimento != null) {
			alimentoDAO.delete(alimento.getId());
			response.status(200); // success
			return "Alimento com id " + alimento.getId() + " excluído!";
		} else {
			response.status(404); // 404 Not found
			return "Alimento não encontrado";
		}
	}
}
