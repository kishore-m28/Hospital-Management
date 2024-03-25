package com.hexaware.main;

import com.hexaware.model.*;
import java.util.Scanner;

import com.hexaware.dao.*;
import com.hexaware.exception.PatientNumberNotFoundException;
import com.hexaware.model.Appointments;

public class MainModule{

	public static void main(String[] args) throws PatientNumberNotFoundException {
		IHospitalService ihs = new ImplementHospitalService();
		 Appointments appointment = new Appointments();
		 Scanner sc = new Scanner(System.in);
		 String ch = null;
		do {
			System.out.println("Enter your choice:");
			System.out.println("1. View Appointment Details");
			System.out.println("2. View Patient Appointments");
			System.out.println("3. View Doctor Appointments");
			System.out.println("4. Schedule Appointment");
			System.out.println("5. Update Appointment");
			System.out.println("6. Cancel Appointmnet");
			System.out.println("7. Add Patient");
			System.out.println("8. Add Doctor");
		

			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				ihs.getAppointmentById();
				
					break;
			}
			case 2: {
				ihs.getAppointmentsForPatient();
				
				break;
			}
			case 3: {
				ihs.getAppointmentsForDoctor();

				break;
		}
			case 4: { 
			System.out.println("Enter App ID:");
            int Appointmentid=sc.nextInt();
            System.out.println("Enter Doctor ID:");
            int Doctorid=sc.nextInt();
            System.out.println("Enter Patient ID:");
            int Patientid=sc.nextInt();
            System.out.println("Enter Appointment Date:");
            String AppDate=sc.next();
            System.out.println("Enter Patient Description:");
            String Desc=sc.next();
            Appointments app=new Appointments(Appointmentid,Doctorid,Patientid,AppDate,Desc);
            
			
		    ihs.scheduleAppointment(app);
		    break;
			}
			case 5: {
					ihs.updateAppointment(appointment);
				break;
			}
			case 6: {
				ihs.cancelAppointment(appointment);				
			break;
			}
			case 7: { 
                System.out.println("Enter Patient ID:");
                int patientId = sc.nextInt();
                System.out.println("Enter First Name:");
                String firstName = sc.next();
                System.out.println("Enter Last Name:");
                String lastName = sc.next();
                System.out.println("Enter Date of Birth:");
                String dateOfBirth = sc.next();
                System.out.println("Enter Gender:");
                String gender = sc.next();
                System.out.println("Enter Contact Number:");
                String contactNumber = sc.next();
                System.out.println("Enter Address:");
                String address = sc.next();
               
                Patient patient = new Patient(patientId, firstName, lastName, dateOfBirth, gender, contactNumber,address);
                ihs.addPatientToDatabase(patient);
                break;
            }
			case 8: { 
			    System.out.println("Enter Doctor ID:");
			    int doctorId = sc.nextInt();
			    System.out.println("Enter First Name:");
			    String firstName = sc.next();
			    System.out.println("Enter Last Name:");
			    String lastName = sc.next();
			    System.out.println("Enter Specialization:");
			    String specialization = sc.next();
			    System.out.println("Enter Contact Number:");
			    String contactNumber = sc.next();
			               
			    Doctors doctor = new Doctors(doctorId, firstName, lastName, specialization, contactNumber);
			    ihs.addDoctorToDatabase(doctor);
			    break;
			}
			default: {
				System.out.println("Enter the right choice. ");
			}
			}
			System.out.println("Do you want to continue? Y or y");
			ch = sc.next();
		} while (ch.equals("Y") || ch.equals("y"));
		System.out.println("Thanks for using our system !!!");
		System.exit(0);
	}
}