package com.astrofitness.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

public class Gym {

	@Id
	@Column
	@SequenceGenerator(sequenceName="TRAINER_SEQ", name="TRAINER_SEQ")
	@GeneratedValue(generator="TRAINER_SEQ", strategy=GenerationType.SEQUENCE)
	private int id;
	@Column
	private String name;
	@Column
	private String address;
	@OneToMany(mappedBy="HOME_GYM", fetch=FetchType.EAGER)
	private List<Trainer> trainers;
	
	public Gym() {
		super();
	}
	public Gym(int id, String name, String address, List<Trainer> trainers) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.trainers = trainers;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public List<Trainer> getTrainers() {
		return trainers;
	}
	public void setTrainers(List<Trainer> trainers) {
		this.trainers = trainers;
	}
	
}
