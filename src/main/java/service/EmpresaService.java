package service;

import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import model.Alimento;
import model.Empresa;
import spark.Request;
import spark.Response;

public class EmpresaService {

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
	public Empresa insert(Request request, Response response) throws JsonParseException, JsonMappingException, IOException {
		setReponseHeaders(response);
		String body = request.body();
		ObjectMapper mapper = new ObjectMapper();
		Empresa empresa = mapper.readValue(body, Empresa.class);
		
		return empresa;
	}
	  
	  
	  
	  
	  

}
