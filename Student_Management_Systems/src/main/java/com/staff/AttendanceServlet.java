package com.staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;
import com.dao.AttendanceDAO;

/**
 * Servlet implementation class AttendanceServlet
 */
public class AttendanceServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int sid = Integer.parseInt(req.getParameter("sid"));
		String name = req.getParameter("sname");
		String course = req.getParameter("course");
		String sem = req.getParameter("sem");
		String year = req.getParameter("year");
		String month = req.getParameter("month");
		String days = req.getParameter("days");
		
		try {
			Connection conn = DBConnect.getConn();
			AttendanceDAO adao= new AttendanceDAO(conn);
			if(adao.validateAddAttendance(sid, year, month)) {
				res.sendRedirect("teacher/view_student.jsp?fmsg=Attendance added already" + "&&co=" + course
						+ "&&sem=" + sem + "&&type=" + "attend");
			}else {
				PreparedStatement ps = conn.prepareStatement(
						"insert into attendance(sid,name,course,semestar,year,month,days) values(?,?,?,?,?,?,?)");
				ps.setInt(1, sid);
				ps.setString(2, name);
				ps.setString(3, course);
				ps.setString(4, sem);
				ps.setString(5, year);
				ps.setString(6, month);
				ps.setString(7, days);
				int i = ps.executeUpdate();
				if (i==1) {
					res.sendRedirect("teacher/view_student.jsp?smsg=Attendance added succesfully" + "&&co=" + course
							+ "&&sem=" + sem + "&&type=" + "attend");
				} else {
					res.sendRedirect("teacher/view_student.jsp?fmsg=Attendance not added" + "&&co=" + course
							+ "&&sem=" + sem + "&&type=" + "attend");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("teacher/view_student.jsp?fmsg=Something went wrong, please try later" + "&&co=" + course
					+ "&&sem=" + sem + "&&type=" + "attend");
		}
	}

}
