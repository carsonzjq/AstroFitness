package com.astrofitness.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
@Entity
@Table(name="GYM")
public class Gym {

	@Id
	@Column
	@SequenceGenerator(sequenceName="TRAINER_SEQ", name="TRAINER_SEQ")
	@GeneratedValue(generator="TRAINER_SEQ", strategy=GenerationType.SEQUENCE)
	private int gym_id;
	@Column
	private String name;
	@Column
	private String address;
	@OneToMany(mappedBy="home_gym", fetch=FetchType.EAGER)
	private List<Trainer> trainers;

	@OneToMany(mappedBy="client_gym", fetch=FetchType.EAGER)
	private List<Client> clients;
	
	
	public Gym() {
		super();
	}
	public Gym(int gym_id) {
		super();
		this.gym_id = gym_id;
	}
	public Gym(String name) {
		super();
		this.name = name;
	}
	public Gym(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public Gym(String name, String address, List<Trainer> trainers) {
		super();
		this.name = name;
		this.address = address;
		this.trainers = trainers;
	}
	public Gym(int gym_id, String name, String address, List<Trainer> trainers) {
		super();
		this.gym_id = gym_id;
		this.name = name;
		this.address = address;
		this.trainers = trainers;
	}
	public int getId() {
		return gym_id;
	}
	public void setId(int gym_id) {
		this.gym_id = gym_id;
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
	public List<Client> getClients() {
		return clients;
	}
	public void setClients(List<Client> clients) {
		this.clients = clients;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + gym_id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((trainers == null) ? 0 : trainers.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Gym other = (Gym) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (gym_id != other.gym_id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (trainers == null) {
			if (other.trainers != null)
				return false;
		} else if (!trainers.equals(other.trainers))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Gym [gym_id=" + gym_id + ", name=" + name + ", address="
				+ address + "]";
	}
	
	
}
