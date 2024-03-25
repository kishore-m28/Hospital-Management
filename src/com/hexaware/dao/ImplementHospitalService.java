package com.hexaware.dao;

import com.hexaware.model.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.sql.Date;

import com.hexaware.exception.PatientNumberNotFoundException;
import com.hexaware.model.Appointments;

import com.hexaware.util.DbConnUtil;


public class ImplementHospitalService implements  IHospitalService {

	Scanner sc = new Scanner(System.in);
	Connection con;
	Statement stmt;
	PreparedStatement ps;
	ResultSet rs;
	private List<Appointments> appointmentsList;
	
	public void addPatientToDatabase(Patient patient) {
        try (Connection con = DbConnUtil.getDBConn();
             PreparedStatement ps = con.prepareStatement("INSERT INTO patient (patientId, firstName, lastName, dateOfBirth, gender, contactNumber, address) VALUES (?, ?, ?, ?, ?, ?, ?)")) {

            ps.setInt(1, patient.getPatientid());
            ps.setString(2, patient.getFirstName());
            ps.setString(3, patient.getLastName());
            ps.setString(4, patient.getDateofBirth());
            ps.setString(5, patient.getGender());
            ps.setString(6, patient.getContactNumber());
            ps.setString(7, patient.getAddress());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Patient added successfully.");
            } else {
                System.out.println("Failed to add patient.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
	public void addDoctorToDatabase(Doctors doctor) {
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = DbConnUtil.getDBConn(); 
            String query = "INSERT INTO doctor (doctorId, firstName, lastName, specialization, contactNumber) VALUES (?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setInt(1, doctor.getDoctorid());
            ps.setString(2, doctor.getFirstName());
            ps.setString(3, doctor.getLastName());
            ps.setString(4, doctor.getSpecialization());
            ps.setString(5, doctor.getContactNumber());

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Doctor added successfully.");
            } else {
                System.out.println("Failed to add doctor.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
	}

	public Appointments getAppointmentById() {
        System.out.println("Enter Appointment ID: ");
        int id = sc.nextInt();
        return getAppointmentByIdFromDatabase(id);
    }
	
	

    public Appointments getAppointmentByIdFromDatabase(int Appointmentid) {
        try {
            con = DbConnUtil.getDBConn();
            ps = con.prepareStatement("SELECT * FROM appointment WHERE appointmentid = ?");
            ps.setInt(1, Appointmentid);
            rs = ps.executeQuery();
            if (rs.next()) {
                Appointments appointment = new Appointments();
                appointment.setAppointmentid(rs.getInt("appointmentid"));
                appointment.setDoctorid(rs.getInt("doctorid"));
                appointment.setPatientid(rs.getInt("patientid"));
                appointment.setAppDate(rs.getString("appointmentDate"));
                appointment.setDesc(rs.getString("description"));
                  
              
                System.out.println("Appointment ID: " + appointment.getAppointmentid());
				System.out.println("Doctor ID: " + appointment.getDoctorid());
				System.out.println("Patient ID: " + appointment.getPatientid());
				System.out.println("Appointment Date: " + appointment.getAppDate());
				System.out.println("Patient Description: " + appointment.getDesc());
                return appointment;
            } else {
                System.out.println("Detail Not Found");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    

	@Override
	public List<Appointments> getAppointmentsForPatient() throws PatientNumberNotFoundException{
	System.out.println("Enter the patient ID:");
	int pid=sc.nextInt();
	return getAppointmentsForPatientFromData(pid);
	
	}

	public List<Appointments> getAppointmentsForPatientFromData(int pid)throws PatientNumberNotFoundException {
		
		 List<Appointments> appointmentsList = new ArrayList<>();
		 try {
	            con = DbConnUtil.getDBConn();
	            ps = con.prepareStatement("SELECT * FROM appointment WHERE patientid = ?");
	            ps.setInt(1, pid);
	            rs = ps.executeQuery();
	         
	           
	            while (rs.next()) {
	                Appointments appointment = new Appointments();
	                appointment.setAppointmentid(rs.getInt("appointmentid"));
	                appointment.setDoctorid(rs.getInt("doctorid"));
	                appointment.setPatientid(rs.getInt("patientid"));
	                appointment.setAppDate(rs.getString("appointmentDate"));
	                appointment.setDesc(rs.getString("description"));
	                appointmentsList.add(appointment);
	                
	                System.out.println("Appointment ID: " + appointment.getAppointmentid());
					System.out.println("Doctor ID: " + appointment.getDoctorid());
					System.out.println("Patient ID: " + appointment.getPatientid());
					System.out.println("Appointment Date: " + appointment.getAppDate());
					System.out.println("Patient Description: " + appointment.getDesc());
					
					
	            }
	            if (appointmentsList.isEmpty()) {
	            	throw new PatientNumberNotFoundException("Patient Not Found");
	                
	            }
	          
	          
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
		return appointmentsList;
		
	}
	     
	
	
	
	public List<Appointments> getAppointmentsForDoctor() {
		System.out.println("Enter the Doctor ID:");
		int did=sc.nextInt();
		return getAppointmentsForDoctorFromData(did);
		
		}
	public List<Appointments> getAppointmentsForDoctorFromData(int did) {
		List<Appointments> appointmentsList = new ArrayList<>();
		 try {
	            con = DbConnUtil.getDBConn();
	            ps = con.prepareStatement("SELECT * FROM appointment WHERE doctorid = ?");
	            ps.setInt(1, did);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                Appointments appointment = new Appointments();
	                appointment.setAppointmentid(rs.getInt("appointmentid"));
	                appointment.setDoctorid(rs.getInt("doctorid"));
	                appointment.setPatientid(rs.getInt("patientid"));
	                appointment.setAppDate(rs.getString("appointmentDate"));
	                appointment.setDesc(rs.getString("description"));
	                appointmentsList.add(appointment);
	                
	                System.out.println("Appointment ID: " + appointment.getAppointmentid());
					System.out.println("Doctor ID: " + appointment.getDoctorid());
					System.out.println("Patient ID: " + appointment.getPatientid());
					System.out.println("Appointment Date: " + appointment.getAppDate());
					System.out.println("Patient Description: " + appointment.getDesc());
					
	                
	            }
	            if (appointmentsList.isEmpty()) {
	                System.out.println("No appointments found for doctor ID: " + did);
	                return null;
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
		return appointmentsList;
	}

	public boolean scheduleAppointment(Appointments app) {
	    try {
	        con = DbConnUtil.getDBConn();
	        
	        
	       
	        ps = con.prepareStatement("insert into appointment (appointmentid,doctorid, patientid, appointmentDate, description) VALUES (?,?, ?, ?, ?)");
	        ps.setInt(1, app.getAppointmentid());
	        ps.setInt(2, app.getDoctorid());
	        ps.setInt(3, app.getPatientid());
	        ps.setString(4, app.getAppDate());
	        ps.setString(5, app.getDesc());
	        
	       
	        
	        int rowsAffected = ps.executeUpdate();
	        if (rowsAffected > 0) {
	            System.out.println("Scheduled");
	            return true;
	        } 
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
		return false;
	  
	}

	@Override
	public boolean updateAppointment(Appointments appointment) {
	    try {
	        con = DbConnUtil.getDBConn();
	        System.out.println("Enter Appointment ID:");
	        int appointmentId = sc.nextInt(); 
	        System.out.println("Enter Doctor ID:");
	        int doctorId = sc.nextInt(); 
	        System.out.println("Enter Patient ID:");
	        int patientId = sc.nextInt(); 
	        System.out.println("Enter Appointment Date:");
	        String appDate = sc.next(); 
	        System.out.println("Enter Patient Description:");
	        String desc = sc.next(); 
	        
	        ps = con.prepareStatement("UPDATE appointment SET doctorid = ?, appointmentDate = ?, description = ? WHERE appointmentid = ?");
	        ps.setInt(1, doctorId);
	        ps.setString(2, appDate);
	        ps.setString(3, desc);
	        ps.setInt(4, appointmentId); 
	        int rowsUpdated = ps.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Appointment updated successfully");
	            return true;
	        } else {
	            System.out.println("Failed to update appointment. Appointment ID not found.");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}
	
	public boolean cancelAppointment(Appointments appointment) {
	    try {
	        con = DbConnUtil.getDBConn();
	        System.out.println("Enter Appointment ID to cancel:");
	        int appointmentId = sc.nextInt();     
	        ps = con.prepareStatement("DELETE FROM appointment WHERE appointmentid = ?");
	        ps.setInt(1, appointmentId);
	        int rowsUpdated = ps.executeUpdate();
	        if (rowsUpdated > 0) {
	            System.out.println("Appointment canceled successfully");
	            return true;
	        } else {
	            System.out.println("Failed to cancel appointment");
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

}