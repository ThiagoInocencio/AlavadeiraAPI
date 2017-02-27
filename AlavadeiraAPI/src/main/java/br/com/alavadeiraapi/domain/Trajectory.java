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
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "trajectory")
public class Trajectory implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_trajec", unique = true, nullable = false)
	private Integer trajectoryId;
	@Column(name = "name", nullable = false, length = 10)
	private String name;
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "trajectories")
	private List<Driver> drivers = new ArrayList<Driver>(0);
	
	public Trajectory() {
	}

	public Trajectory(String name) {
		this.name = name;
	}

	public Trajectory(String name,  List<Driver> drivers) {
		this.name = name;
		this.drivers = drivers;
	}
	
	public Integer getTrajectoryId() {
		return trajectoryId;
	}
	
	public void setTrajectoryId(Integer trajectoryId) {
		this.trajectoryId = trajectoryId;
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
