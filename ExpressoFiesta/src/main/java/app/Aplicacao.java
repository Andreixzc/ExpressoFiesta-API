package app;

import static spark.Spark.*;

import java.sql.Date;

import dao.AlimentoDAO;
import dao.AtracaoDAO;
import dao.LocalDAO;
import dao.PedidoDAO;
import dao.Pedido_alimentoDAO;
import dao.UsuarioDAO;
import model.Alimento;
import model.Atracao;
import model.Local;
import model.Pedido;
import model.Pedido_alimento;
import model.Usuario;
import service.ProdutoService;


public class Aplicacao {
	
//	private static ProdutoService produtoService = new ProdutoService();
	
	
    public static void main(String[] args) {
//        port(6789);
//        staticFiles.location("/public");
//        
//        post("/produto/insert", (request, response) -> produtoService.insert(request, response));
//
//        get("/produto/:id", (request, response) -> produtoService.get(request, response));
//        
//        get("/produto/list/:orderby", (request, response) -> produtoService.getAll(request, response));
//
//        get("/produto/update/:id", (request, response) -> produtoService.getToUpdate(request, response));
//        
//        post("/produto/update/:id", (request, response) -> produtoService.update(request, response));
//           
//        get("/produto/delete/:id", (request, response) -> produtoService.delete(request, response));
    	////////////////////////////////////////
    	
    	Usuario usuario = new Usuario(3, "fatzim@hotmail", "chibata", "hue", "testesenha");
    	UsuarioDAO  usuarioDAO = new UsuarioDAO();
    	usuarioDAO.insert(usuario);
    	
    }
}