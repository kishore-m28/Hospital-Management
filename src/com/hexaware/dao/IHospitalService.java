package com.hexaware.dao;

import com.hexaware.model.*;
import java.util.List;

import com.hexaware.exception.PatientNumberNotFoundException;

public interface IHospitalService {
	
	public Appointments getAppointmentById();

	public List<Appointments> getAppointmentsForPatient() throws PatientNumberNotFoundException;

	public List<Appointments> getAppointmentsForDoctor();

	public boolean scheduleAppointment(Appointments app);

	public boolean updateAppointment(Appointments appointment);

	public boolean cancelAppointment(Appointments appointment);

	public void addPatientToDatabase(Patient patient );

	public void addDoctorToDatabase(Doctors doctor);


}

