package com.staff;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.entity.Teacher;

/**
 * Servlet implementation class TeacherLoginServlet
 */
public class TeacherLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		Encoder encoder = Base64.getEncoder();
		password = encoder.encodeToString(password.getBytes());
		HttpSession hs = req.getSession();
		
		try {
			Connection conn = DBConnect.getConn();
			PreparedStatement ps = conn.prepareStatement("select * from teacher where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				hs.setAttribute("temail", email);
				String tname = rs.getString(2);
				hs.setAttribute("tname", tname);
				int id = rs.getInt(1);
				hs.setAttribute("tid", id);
				res.sendRedirect("teacher/home.jsp");
			} else {
				res.sendRedirect("tlogin.jsp?fmsg=Please enter correct email id and password");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("tlogin.jsp?fmsg=Something went wrong, please try later");
		}
	}

}
