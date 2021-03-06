package com.astrofitness.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CLIENT")
public class Client {

	@Id
	@Column
	@SequenceGenerator(sequenceName = "CLIENT_SEQ", name = "CLIENT_SEQ")
	@GeneratedValue(generator = "CLIENT_SEQ", strategy = GenerationType.SEQUENCE)
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

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "Client_Home")
	private Gym client_gym;

	public Client() {
		super();
	}

	public Client(String fname, String lname, String address, String email,
			String password, Gym client_gym) {
		super();

		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.email = email;
		this.password = password;
		this.client_gym = client_gym;
	}

	public Client(int client_id, String fname, String lname, String address,
			String email, String password, Gym client_gym) {
		super();
		this.client_id = client_id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.email = email;
		this.password = password;
		this.client_gym = client_gym;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public Gym getClient_gym() {
		return client_gym;
	}

	public void setClient_gym(Gym client_gym) {
		this.client_gym = client_gym;
	}

	@Override
	public String toString() {
		return "Client [client_id=" + client_id + ", fname=" + fname
				+ ", lname=" + lname + ", address=" + address + ", email="
				+ email + ", password=" + password + ", client_gym="
				+ client_gym + "]";
	}

}
