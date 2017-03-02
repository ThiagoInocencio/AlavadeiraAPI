package br.com.alavadeiraapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "trajectory")
public class Trajectory implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_trajec", unique = true, nullable = false)
	private Integer id;
	@Column(name = "name", nullable = false, length = 10)
	private String name;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "trajectories")
	private List<Driver> drivers = new ArrayList<Driver>(0);
	
	public Integer getTrajectoryId() {
		return id;
	}
	public void setTrajectoryId(Integer id_trajectory) {
		this.id = id_trajectory;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Driver> getDrivers() {
		return drivers;
	}
	public void setDrivers(List<Driver> drivers) {
		this.drivers = drivers;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
