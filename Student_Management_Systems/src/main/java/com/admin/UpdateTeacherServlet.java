package com.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;

/**
 * Servlet implementation class UpdateTeacherServlet
 */
public class UpdateTeacherServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String n = req.getParameter("name");
			String g = req.getParameter("gender");
			String d = req.getParameter("dob");
			String q = req.getParameter("qua");
			String e = req.getParameter("email");
			String p = req.getParameter("password");
			Encoder encoder = Base64.getEncoder();
			p = encoder.encodeToString(p.getBytes());
			
			Connection conn = DBConnect.getConn();
			PreparedStatement ps = conn.prepareStatement("update teacher set name=?,gender=?,dob=?,qualification=?,email=?,password=? where id=?");
			ps.setString(1, n);
			ps.setString(2, g);
			ps.setString(3, d);
			ps.setString(4, q);
			ps.setString(5, e);
			ps.setString(6, p);
			ps.setInt(7, id);
			
			int i = ps.executeUpdate();
			if (i == 1) {
				res.sendRedirect("admin/teacher.jsp?smsg=Teacher updated succesfully");
			}else {
				res.sendRedirect("admin/teacher.jsp?fmsg=Teacher not updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("admin/teacher.jsp?fmsg=Something went wrong, please try later");
		}
	}

}
