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
	private int trainer_id;
	@Column
	private String name;
	@Column
	private String email;
	@Column
	private String password;
	
	@ManyToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="TRAINER_HOME")
	private Gym home_gym;
	
	public Trainer() {
		super();
	}
	public Trainer(Gym home_gym) {
		super();
		this.home_gym = home_gym;
	}
	public Trainer(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	public Trainer(String name, String email, String password, int trainer_id) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.trainer_id = trainer_id;
	}
	
	public Trainer(String name, String email, String password, Gym home_gym) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.home_gym = home_gym;
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
		return trainer_id;
	}
	public void setId(int trainer_id) {
		this.trainer_id = trainer_id;
	}
	public Gym getHome_gym() {
		return home_gym;
	}
	public void setHome_gym(Gym home_gym) {
		this.home_gym = home_gym;
	}
	
}
