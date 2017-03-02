package br.com.alavadeiraapi.rest;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import br.com.alavadeiraapi.domain.Auth;
import br.com.alavadeiraapi.domain.Driver;
import br.com.alavadeiraapi.domain.Trajectory;
import br.com.alavadeiraapi.domain.bean.AuthenticateBean;
import br.com.alavadeiraapi.domain.bean.AuthenticationDataBean;
import br.com.alavadeiraapi.domain.bean.UserBean;
import br.com.alavadeiraapi.domain.service.AuthService;
import br.com.alavadeiraapi.domain.service.DriverService;
import br.com.alavadeiraapi.util.ServerReturnStatusException;

@Path("/authenticate")
@Produces(MediaType.APPLICATION_JSON + ";charset=iso-8859-1")
@Consumes(MediaType.APPLICATION_JSON + ";charset=iso-8859-1")
@Component
public class AuthenticateResource {
	@Autowired
	private DriverService driverService;
	@Autowired
	private AuthService authservice;
	
	@POST
	public UserBean post(AuthenticateBean auth) {
		
		String profileType = auth.getProfile_type();
		HashMap<String, String> message = new HashMap<>();
		
		if(!(profileType.equals("driver") || profileType.equals("admin") || profileType.equals("operator"))) {
			message.put("message", "Profile type " + profileType + " is not accepted.");
			throw new ServerReturnStatusException(message, Status.PAYMENT_REQUIRED);
		}
		
		Driver driver = loadDriver(auth.getEmail(), auth.getPassword());
		
		if(driver != null) {
			
			UserBean response = new UserBean();
			
			response.setMessage("Success");
			
			HashMap<String, String> profile = new HashMap<String, String>();
			profile.put("email", driver.getEmail());
			
			AuthenticationDataBean authData = new AuthenticationDataBean();
			
			try {
			    String token = JWT.create()
			        .withIssuer(driver.toString())
			        .sign(Algorithm.HMAC256("secret"));
				authData.setToken(token);
			} catch (JWTCreationException | IllegalArgumentException | UnsupportedEncodingException exception){
			    //Invalid Signing configuration / Couldn't convert Claims.
			}
			
			// Cria ou atualiza o token do motorista
			loadAuth(authData.getToken(), driver.getId());
			
			authData.setProfile(profile);
			
			// Retira da resposta os campos password e email
			driver.setPassword(null);
			driver.setEmail(null);
			
			authData.setDriver(driver);
			
			response.setData(authData);
			
			return response;
		}
		
		message.put("message", "Invalid login or password");
		throw new ServerReturnStatusException(message, Status.UNAUTHORIZED);
	}
	
	public Driver loadDriver(String email, String password) {
		
		Driver driver = driverService.loadDriver(email, password);
		
		if(driver != null) {
			for(Trajectory t : driver.getTrajectories()) {
				t.setDrivers(null);
			}
		}
		
		return driver;
	}
	
	public void loadAuth(String token, Integer id_driver) {
		
		Auth auth = authservice.getAuth(id_driver);
		Date today = new Date();    
		Date tomorrow = new Date(today.getTime() + (1000 * 60 * 60 * 24));
		
		// Caso o motorista não tenha uma autenticação
		if(auth == null) {
			
			auth = new Auth();
			
			auth.setToken(token);
			auth.setId_driver(id_driver);
			
			auth.setExpire_date(today);
			
			authservice.save(auth);
		}
		
		// Atualiza a data de expiração
		auth.setExpire_date(tomorrow);
		auth.setToken(token);
		
		authservice.save(auth);
	}
}
