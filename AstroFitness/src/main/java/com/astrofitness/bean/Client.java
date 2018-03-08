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
	private String fname;
	@Column
	private String lname;
	@Column
	private String address;
	@Column
	private String email;
	@Column
	private String password;
	
//	@ManyToMany(fetch=FetchType.EAGER)
//	@JoinTable(name="Gym", 
//				joinColumns=@JoinColumn(name="CLIENTID"), //reference id of class we are in
//				inverseJoinColumns=@JoinColumn(name="GYM_ID"))
//	private Set<Gym> home_gyms;
	
	public Client() {
		super();
	}

	public Client(int client_id, String fname, String lname, String address, String email, String password) {
		super();
		this.client_id = client_id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.email = email;
		this.password = password;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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


	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", fname=" + fname + ", lname=" + lname + ", address=" + address
				+ ", email=" + email + ", password=" + password + ", home_gyms=" + "]";
	}

	
}
