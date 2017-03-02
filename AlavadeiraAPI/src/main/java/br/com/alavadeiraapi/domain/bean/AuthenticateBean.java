package br.com.alavadeiraapi.domain.bean;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class AuthenticateBean {
	
	private String email;
	private String password;
	private String profile_type;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfile_type() {
		return profile_type;
	}
	public void setProfile_type(String profile_type) {
		this.profile_type = profile_type;
	}
}
