package service;

import java.util.List;

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
	
	public Usuario insert(Request request, Response response) {
		setReponseHeaders(response);
		String email = request.queryParams("email");
		String login = request.queryParams("login");
		String nome = request.queryParams("nome");
		String senha = request.queryParams("senha");
		Usuario usuario = new Usuario(-1, email, login, nome, senha);
		
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
