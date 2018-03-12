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
	private String client_name;
	@Column
	private String trainer_name;
	@Column
	private int hour;
	@Column
	private String day;	
	
	public Appointments() {
		super();
	}

	public Appointments(int appointment_id, String client_name, String trainer_name, int hour, String day) {
		super();
		this.appointment_id = appointment_id;
		this.client_name = client_name;
		this.trainer_name = trainer_name;
		this.hour = hour;
		this.day = day;
	}
	
	public Appointments(String client_name, String trainer_name, int hour, String day) {
		super();
		this.client_name = client_name;
		this.trainer_name = trainer_name;
		this.hour = hour;
		this.day = day;
	}

	public int getAppointment_id() {
		return appointment_id;
	}

	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getTrainer_name() {
		return trainer_name;
	}

	public void setTrainer_name(String trainer_name) {
		this.trainer_name = trainer_name;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	@Override
	public String toString() {
		return "Appointments [appointment_id=" + appointment_id + ", client_name=" + client_name + ", trainer_name="
				+ trainer_name + ", hour=" + hour + ", day=" + day + "]";
	}
}