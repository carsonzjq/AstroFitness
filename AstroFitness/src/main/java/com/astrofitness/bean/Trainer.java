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
@Table(name="Trainer")
public class Trainer {  
	
	@Id
	@Column
	@SequenceGenerator(sequenceName="TRAINER_SEQ", name="TRAINER_SEQ")
	@GeneratedValue(generator="TRAINER_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	
//	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
//	@JoinColumn(name="TRAINER")
//	@Column
//	private Gym home_gym;
	
	public Trainer() {
		super();
	}
	public Trainer(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public Trainer(String name, String email, String password, int id) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.id = id;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
