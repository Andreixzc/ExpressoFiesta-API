package service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import dao.EmpresaDao;
import model.Empresa;
import spark.Request;
import spark.Response;

public class EmpresaService {

    private EmpresaDao empresaDao = new EmpresaDao();

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

    public Empresa insert(Request request, Response response)
            throws JsonParseException, JsonMappingException, IOException, SQLException {
        setReponseHeaders(response);
        String body = request.body();
        System.out.println("PRINTANDO BODY:"+body);
        ObjectMapper mapper = new ObjectMapper();
        Empresa empresa = mapper.readValue(body, Empresa.class);
        System.out.println("printnado empresa"+empresa.toString());
        if (empresaDao.insert(empresa)) {
			response.status(201);
			return empresa;
		}else {
			response.status(404);
			return null;
		}
    }

    public List<Empresa> getAll(Request request, Response response) {
        setReponseHeaders(response);
        return empresaDao.listar();
    }

    public List<Empresa> getAlimento(Request request, Response response) {
        setReponseHeaders(response);
        return empresaDao.listar();
    }

    public List<Empresa> getAtracao(Request request, Response response) {
        setReponseHeaders(response);
        return empresaDao.listar();
    }

    public List<Empresa> getLocal(Request request, Response response) {
        setReponseHeaders(response);
        return empresaDao.listar();
    }

    private Empresa buscarPorId(Request request) {
        int id = Integer.parseInt(request.params(":id"));
        return empresaDao.buscar(id);
    }

    public Empresa update(Request request, Response response) {
        setReponseHeaders(response);
        Empresa empresa = buscarPorId(request);
        if (empresa != null) {
            empresa.setNome_empresa(request.queryParams("nome_empresa"));
            empresa.setId_usuario(Integer.parseInt(request.queryParams("id_usuario")));
            response.status(200);
            return empresa;
        } else {
            response.status(404);
            return null;
        }

    }

    public Empresa get(Request request, Response response) {
        setReponseHeaders(response);
        Empresa empresa = buscarPorId(request);

        if (empresa != null) {
            response.status(200); // success
            return empresa;
        } else {
            response.status(404); // 404 Not found
            return null;
        }
    }

    public String delete(Request request, Response response) {
        Empresa empresa = buscarPorId(request);

        if (empresa != null) {
            empresaDao.delete(empresa.getId());
            response.status(200);
            return "empresa de ID " + empresa.getId() + " excluido!";
        } else {
            response.status(404);
            return "Erro";
        }
    }



}
