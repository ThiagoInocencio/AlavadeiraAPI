package br.com.alavadeiraapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name = "driver", uniqueConstraints = {
		         @UniqueConstraint(columnNames = "email"),
		         @UniqueConstraint(columnNames = "car_plate") })
public class Driver implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_driver", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 75)
	private String name;
	@Column(nullable = false, length = 8)
	private String car_plate;
	@Column(nullable = false, length = 50)
	private String email;
	@Column(nullable = false, length = 400)
	private String password;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Trajectory> trajectories = new ArrayList<Trajectory>(0);
	
	
	public Driver() {
	}

	public Driver(String name, String car_plate, String email, String password) {
		this.name = name;
		this.car_plate = car_plate;
		this.email = email;
		this.password = password;
	}

	public Driver(String name, String car_plate, String email, String password, List<Trajectory> trajectories) {
		this.name = name;
		this.car_plate = car_plate;
		this.email = email;
		this.password = password;
		this.trajectories = trajectories;
	}
	
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
	
	public String getCar_plate() {
		return car_plate;
	}

	public void setCar_plate(String car_plate) {
		this.car_plate = car_plate;
	}
	
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

	public List<Trajectory> getTrajectories() {
		return trajectories;
	}

	public void setTrajectories(List<Trajectory> trajectories) {
		this.trajectories = trajectories;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public List<Trajectory> getCategories() {
		return this.trajectories;
	}
}
