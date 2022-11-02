package service;

import java.io.IOException;
import java.util.Iterator;
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
		response.header("Access-Control-Allow-Credentials", "true");
        response.header("Access-Control-Allow-Origin", "*");
        response.header("Access-Control-Allow-Methods", "POST, PUT, GET, OPTIONS, DELETE, PATCH");
        response.header("Access-Control-Allow-Headers", "Origin, X-Requested-With, Authorization, "
                + "Content-Type, Accept, X-CSRF-TOKEN, Cache-Control, DNT, X-CustomHeader, Keep-Alive, "
                + "User-Agent, If-Modified-Since, Content-Range, Range");
        response.header("Access-Control-Max-Age", "3600");
        response.type("application/json");
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
	public Usuario validaLogin(Request request, Response response) throws JsonParseException, JsonMappingException, IOException {
		setReponseHeaders(response);
		String body = request.body();
		ObjectMapper mapper = new ObjectMapper();
		Usuario usuario = mapper.readValue(body, Usuario.class);
		usuario.setSenha(Criptografar.criptografar(usuario.getSenha()));
		Usuario res = usuarioDAO.validaCredenciais(usuario);
		if (res!=null) {
			response.status(200);
			return res;
			
		}else {
			response.status(400);
			return new Usuario();
		}
	}
	public Usuario insert(Request request, Response response) throws JsonParseException, JsonMappingException, IOException {
		setReponseHeaders(response);
		String body = request.body();
		ObjectMapper mapper = new ObjectMapper();
		Usuario usuario = mapper.readValue(body, Usuario.class);
		if (usuarioDAO.insert(usuario)) {
			response.status(201);
			System.out.println(usuario.toString());
			return usuario;
		}else {
			response.status(404);
			return null;
		}	
	}

	public Usuario update(Request request, Response response) throws JsonParseException, JsonMappingException, IOException {
		setReponseHeaders(response);
		String body = request.body();
		System.out.print(body);
		ObjectMapper mapper = new ObjectMapper();
		Usuario usuario = mapper.readValue(body, Usuario.class);
		System.out.print(usuario);
		if (usuarioDAO.update(usuario)) {
			response.status(200);
			return usuario;
		} else {
			response.status(404);
			return null;
		}
	}

	public String delete(Request request,Response response) {
		Usuario usuario = buscarPorId(request);
		
		if (usuario != null) {
			usuarioDAO.delete(usuario.getId());
			response.status(200);
			return "Usuario com id " + usuario.getId() + " excluido!";
		}else {
			response.status(404);
			return "Usuario nao encontrado";
		}
	}

}
