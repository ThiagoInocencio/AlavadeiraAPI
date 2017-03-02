package br.com.alavadeiraapi.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "visit")
public class Visit implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "id_visit", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 5)
	private String trajectory;
	@Column(nullable = false)
	@Type(type="date")
	private Date schedule_for;
	@Column(nullable = false)
	private int priority;
	@Column()
	private Date visited_at;
	@ManyToOne()
	@JoinColumn(name = "id_driver", nullable = false)
	private Driver driver;
	@ManyToOne()
	@JoinColumn(name = "id_address", nullable = false)
	private Address address;
	@ManyToOne()
	@JoinColumn(name = "id_customer", nullable = false)
	private Customer customer;
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Deliverable> deliverables = new ArrayList<Deliverable>(0);
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTrajectory() {
		return trajectory;
	}
	public void setTrajectory(String trajectory) {
		this.trajectory = trajectory;
	}
	public Date getSchedule_for() {
		return schedule_for;
	}
	public void setSchedule_for(Date schedule_for) {
		this.schedule_for = schedule_for;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public Date getVisited_at() {
		return visited_at;
	}
	public void setVisited_at(Date visited_at) {
		this.visited_at = visited_at;
	}
	public Driver getDriver() {
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public List<Deliverable> getDeliverables() {
		return deliverables;
	}
	public void setDeliverables(List<Deliverable> deliverables) {
		this.deliverables = deliverables;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
