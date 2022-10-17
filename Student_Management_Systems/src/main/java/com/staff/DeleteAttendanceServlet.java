package com.staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;

/**
 * Servlet implementation class DeleteAttendanceServlet
 */
public class DeleteAttendanceServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int aid = Integer.parseInt(req.getParameter("aid"));
		int sid = Integer.parseInt(req.getParameter("sid"));
		String sname = req.getParameter("sname");
		try {
			Connection conn = DBConnect.getConn();
			PreparedStatement ps = conn.prepareStatement("delete from attendance where id=?");
			ps.setInt(1, aid);
			int i = ps.executeUpdate();
			if (i == 1) {
				res.sendRedirect(
						"teacher/view_attend.jsp?smsg=Attendance deleted succesfully &&sid=" + sid + "&&sname=" + sname);
			} else {
				res.sendRedirect(
						"teacher/view_attend.jsp?fmsg=Attendance not deleted &&sid=" + sid + "&&sname=" + sname);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect(
					"teacher/view_attend.jsp?fmsg=Something went wrong, please try later &&sid=" + sid + "&&sname=" + sname);
		}

	}
}
