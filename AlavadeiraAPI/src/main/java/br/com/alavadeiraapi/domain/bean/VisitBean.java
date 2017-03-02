package br.com.alavadeiraapi.domain.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class VisitBean {
	private String message;
	private VisitBeanData data;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public VisitBeanData getData() {
		return data;
	}
	public void setData(VisitBeanData data) {
		this.data = data;
	}
}
