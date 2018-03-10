package com.astrofitness.bean;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Manager")
public class Manager {
	@Id
	@Column
	private int managerId;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private String email;
	@Column
	private String password;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "Gym_id")
	private Gym gym;
	
	
	public Manager() {
		super();
	}
    public Manager(String email, String password) {
		super();
		this.email = email;
		this.password = password;
	}


	public Manager(String fname, String lname, String email, String password) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
	}


	public Manager(int managerId, String fname, String lname, String email, String password) {
		super();
		this.managerId = managerId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
	}


	public Manager(int managerId, String fname, String lname, String email, String password, Gym gym) {
		super();
		this.managerId = managerId;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.gym = gym;
	}
	/**
	 * @return the managerId
	 */
	public int getManagerId() {
		return managerId;
	}
	/**
	 * @param managerId the managerId to set
	 */
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	/**
	 * @return the fname
	 */
	public String getFname() {
		return fname;
	}
	/**
	 * @param fname the fname to set
	 */
	public void setFname(String fname) {
		this.fname = fname;
	}
	/**
	 * @return the lname
	 */
	public String getLname() {
		return lname;
	}
	/**
	 * @param lname the lname to set
	 */
	public void setLname(String lname) {
		this.lname = lname;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the gym
	 */
	public Gym getGym() {
		return gym;
	}
	/**
	 * @param gym the gym to set
	 */
	public void setGym(Gym gym) {
		this.gym = gym;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", fname=" + fname + ", lname=" + lname + ", email=" + email
				+ ", password=" + password +"]";
	}
    	
	
	

}
