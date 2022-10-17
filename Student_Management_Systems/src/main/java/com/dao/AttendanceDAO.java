package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Attendance;
import com.entity.Student;

public class AttendanceDAO {

	private Connection conn;

	public AttendanceDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public List<Attendance> getAttance(int id) {
		List<Attendance> list = new ArrayList<Attendance>();
		Attendance a;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from attendance where sid=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Attendance();
				a.setId(rs.getInt(1));
				a.setStuId(rs.getInt(2));
				a.setName(rs.getString(3));
				a.setCourse(rs.getString(4));
				a.setSemestar(rs.getString(5));
				a.setYear(rs.getString(6));
				a.setMonth(rs.getString(7));
				a.setDays(rs.getString(8));
				list.add(a);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public Attendance getAttanceById(int id) {
		Attendance a= new Attendance();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from attendance where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a.setId(rs.getInt(1));
				a.setStuId(rs.getInt(2));
				a.setName(rs.getString(3));
				a.setCourse(rs.getString(4));
				a.setSemestar(rs.getString(5));
				a.setYear(rs.getString(6));
				a.setMonth(rs.getString(7));
				a.setDays(rs.getString(8));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public boolean validateAddAttendance(int sid,String year,String month) {
		boolean b=false;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from attendance where sid=? and year=? and month=?");
			ps.setInt(1, sid);
			ps.setString(2, year);
			ps.setString(3, month);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				b=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
}
