package br.com.alavadeiraapi.domain.bean;

import java.util.HashMap;

import br.com.alavadeiraapi.domain.Driver;

public class AuthenticationDataBean {

	private String token;
	private HashMap<String, String> profile;
	private Driver driver;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public HashMap<String, String> getProfile() {
		return profile;
	}
	public void setProfile(HashMap<String, String> profile) {
		this.profile = profile;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
}
