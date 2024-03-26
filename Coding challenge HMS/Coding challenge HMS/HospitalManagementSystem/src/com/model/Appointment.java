package com.model;

import java.time.LocalDate;

public class Appointment {
	private int id;
	private int patientId;
	private int doctorId;
	private LocalDate appointmentDate;
	private String description;
	
	public Appointment() {}

	public Appointment(int id, int patientId, int doctorId, LocalDate appointmentDate, String description) {
		super();
		this.id = id;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}

	public Appointment(int patientId, int doctorId, LocalDate appointmentDate, String description) {
		super();
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Appointment [id=" + id + ", patientId=" + patientId + ", doctorId=" + doctorId + ", appointmentDate="
				+ appointmentDate + ", description=" + description + "]";
	}
	
}
