package com.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;

/**
 * Servlet implementation class DeleteTeacherServlet
 */
public class DeleteTeacherServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));

			Connection conn = DBConnect.getConn();
			PreparedStatement ps = conn.prepareStatement("delete from teacher where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			
			if (i == 1) {
				res.sendRedirect("admin/teacher.jsp?smsg=Teacher deleted succesfully");
			} else {
				res.sendRedirect("admin/teacher.jsp?fmsg=Teacher not deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("admin/teacher.jsp?fmsg=Something went wrong, please try later");
		}
	}

}
