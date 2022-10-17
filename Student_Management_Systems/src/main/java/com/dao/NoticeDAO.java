package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Notice;

public class NoticeDAO {
	private Connection conn;

	public NoticeDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public List<Notice> getNotice(){
		List<Notice> list = new ArrayList<Notice>();
		Notice n = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from notice order by id DESC");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				n = new Notice();
				n.setId(rs.getInt(1));
				n.setName(rs.getString(2));
				n.setMessage(rs.getString(3));
				n.setDate(rs.getString(4));
				list.add(n);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
