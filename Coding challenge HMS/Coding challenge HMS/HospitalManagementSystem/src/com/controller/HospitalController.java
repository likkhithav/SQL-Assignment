package com.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.model.Appointment;
import com.service.HospitalService;

public class HospitalController {
	public static void main(String[] args) {
		
		HospitalService hospitalService = new HospitalService();
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("**********SERVICES************");
			System.out.println("PRESS 1 TO Get Appointment by Id");
			System.out.println("PRESS 2 TO Get Appointment for Patient");
			System.out.println("PRESS 3 TO Get Appointment for Doctor");
			System.out.println("PRESS 4 TO Schedule Appointment");
			System.out.println("PRESS 5 TO Update Appointment");
			System.out.println("PRESS 6 TO Cancel Appointment");
			System.out.println("PRESS 0 TO Exit");
			System.out.println("**********************");
			int input=sc.nextInt();
			
			if(input==0)
			{
				System.out.println("Exiting....Thank you!!!");
				break;
			}
			switch(input)
			{
						
				case 1:
					System.out.println("***Appointment by Id***");
					System.out.println("Enter the ID: ");
					sc.nextLine();
					int id=sc.nextInt();
					
					try
					{
						Appointment m= HospitalService.getById(id);
						System.out.println(m);
					}
					catch (SQLException e) {
						 System.out.println(e.getMessage());
					}
					catch(NullPointerException e)
					{
						System.out.println(e.getMessage());
					}
					break;
				
				case 2:
					System.out.println("***Appointment for Patient***");
					System.out.println("Enter the Patient ID: ");
					sc.nextLine();
					int pid=sc.nextInt();
					List<Appointment>palist=hospitalService.listPatientAppointment(pid);
					for(Appointment m:palist)
					{
						System.out.println(palist);
					}
					break;
					
				case 3:
					System.out.println("***Appointment for Doctor***");
					System.out.println("Enter the Doctor ID: ");
					sc.nextLine();
					int did=sc.nextInt();
					List<Appointment>dalist=hospitalService.listDoctorAppointment(did);
					for(Appointment m:dalist)
					{
						System.out.println(dalist);
					}
					break;
					
				case 4:
					System.out.println("***Schedule Appointment***");
					System.out.println("Enter Appointment details: ");
					System.out.println("Enter the ID: ");
					int aiid=sc.nextInt();
					
					System.out.println("Enter the Patient ID: ");
					int piid=sc.nextInt();
					
					System.out.println("Enter the Doctor ID: ");
					int diid=sc.nextInt();
					
					System.out.println("Appointment Date in (YYYY-MM-DD)");
					sc.nextLine();
					String aDate=sc.nextLine();
					
					System.out.println("Enter Description: ");
					String description=sc.nextLine();
					
					HospitalService.book(aiid, piid, diid, aDate, description);
					break;

					
				case 5:
					System.out.println("***Update Appointment***");
					System.out.println("Enter ID to be Updated: ");
					int ida=sc.nextInt();
					
					System.out.println("Enter Description ");
					sc.nextLine();
					String adescription=sc.nextLine();
					hospitalService.update(ida, adescription);
					break;
					
				case 6:
					System.out.println("***Delete Details***");
					System.out.println("Enter the ID to be deleted: ");
					int id1=sc.nextInt();
					hospitalService.delete(id1);
					System.out.println("###Deleted###");
					break;
					
					
				default:
					System.out.println("Invalid Input!!!");
					break;
			}
	}
	}
}
