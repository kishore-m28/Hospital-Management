package com.hexaware.model;

public class Patient {

	private int patientId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String gender;
	private String contactNumber;
	private String address;

	public Patient() {
		
	}
	
	public Patient(int patientId, String firstName,String lastName,
			String dateOfBirth, String gender,String contactNumber,String address) {
				super();
				this.patientId=patientId ;
				this.firstName = firstName;
				this.lastName = lastName;
				this.dateOfBirth=dateOfBirth;
				this.gender=gender;
				this.contactNumber=contactNumber;
				this.address=this.address;
			}

	public int getPatientid() {
		return patientId;
	}
	public void setPatientid(int patientId) {
		patientId = patientId;
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
	public String getDateofBirth() {
		return dateOfBirth;
	}
	public void setDateofBirth(String dateofBirth) {
		dateOfBirth = dateofBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		gender = gender;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		contactNumber = contactNumber;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", dateOfBirth=" + dateOfBirth + ", gender=" + gender + ", contactNumber=" + contactNumber
				+ ", address=" + address + "]";
	}
	
}
