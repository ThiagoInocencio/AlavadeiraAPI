package br.com.alavadeiraapi.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_customer", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 60)
	private String name;
	@Column(nullable = false, length = 20)
	private String phone;
	@Column(nullable = false, length = 250)
	private String delivery_notes;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getDelivery_notes() {
		return delivery_notes;
	}
	public void setDelivery_notes(String delivery_notes) {
		this.delivery_notes = delivery_notes;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
