package br.com.alavadeiraapi.domain.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UserBean {

	private String message;
	private AuthenticationDataBean data;
	
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	public AuthenticationDataBean getData() {
		return data;
	}
	public void setData(AuthenticationDataBean data) {
		this.data = data;
	}
	
}
