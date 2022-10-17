package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;

public class StudentDAO {

	private Connection conn;

	public StudentDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public String forgetPassword(String email) {
		try {
			PreparedStatement ps = conn.prepareStatement("select * from student where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString(10);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int studentCount() {
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("select count(*) from student");
			ResultSet rs = ps.executeQuery();
			rs.next();
			i = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<Student> getData(String course, String sem) {
		List<Student> list = new ArrayList<Student>();
		Student s;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from student where course=? and semestar=?");
			ps.setString(1, course);
			ps.setString(2, sem);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Student();
				s.setId(rs.getInt(1));
				s.setRoll(rs.getString(2));
				s.setName(rs.getString(3));
				s.setGender(rs.getString(4));
				s.setDob(rs.getString(5));
				s.setAddress(rs.getString(6));
				s.setCourse(rs.getString(7));
				s.setSemestar(rs.getString(8));
				s.setEmail(rs.getString(9));
				s.setPassword(rs.getString(10));
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public Student getStudentById(int id) {
		Student s = new Student();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from student where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				s.setId(rs.getInt(1));
				s.setRoll(rs.getString(2));
				s.setName(rs.getString(3));
				s.setGender(rs.getString(4));
				s.setDob(rs.getString(5));
				s.setAddress(rs.getString(6));
				s.setCourse(rs.getString(7));
				s.setSemestar(rs.getString(8));
				s.setEmail(rs.getString(9));
				s.setPassword(rs.getString(10));

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public boolean validatePassword(String password, int id) {
		boolean b = false;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from student where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String str = rs.getString(10);
				if (str.equals(password)) {
					b = true;
				}
			} else {
				b = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public boolean validateEmail(String email) {
		boolean b = false;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from student where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
					b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;	
	
	}
}
