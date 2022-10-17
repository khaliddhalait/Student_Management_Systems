package com.student;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.conn.DBConnect;
import com.mysql.cj.xdevapi.PreparableStatement;

/**
 * Servlet implementation class UpdateStudentServlet
 */
public class UpdateStudentServlet extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			int sid = Integer.parseInt(req.getParameter("sid"));
			String name = req.getParameter("name");
			String gen = req.getParameter("gender");
			String dob = req.getParameter("dob");
			String add = req.getParameter("address");
			String password = req.getParameter("password");
			
			Connection conn = DBConnect.getConn();
			PreparedStatement ps= conn.prepareStatement("update student set name=?,gender=?,dob=?,address=? where id=?");
			ps.setString(1, name);
			ps.setString(2, gen);
			ps.setString(3, dob);
			ps.setString(4, add);
			ps.setInt(5, sid);
			
			int i = ps.executeUpdate();
			
			if (i==1) {
				res.sendRedirect("student/view_profile.jsp?smsg=Student profile updated successfully");
			} else {
				res.sendRedirect("student/view_profile.jsp?fmsg=Student profile not updated");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("student/view_profile.jsp?fmsg=Something went wrong, please try later");
		}
	}

}
