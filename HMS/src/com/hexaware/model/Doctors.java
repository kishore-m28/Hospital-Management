package com.hexaware.model;

public class Doctors {
	
	private int doctorId;
	private String firstName;
	private String lastName;
	private String specialization;
	private String contactNumber;
	public Doctors() {
		
	}
	
	public Doctors(int doctorId, String firstName,String lastName,
		 String specialization,String contactNumber) {
				super();
				this.doctorId=doctorId;
				this.firstName = firstName;
				this.lastName = lastName;
				this.specialization=specialization;
				this.contactNumber=contactNumber;
	}
	
	
	public int getDoctorid() {
		return doctorId;
	}
	public void setDoctorid(int doctorId) {
		doctorId = getDoctorid();
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		lastName = lastName;
	}
	public String getSpecialization() {
		return specialization;
	}
	public void setSpecialization(String specialization) {
		specialization = specialization;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		contactNumber = contactNumber;
	}

	@Override
	public String toString() {
		return "Doctors [doctorId=" + doctorId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", specialization=" + specialization + ", contactNumber=" + contactNumber + "]";
	}
	

}
