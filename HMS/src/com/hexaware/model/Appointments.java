package com.hexaware.model;

public class Appointments {
	
	
	private int appointmentId;
	private int patientId;
	private int doctorId;
	private String appointmentDate;
	private String description;

	
	public Appointments() {
		
	}
	
	public Appointments(int appointmentId,int doctorId, int patientId,String appointmentDate, String description) {
					super();
					this.appointmentId=appointmentId;
					this.doctorId=doctorId;
					this.patientId=patientId ;
					this.appointmentDate= appointmentDate;
					this.description=description;
		}
	
	public int getAppointmentid() {
		return appointmentId;
	}
	public void setAppointmentid(int appointmentid) {
		appointmentId = appointmentid;
	}
	public int getPatientid() {
		return patientId;
	}
	public void setPatientid(int patientid) {
		patientId = patientid;
	}
	public int getDoctorid() {
		return doctorId;
	}
	public void setDoctorid(int doctorid) {
		doctorId = doctorid;
	}
	public String getAppDate() {
		return appointmentDate;
	}
	public void setAppDate(String appointmentDate) {
		appointmentDate = appointmentDate;
	}
	public String getDesc() {
		return description;
	}
	public void setDesc(String description) {
		description = description;
	}


}
