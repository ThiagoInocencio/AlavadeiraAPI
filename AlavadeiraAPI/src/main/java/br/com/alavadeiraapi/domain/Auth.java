package br.com.alavadeiraapi.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "auth", uniqueConstraints = {
        @UniqueConstraint(columnNames = "id_driver")})
public class Auth implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id 
	@GeneratedValue
	@Column(name = "id_auth")
	private int id;
	@Column(nullable = false, length = 300)
	private String token;
	@Column(nullable = false)
	private Date expire_date;
	@Column(nullable = false, length = 75)
	private Integer id_driver;
	
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Date getExpire_date() {
		return expire_date;
	}
	
	public void setExpire_date(Date expire_date) {
		this.expire_date = expire_date;
	}
	
	public Integer getId_driver() {
		return id_driver;
	}
	
	public void setId_driver(Integer id_driver) {
		this.id_driver = id_driver;
	}
	
}
