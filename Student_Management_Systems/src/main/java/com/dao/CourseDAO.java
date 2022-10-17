package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Course;


public class CourseDAO {
	private Connection conn;

	public CourseDAO(Connection conn) {
		 super();
		 this.conn=conn;
	 }
	
	public boolean addCourse(String c) {
		boolean f= false;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into course (course_name) values(?)");
			ps.setString(1, c);
			int i= ps.executeUpdate();
			if (i == 1) {
				f = true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Course> getCourse(){
		List<Course> list = new ArrayList<Course>();
		Course c;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from course");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				c=new Course();
				c.setId(rs.getInt(1));
				c.setCourse(rs.getString(2));
				list.add(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean validateAddCourse(String course) {
		boolean b=false;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from course where course_name=?");
			ps.setString(1, course);
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
