package com.staff;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;

/**
 * Servlet implementation class UpdateAttendanceServlet
 */
public class UpdateAttendanceServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int aid = Integer.parseInt(req.getParameter("aid"));
		int sid = Integer.parseInt(req.getParameter("sid"));
		String sname = req.getParameter("sname");
		String days = req.getParameter("days");
		try {
			Connection conn = DBConnect.getConn();
			PreparedStatement ps = conn.prepareStatement("update attendance set days=? where id=?");
			ps.setString(1, days);
			ps.setInt(2, aid);
			int i = ps.executeUpdate();
			if (i == 1) {
				res.sendRedirect("teacher/view_attend.jsp?smsg=Attendance updated succesfully &&sid=" + sid + "&&sname="
						+ sname);
			} else {
				res.sendRedirect(
						"teacher/view_attend.jsp?fmsg=Attendance not updated &&sid=" + sid + "&&sname=" + sname);
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect(
					"teacher/view_attend.jsp?fmsg=Something went wrong, please try later &&sid=" + sid + "&&sname=" + sname);
		}
	}

}
