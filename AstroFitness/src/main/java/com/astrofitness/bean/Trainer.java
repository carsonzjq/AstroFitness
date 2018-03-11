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
@Table(name = "Trainer")
public class Trainer {

	@Id
	@Column
	@SequenceGenerator(sequenceName = "TRAINER_SEQ", name = "TRAINER_SEQ")
	@GeneratedValue(generator = "TRAINER_SEQ", strategy = GenerationType.SEQUENCE)
	private int trainer_id;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private String email;
	@Column
	private String address;
	@Column
	private String password;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "TRAINER_HOME")
	private Gym home_gym;

	public Trainer() {
		super();
	}

	public Trainer(String fname, String lname, String address, String email,
			String password, Gym home_gym) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.email = email;
		this.password = password;
		this.home_gym = home_gym;
	}

	public Trainer(int trainer_id, String fname, String lname, String address,
			String email, String password, Gym home_gym) {
		super();
		this.trainer_id = trainer_id;
		this.fname = fname;
		this.lname = lname;
		this.address = address;
		this.email = email;
		this.password = password;
		this.home_gym = home_gym;
	}

	public int getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
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

	public Gym getHome_gym() {
		return home_gym;
	}

	public void setHome_gym(Gym home_gym) {
		this.home_gym = home_gym;
	}

	@Override
	public String toString() {
		return "Trainer [trainer_id=" + trainer_id + ", fname=" + fname
				+ ", lname=" + lname + ", email=" + email + ", address="
				+ address + ", password=" + password + ", home_gym=" + home_gym
				+ "]";
	}

}
