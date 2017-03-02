package br.com.alavadeiraapi.rest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.alavadeiraapi.domain.Auth;
import br.com.alavadeiraapi.domain.Deliverable;
import br.com.alavadeiraapi.domain.Visit;
import br.com.alavadeiraapi.domain.bean.VisitBean;
import br.com.alavadeiraapi.domain.bean.VisitBeanData;
import br.com.alavadeiraapi.domain.service.AuthService;
import br.com.alavadeiraapi.domain.service.VisitService;
import br.com.alavadeiraapi.util.ServerReturnStatusException;

@Path("/visits")
@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
@Component
public class VisitResource {
	@Autowired
	private VisitService visitService;
	@Autowired
	private AuthService authService;
	
	@GET
	@Path("/{driver_id}/{schedule_for}")
	public VisitBean get(@PathParam("driver_id") Integer id_driver, @PathParam("schedule_for") String scheduled_for, @HeaderParam("X-API-TOKEN") String token) {
		
		HashMap<String, String> message = new HashMap<>();
		
		if(isValidToken(token)) 
			return getVisits(id_driver, scheduled_for);
		
		message.put("message", "Missing or invalid access token");
		throw new ServerReturnStatusException(message, Status.UNAUTHORIZED);
		
	}
	
	@GET
	@Path("/{driver_id}")
	public VisitBean get(@PathParam("driver_id") Integer id_driver, @HeaderParam("X-API-TOKEN") String token) {
		
		
		String scheduled_for_today = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		
		HashMap<String, String> message = new HashMap<>();
		
		if(isValidToken(token)) {
			return getVisits(id_driver, scheduled_for_today);
		}
		
		message.put("message", "Missing or invalid access token");
		throw new ServerReturnStatusException(message, Status.UNAUTHORIZED);
		
	}
	
	@GET
	public VisitBean get() {
		
		HashMap<String, String> message = new HashMap<>();
		
		message.put("message", "Invalid parameters");
		throw new ServerReturnStatusException(message, Status.BAD_REQUEST);
		
	}
	
	
	public VisitBean getVisits(Integer id_driver, String scheduled_for) {
		
		// Busca pelas visitas do motorista na data informada
		ArrayList<Visit> visits = (ArrayList<Visit>) visitService.getVisitByIdDriverAndDate(id_driver, scheduled_for);
					
		VisitBean response = new VisitBean();
					
		response.setMessage("Success");
					
		VisitBeanData visitdata = new VisitBeanData();
					
		for(Visit vi : visits) {
			// Remove os campos que não apareceram na resposta
			vi.setSchedule_for(null);
			vi.setDriver(null);
			vi.getAddress().setId(null);
						
			for(Deliverable d : vi.getDeliverables()) {
				d.setVisits(null);
				d.setId(null);
			  }
			}
					
			visitdata.setId_driver(id_driver);
			visitdata.setScheduled_for(scheduled_for);
			visitdata.setVisits(visits);
					
			response.setData(visitdata);
					
			return response;
		
	}
	
	// Verifica se o token existe e ainda não expirou
	public boolean isValidToken(String token) {

		Auth auth = authService.getAuthByToken(token);
		
		if(auth != null && auth.getExpire_date().compareTo(new Date()) > 0) 
			return true;
		else return false;
	}
	
}
