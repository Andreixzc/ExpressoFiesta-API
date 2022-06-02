package service;

import java.io.IOException;
import java.util.List;

import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import dao.UsuarioDAO;
import model.Usuario;
import spark.Request;
import spark.Response;

public class UsuarioService {
	private UsuarioDAO usuarioDAO = new UsuarioDAO();
	
	private void setReponseHeaders(Response response) {
		response.header("Content-Type", "application/json");
		response.header("Content-Encoding", "UTF-8");	
	}
	private Usuario buscarPorId(Request request) {
		int id = Integer.parseInt(request.params(":id"));
		return usuarioDAO.buscar(id);
	}
	
	public Usuario get(Request request,Response response) {
		setReponseHeaders(response);
		Usuario usuario = buscarPorId(request);
		if (usuario!= null) {
			response.status(200);
			return usuario;
		}else {
			response.status(404);
			return null;
		}	
	}
	
	public List<Usuario> getAll(Request request,Response response) {
		setReponseHeaders(response);
		return usuarioDAO.listar();
	}
	public Usuario insert(Request request, Response response) throws JsonParseException, JsonMappingException, IOException {
		setReponseHeaders(response);
		String body = request.body();
		ObjectMapper mapper = new ObjectMapper();
		Usuario usuario = mapper.readValue(body, Usuario.class);
		if (usuarioDAO.insert(usuario)) {
			response.status(200);
			return usuario;
		}else {
			response.status(404);
			return null;
		}	
	}
	
	
	
	public Usuario update(Request request, Response response) {
		setReponseHeaders(response);
		Usuario usuario = buscarPorId(request);
		
		if (usuario != null) {
			usuario.setEmail(request.queryParams("email"));
			usuario.setLogin(request.queryParams("login"));
			usuario.setNome(request.queryParams("nome"));
			usuario.setSenha(request.queryParams("senha"));
			usuarioDAO.update(usuario);
			response.status(200);
			return usuario;
		}else {
			response.status(404);
		}	return null;
		
	}
	
	public String delete(Request request,Response response) {
		Usuario usuario = buscarPorId(request);
		
		if (usuario != null) {
			usuarioDAO.delete(usuario.getId());
			response.status(200);
			return "Usuario com id " + usuario.getId() + " excluído!";	
		}else {
			response.status(404);
			return "Usuario não encontrado";
		}
	}
	
	
	
	
	

}
