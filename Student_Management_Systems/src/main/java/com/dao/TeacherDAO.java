package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Teacher;

public class TeacherDAO {
	private Connection conn;

	public TeacherDAO(Connection conn) {
		super();
		this.conn = conn;
	}

	public String forgetPassword(String email) {
		try {
			PreparedStatement ps = conn.prepareStatement("select * from teacher where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			rs.next();
			return rs.getString(7);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public int teacherCount() {
		int i = 0;
		try {
			PreparedStatement ps = conn.prepareStatement("select count(*) from teacher");
			ResultSet rs = ps.executeQuery();
			rs.next();
			i = rs.getInt(1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public List<Teacher> getTeacher() {
		List<Teacher> list = new ArrayList<Teacher>();
		Teacher t;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from teacher");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				t = new Teacher();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setGender(rs.getString(3));
				t.setDob(rs.getString(4));
				t.setQualification(rs.getString(5));
				t.setEmail(rs.getString(6));
				t.setPassword(rs.getString(7));
				list.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	public Teacher getTeacherByid(int id) {
		Teacher t = new Teacher();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from teacher where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				t = new Teacher();
				t.setId(rs.getInt(1));
				t.setName(rs.getString(2));
				t.setGender(rs.getString(3));
				t.setDob(rs.getString(4));
				t.setQualification(rs.getString(5));
				t.setEmail(rs.getString(6));
				t.setPassword(rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}

	public boolean validatePassword(String password, int tid) {
		boolean b = false;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from teacher where id=?");
			ps.setInt(1, tid);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String str = rs.getString(7);
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
			PreparedStatement ps = conn.prepareStatement("select * from teacher where email=?");
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
