package app;

import static spark.Spark.*;

import java.sql.Date;

import dao.AlimentoDAO;
import dao.AtracaoDAO;
import dao.LocalDAO;
import dao.PedidoDAO;
import dao.Pedido_alimentoDAO;
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
    	Date sdf = new Date(20);
    	Alimento alimento = new Alimento(15, "chibata", 20, 10);
    	Alimento alimento2 = new Alimento(14, "test", 30, 2);
    	Atracao atracao = new Atracao(6, "DJ", 800);
    	Atracao atracao2 = new Atracao(7, "dancer", 499);
    	Local local = new Local(11, "teste", "padaria", "Disponivel", 300f);
//    	Usuario usuario = new Usuario(1, "teste@teste.com", "teste", "Tester", "$2a$10$.PVIfB07x.SfMYTcToxL0.yxcLWU0GbS2NUO1W1QAvqMm/TsFhVem");
    	Pedido pedido = new Pedido(5, sdf, 300, local.getId(), 1);
    	Pedido_alimento  pedido_alimento = new Pedido_alimento(10, alimento.getId(), pedido.getId());
    	Pedido_alimento pedido_alimento2 = new Pedido_alimento(10,	alimento2.getId(),pedido.getId());
    	////////////////////////////////////////////////////////////////
    	AlimentoDAO alimentoDAO = new AlimentoDAO();
    	AtracaoDAO atracaoDAO = new AtracaoDAO();
    	LocalDAO localDAO = new LocalDAO();
    	PedidoDAO pedidoDAO = new PedidoDAO();
    	Pedido_alimentoDAO pedido_alimentoDAO = new Pedido_alimentoDAO();
    	alimentoDAO.insert(alimento);
    	alimentoDAO.insert(alimento2);
    	atracaoDAO.insert(atracao);
    	atracaoDAO.insert(atracao2);
    	localDAO.insert(local);
    	pedidoDAO.insert(pedido);
    	pedido_alimentoDAO.insert(pedido_alimento);
    	pedido_alimentoDAO.insert(pedido_alimento2);
    	
    }
}