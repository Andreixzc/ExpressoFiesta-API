package app;

import static spark.Spark.*;

import java.sql.Date;
import java.time.LocalDate;

import dao.AlimentoDAO;
import dao.AtracaoDAO;
import dao.LocalDAO;
import dao.PedidoDAO;
import dao.UsuarioDAO;
import model.Alimento;
import model.AlimentoQuantidade;
import model.Atracao;
import model.Local;
import model.Pedido;
import model.Pedido_alimento;
import model.Usuario;
import service.AlimentoService;
import service.AtracaoService;
import service.LocalService;
import service.PedidoService;
import service.ProdutoService;
import service.UsuarioService;
import spark.Request;


public class Aplicacao {
	
	private static AlimentoService alimentoService = new AlimentoService();
	private static AtracaoService atracaoService = new AtracaoService();
	private static LocalService localService = new LocalService();
	private static PedidoService pedidoService = new PedidoService();
	private static UsuarioService usuarioService = new UsuarioService();
	
	
    public static void main(String[] args) {
       port(6789);
///////////////////////////////////////////////////////AlimentoService////////////////////////////////////////
	   get("/alimento/list", (request, response) -> alimentoService.getAll(request, response));

	   get("/alimento/:id", (request, response) -> alimentoService.get(request, response));
	   
	   post("/alimento/insert",(request,response)-> alimentoService.insert(request, response));

	   post("/alimento/update/:id", (request, response) -> alimentoService.update(request, response));

	   delete("/alimento/delete/:id", (request, response) -> alimentoService.delete(request, response));
///////////////////////////////////////////////////////AtracaoService///////////////////////////////////////////////////
	   get("/atracao/list", (request, response) -> atracaoService.getAll(request, response));

	   get("/atracao/:id", (request, response) -> atracaoService.get(request, response));
	   
	   post("/atracao/insert",(request,response)-> atracaoService.insert(request, response));

	   post("/atracao/update/:id", (request, response) -> atracaoService.update(request, response));

	   delete("/atracao/delete/:id", (request, response) -> atracaoService.delete(request, response));
///////////////////////////////////////////////////////LocalService///////////////////////////////////////////////////
	   get("/local/list", (request, response) -> localService.getAll(request, response));

	   get("/local/:id", (request, response) -> localService.get(request, response));
	   
	   post("/local/insert",(request,response)-> localService.insert(request, response));

	   post("/local/update/:id", (request, response) -> localService.update(request, response));

	   delete("/local/delete/:id", (request, response) -> localService.delete(request, response));
///////////////////////////////////////////////////////PedidoService///////////////////////////////////////////////////
	   get("/pedido/list", (request, response) -> pedidoService.getAll(request, response));

	   get("/pedido/:id", (request, response) -> pedidoService.get(request, response));
	   
	   post("/pedido/insert",(request,response)-> pedidoService.insert(request, response));

	   post("/pedido/update/:id", (request, response) -> pedidoService.update(request, response));

	   delete("/pedido/delete/:id", (request, response) -> pedidoService.delete(request, response));
///////////////////////////////////////////////////////UsuarioService///////////////////////////////////////////////////
	   get("/usuario/list", (request, response) -> usuarioService.getAll(request, response));

	   get("/usuario/:id", (request, response) -> usuarioService.get(request, response));
	   
	   post("/usuario/insert",(request,response)-> usuarioService.insert(request, response));

	   post("/usuario/update/:id", (request, response) -> usuarioService.update(request, response));

	   delete("/usuario/delete/:id", (request, response) -> usuarioService.delete(request, response));
    }
}
