package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.model.Appointment;
import com.util.DBUtil;

public class HospitalDaoImpl {
	DBUtil db=new DBUtil();
	Connection conn;
	
	public Appointment getById(int id) throws SQLException 
	{
		conn=DBUtil.getDBConn();
		String sql="select * from appointment where id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		ResultSet rst=pstmt.executeQuery();
		if(rst.next())
		{
			int aid=rst.getInt("id");
			int pid=rst.getInt("patient_id");
			int did=rst.getInt("doctor_id");
			LocalDate appointmentDate=rst.getDate("appointment_date").toLocalDate();
			String description=rst.getString("description");
		
			Appointment m=new Appointment();
			m.setId(aid);
			m.setPatientId(pid);
			m.setDoctorId(did);
			m.setAppointmentDate(appointmentDate);
			m.setDescription(description);
			return m;
		}
		DBUtil.dbClose();
		 throw new NullPointerException("Invalid Name given");
	}

	public List<Appointment> listPatientAppointment(int pid) {
		conn=DBUtil.getDBConn();
		List<Appointment>list=new ArrayList<>();
		String sql="select * from appointment where patient_id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			ResultSet rst=pstmt.executeQuery();
			if(rst.next())
			{
				int aid1=rst.getInt("id");
				int pid1=rst.getInt("patient_id");
				int did1=rst.getInt("doctor_id");
				LocalDate appointmentDate=rst.getDate("appointment_date").toLocalDate();
				String description=rst.getString("description");
			
				Appointment m = new Appointment();
				m.setId(aid1);
				m.setPatientId(pid1);
				m.setDoctorId(did1);
				m.setAppointmentDate(appointmentDate);
				m.setDescription(description);
				return m;
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}

	public List<Appointment> listDoctorAppointment(int did) {
		conn=DBUtil.getDBConn();
		List<Appointment>list=new ArrayList<>();
		String sql="select * from appointment where doctor_id=?";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		ResultSet rst=pstmt.executeQuery();
		if(rst.next())
		{
			int aid2=rst.getInt("id");
			int pid2=rst.getInt("patient_id");
			int did2=rst.getInt("doctor_id");
			LocalDate appointmentDate=rst.getDate("appointment_date").toLocalDate();
			String description=rst.getString("description");
		
			Appointment m = new Appointment();
			m.setId(aid2);
			m.setPatientId(pid2);
			m.setDoctorId(did2);
			m.setAppointmentDate(appointmentDate);
			m.setDescription(description);
			return m;
		}
		
	}
	
	public void book(int aiid, int piid, int diid, String aDate, String description)  {

		conn=DBUtil.getDBConn();
		String sql="insert into appointment values(?,?,?,?,?)";
		PreparedStatement pstmt=conn.prepareStatement(sql);
		pstmt.setInt(1, aiid);
		pstmt.setPatientId(2, piid);
		pstmt.setDoctorId(3, diid);
		pstmt.setAppointmentDate(4,aDate);
		pstmt.setString(5,description);
		pstmt.executeUpdate();
		DBUtil.dbClose();
		
	}
		
	public static void update(int ida, String adescription) {
		conn=DBUtil.getDBConn();
		String sql="update vendor SET description=? where id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, adescription);
			pstmt.setInt(2, ida);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		DBUtil.dbClose();
		
	}
	
	public static void delete(int id1) {
		conn=DBUtil.getDBConn();
		String sql="delete from appointment where id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, id1);
			pstmt.executeUpdate();
		}
		catch(SQLException e)
		{
			System.out.println(e.getMessage());
		}
		DBUtil.dbClose();
	}
	
	}
}
