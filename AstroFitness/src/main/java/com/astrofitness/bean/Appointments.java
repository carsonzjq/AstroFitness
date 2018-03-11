package com.astrofitness.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="APPOINTMENTS")
public class Appointments {
	@Id
	@Column
	@SequenceGenerator(sequenceName="APPOINTMENTS_SEQ", name="APPOINTMENTS_SEQ")
	@GeneratedValue(generator="APPOINTMENTS_SEQ", strategy=GenerationType.SEQUENCE)
	private int appointment_id;
	@Column
	private int client_id;
	@Column
	private int trainer_id;
	@Column
	private int hour;	//sessions are 1 hour long (between 9am to 8pm)
	
	public Appointments() {
		super();
	}
	
	public Appointments(int client_id, int trainer_id, int hour) {
		super();
		this.client_id = client_id;
		this.trainer_id = trainer_id;
		this.hour = hour;
	}
	
	public Appointments(int appointment_id, int client_id, int trainer_id, int hour) {
		super();
		this.appointment_id = appointment_id;
		this.client_id = client_id;
		this.trainer_id = trainer_id;
		this.hour = hour;
	}

	public int getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public int getClient_id() {
		return client_id;
	}

	public void setClient_id(int client_id) {
		this.client_id = client_id;
	}

	public int getTrainer_id() {
		return trainer_id;
	}

	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	@Override
	public String toString() {
		return "Appointments [appointment_id=" + appointment_id + ", client_id=" + client_id + ", trainer_id="
				+ trainer_id + ", hour=" + hour + "]";
	}
}
