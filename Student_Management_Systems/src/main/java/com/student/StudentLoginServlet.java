package com.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;

/**
 * Servlet implementation class StudentLoginServlet
 */
@WebServlet("/student_login")
public class StudentLoginServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			Encoder encoder = Base64.getEncoder();
			password = encoder.encodeToString(password.getBytes());

			HttpSession hs = req.getSession();
			Connection conn = DBConnect.getConn();
			PreparedStatement ps = conn.prepareStatement("select * from student where email=? and password=?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int sid = rs.getInt(1);
				hs.setAttribute("sid", sid);
				hs.setAttribute("semail", email);
				String sname = rs.getString(3);
				hs.setAttribute("sname", sname);
				String roll = rs.getString(2);
				hs.setAttribute("roll", roll);
				res.sendRedirect("student/home.jsp");
			} else {
				res.sendRedirect("slogin.jsp?fmsg=Please enter correct email id and password");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("slogin.jsp?fmsg=Something went wrong, please try later");
		}
	}

}
