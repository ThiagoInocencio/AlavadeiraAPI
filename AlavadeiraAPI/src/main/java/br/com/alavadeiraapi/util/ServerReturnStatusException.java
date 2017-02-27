package br.com.alavadeiraapi.util;

import java.util.HashMap;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response.Status;

import com.google.gson.Gson;

import javax.ws.rs.core.Response;

public class ServerReturnStatusException extends WebApplicationException {
	
	private static final long serialVersionUID = 1L;

    /**
     * Create a HTTP 401 (Unauthorized) exception.
     * @param message the Map<String, String> that is the Json Object of the 401 response.
     */
    public ServerReturnStatusException(HashMap<String, String> message, Status status) {
    	
        super(Response.status(status).entity( new Gson().toJson(message)).type("application/json").build());
        		
    }
    
    

}
