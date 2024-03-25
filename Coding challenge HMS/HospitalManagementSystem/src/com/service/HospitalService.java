package com.service;


import java.sql.SQLException;
import java.util.List;

import com.dao.HospitalDaoImpl;
import com.model.Appointment;

public class HospitalService {
	
	HospitalDaoImpl hospitalDaoImpl=new HospitalDaoImpl();
	
	public static Appointment getById(int aid) throws  SQLException {
		return hospitalDaoImpl.getById(aid);
	}

	public List<Appointment> listPatientAppointment(int pid) {
		List<Appointment>list= hospitalDaoImpl.listPatientAppointment(pid);
		return list;
	}

	public List<Appointment> listDoctorAppointment(int did) {
		List<Appointment>list= hospitalDaoImpl.listDoctorAppointment(did);
		return list;
	}
	
	public static void book(int aiid, int piid, int diid, String aDate, String description) {
		HospitalDaoImpl.book(aiid, piid, diid, aDate, description);
		
	}

	public void update(int ida, String adescription) {
		HospitalDaoImpl.update(ida ,adescription);
		
	}

	public void delete(int id1) {
		HospitalDaoImpl.delete(id1);
	}

	

	
	
	
}
