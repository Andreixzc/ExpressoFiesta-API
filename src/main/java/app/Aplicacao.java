package app;

import static spark.Spark.*;

import service.AlimentoService;
import service.AtracaoService;
import service.EmpresaService;
import service.LocalService;
import service.PedidoService;
import service.UsuarioService;
import spark.Request;
import spark.Response;


public class Aplicacao {

    private static AlimentoService alimentoService = new AlimentoService();
    private static AtracaoService atracaoService = new AtracaoService();
    private static LocalService localService = new LocalService();
    private static PedidoService pedidoService = new PedidoService();
    private static UsuarioService usuarioService = new UsuarioService();
    private static EmpresaService empresaService = new EmpresaService();

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    public static void main(String[] args) {

        
        port(getHerokuAssignedPort());
///////////////////////////////////////////////////////AlimentoService////////////////////////////////////////

        get("/alimento/list", (request, response) -> alimentoService.getAll(request, response));

        get("/alimento/:id", (request, response) -> alimentoService.get(request, response));

        post("/alimento/insert", (request, response) -> alimentoService.insert(request, response));

        post("/alimento/update/:id", (request, response) -> alimentoService.update(request, response));

        delete("/alimento/delete/:id", (request, response) -> alimentoService.delete(request, response));
///////////////////////////////////////////////////////AtracaoService///////////////////////////////////////////////////
        get("/atracao/list", (request, response) -> atracaoService.getAll(request, response));

        get("/atracao/:id", (request, response) -> atracaoService.get(request, response));

        post("/atracao/insert", (request, response) -> atracaoService.insert(request, response));

        post("/atracao/update/:id", (request, response) -> atracaoService.update(request, response));

        delete("/atracao/delete/:id", (request, response) -> atracaoService.delete(request, response));
///////////////////////////////////////////////////////LocalService///////////////////////////////////////////////////
        get("/local/list", (request, response) -> localService.getAll(request, response));

        get("/local/:id", (request, response) -> localService.get(request, response));

        post("/local/insert", (request, response) -> localService.insert(request, response));

        post("/local/update/:id", (request, response) -> localService.update(request, response));

        delete("/local/delete/:id", (request, response) -> localService.delete(request, response));
///////////////////////////////////////////////////////PedidoService///////////////////////////////////////////////////
        get("/pedido/list", (request, response) -> pedidoService.getAll(request, response));

        get("/pedido/:id", (request, response) -> pedidoService.get(request, response));

        post("/pedido/insert", (request, response) -> pedidoService.insert(request, response));

        post("/pedido/update/:id", (request, response) -> pedidoService.update(request, response));

        delete("/pedido/delete/:id", (request, response) -> pedidoService.delete(request, response));
///////////////////////////////////////////////////////UsuarioService///////////////////////////////////////////////////
        get("/usuario/list", (request, response) -> usuarioService.getAll(request, response));

        get("/usuario/:id", (request, response) -> usuarioService.get(request, response));

        post("/usuario/insert", (request, response) -> usuarioService.insert(request, response));

        post("/usuario/update", (request, response) -> usuarioService.update(request, response));

        delete("/usuario/delete/:id", (request, response) -> usuarioService.delete(request, response));

        post("/usuario/login", (request, response) -> usuarioService.validaLogin(request, response));
/////////////////////////////////////////////////////Empresa///////////////////////////////////////////
        
        get("/empresa/list", (request, response) -> empresaService.getAll(request, response));

        post("/empresa/insert", (request, response) -> empresaService.insert(request, response));

        get("/empresa/:id", (request, response) -> empresaService.get(request, response));

        post("/empresa/update", (request, response) -> empresaService.update(request, response));

        delete("/empresa/delete/:id", (request, response) -> empresaService.delete(request, response));

        get("/empresa/alimentoList/:id", (request, response) -> empresaService.getAlimento(request, response));

        get("/empresa/atracaoList/:id", (request, response) -> empresaService.getAtracao(request, response));

        get("/empresa/localList/:id", (request, response) -> empresaService.getLocal(request, response));

        get("/empresa/listUsuario/:id", (request, response) -> empresaService.getlistUsuario(request, response));



    }
}
