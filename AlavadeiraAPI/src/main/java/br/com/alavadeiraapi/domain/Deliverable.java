package br.com.alavadeiraapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "deliverable", uniqueConstraints = {
        @UniqueConstraint(columnNames = "barcode")})
public class Deliverable implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_deliverable", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 50)
	private String barcode;
	@Column(nullable = false, length = 30)
	private String type;
	@ManyToMany( mappedBy = "deliverables")
	private List<Visit> visits = new ArrayList<Visit>(0);
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Visit> getVisits() {
		return visits;
	}
	public void setVisits(List<Visit> visits) {
		this.visits = visits;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
