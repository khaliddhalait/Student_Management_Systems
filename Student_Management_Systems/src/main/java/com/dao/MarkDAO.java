package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Mark;

public class MarkDAO {
	private Connection conn;

	public MarkDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public List<Mark> getMark(int sid, String sem){
		List<Mark> list = new ArrayList<Mark>();
		Mark m = null;
		boolean f = true;
		try {
			String sql = "select * from mark where stuid=? and semestar=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, sid);
			ps.setString(2, sem);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = new Mark();
				m.setId(rs.getInt(1));
				m.setStuid(rs.getInt(2));
				m.setRoll(rs.getString(3));
				m.setName(rs.getString(4));
				m.setCourse(rs.getString(5));
				m.setSemestar(rs.getString(6));
				m.setSubject(rs.getString(7));
				m.setMark(rs.getInt(8));
				list.add(m);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean validateAddMarks(int sid,String subject) {
		boolean b=false;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from mark where stuid=? and subject=?");
			ps.setInt(1, sid);
			ps.setString(2, subject);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				b=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
	}
	
	public Mark getMarkByID(String stuid, String sem) {

		Mark m = null;
		try {
			String sql = "select * from mark where stuid=? and semestar=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(stuid));
			ps.setString(2, sem);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = new Mark();
				m.setId(rs.getInt(1));
				m.setStuid(rs.getInt(2));
				m.setRoll(rs.getString(3));
				m.setName(rs.getString(4));
				m.setCourse(rs.getString(5));
				m.setSemestar(rs.getString(6));
				m.setSubject(rs.getString(7));
				m.setMark(rs.getInt(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
	public Mark getMarkByID(int id) {

		Mark m = null;
		try {
			String sql = "select * from mark where id=?";

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				m = new Mark();
				m.setId(rs.getInt(1));
				m.setStuid(rs.getInt(2));
				m.setRoll(rs.getString(3));
				m.setName(rs.getString(4));
				m.setCourse(rs.getString(5));
				m.setSemestar(rs.getString(6));
				m.setSubject(rs.getString(7));
				m.setMark(rs.getInt(8));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return m;
	}
	
}
