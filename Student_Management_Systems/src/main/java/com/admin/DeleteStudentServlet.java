package com.admin;

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

/**
 * Servlet implementation class DeleteStudentServlet
 */
public class DeleteStudentServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {
			int id = Integer.parseInt(req.getParameter("id"));
			String course = req.getParameter("co");
			String sem = req.getParameter("sem");
			Connection conn = DBConnect.getConn();
			PreparedStatement ps = conn.prepareStatement("delete from student where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				res.sendRedirect("admin/view_student.jsp?smsg=Student deleted succesfully" + "&&co=" + course + "&&sem="
						+ sem + "&&type=" + "view");
			} else {
				res.sendRedirect("admin/view_student.jsp?fmsg=Student not deleted" + "&&co=" + course + "&&sem=" + sem
						+ "&&type=" + "view");
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("admin/view_student.jsp?fmsg=Something went wrong, please delete all data related to student first and try again" + "&&co=" + req.getParameter("co") + "&&sem=" + req.getParameter("sem")
					+ "&&type=" + "view");
		}
	}
}
