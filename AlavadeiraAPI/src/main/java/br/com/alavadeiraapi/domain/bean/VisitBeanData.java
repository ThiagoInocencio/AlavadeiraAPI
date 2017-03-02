package br.com.alavadeiraapi.domain.bean;

import java.util.ArrayList;

import javax.xml.bind.annotation.XmlRootElement;

import br.com.alavadeiraapi.domain.Visit;

@XmlRootElement
public class VisitBeanData {
	private Integer id_driver;
	private String scheduled_for;
	private ArrayList<Visit> visits;
	
	public Integer getId_driver() {
		return id_driver;
	}
	public void setId_driver(Integer id_driver) {
		this.id_driver = id_driver;
	}
	public String getScheduled_for() {
		return scheduled_for;
	}
	public void setScheduled_for(String scheduled_for) {
		this.scheduled_for = scheduled_for;
	}
	public ArrayList<Visit> getVisits() {
		return visits;
	}
	public void setVisits(ArrayList<Visit> visits) {
		this.visits = visits;
	}
}
