package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Subject;

public class SubjectDAO {
	private Connection conn;

	public SubjectDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public List<Subject> getSubject(String co, String se){
		List<Subject> list = new ArrayList<Subject>();
		Subject s = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from subject where course_name=? and semestar=?");
			ps.setString(1, co);
			ps.setString(2, se);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				s = new Subject();
				s.setId(rs.getInt(1));
				s.setCourse(rs.getString(2));
				s.setSemestar(rs.getString(3));
				s.setSubject(rs.getString(4));
				list.add(s);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
	
	public boolean validateAddSubject(String subject) {
		boolean b=false;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from subject where subject=?");
			ps.setString(1, subject);
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
