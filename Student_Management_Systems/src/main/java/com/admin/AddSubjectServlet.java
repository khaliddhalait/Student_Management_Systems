package com.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;
import com.dao.SubjectDAO;

/**
 * Servlet implementation class AddSubjectServlet
 */
public class AddSubjectServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String c = req.getParameter("course");
			String sem = req.getParameter("sem");
			String s = req.getParameter("subject");

			Connection conn = DBConnect.getConn();
			SubjectDAO sdao = new SubjectDAO(conn);
			if (sdao.validateAddSubject(s)) {
				res.sendRedirect("admin/add_info.jsp?fmsg=subject added already");
			} else {
				PreparedStatement ps = conn
						.prepareStatement("insert into subject(course_name,semestar,subject) values(?,?,?)");
				ps.setString(1, c);
				ps.setString(2, sem);
				ps.setString(3, s);

				int i = ps.executeUpdate();
				if (i == 1) {
					res.sendRedirect("admin/add_info.jsp?smsg=Subject added succesfully");
				} else {
					res.sendRedirect("admin/add_info.jsp?fmsg=Subject not added");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("admin/add_info.jsp?fmsg=Something went wrong, please try later");
		}
	}
}
