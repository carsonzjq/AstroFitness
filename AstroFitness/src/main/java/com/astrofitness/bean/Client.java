package com.astrofitness.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="CLIENT")
public class Client {
	
	@Id
	@Column
	@SequenceGenerator(sequenceName="CLIENT_SEQ", name="CLIENT_SEQ")
	@GeneratedValue(generator="CLIENT_SEQ", strategy=GenerationType.SEQUENCE)
	private int client_id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="Gym", 
				joinColumns=@JoinColumn(name="CLIENT_ID"), //reference id of class we are in
				inverseJoinColumns=@JoinColumn(name="GYM_ID"))
	private Set<Gym> home_gyms;
	
	public Client() {
		super();
	}
	public Client(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		
	}
	public Client(String name, String email, String password, Set<Gym> home_gyms) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.home_gyms = home_gyms;
	}

	public Client(int id, String name, String email, String password, Set<Gym> home_gyms) {
		super();
		this.client_id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.home_gyms = home_gyms;
	}

	public int getId() {
		return client_id;
	}

	public void setId(int id) {
		this.client_id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Set<Gym> getHome_gyms() {
		return home_gyms;
	}

	public void setHome_gyms(Set<Gym> home_gyms) {
		this.home_gyms = home_gyms;
	}
	
	
}
