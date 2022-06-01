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
import service.AlimentoService;
import service.ProdutoService;


public class Aplicacao {
	
//	private static ProdutoService produtoService = new ProdutoService();
	private static AlimentoService alimentoService = new AlimentoService();
	
	
    public static void main(String[] args) {
       port(6789);

	   get("/alimento/list", (request, response) -> alimentoService.getAll(request, response));

	   get("/alimento/:id", (request, response) -> alimentoService.get(request, response));
	   
	   post("/alimento/insert",(request,response)-> alimentoService.insert(request, response));

	   post("/alimento/update/:id", (request, response) -> alimentoService.update(request, response));

	   delete("/alimento/delete/:id", (request, response) -> alimentoService.delete(request, response));

// 	   Alimento alimento = new Alimento();
// 	   AlimentoDAO alimentoDAO = new AlimentoDAO();
// 	   System.out.println(alimentoDAO.buscar(4));
	   
	   // http://localhost:6789/alimento/list
	   // http://localhost:6789/alimento/insert?nome=teste&quantidade=10&valor=50
	   // http://localhost:6789/alimento/update/1?nome=teste&quantidade=10&valor=50
	   
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
    	

    	// UsuarioDAO  usuarioDAO = new UsuarioDAO();
    	// Pedido_alimentoDAO pdao = new Pedido_alimentoDAO();
		// Pedido_alimento pa = new Pedido_alimento(1, 1, 1);
		// Pedido_alimento pa2 = new Pedido_alimento(2, 2, 1);
		// pdao.insert(pa);
		// pdao.insert(pa2);
    }
}
