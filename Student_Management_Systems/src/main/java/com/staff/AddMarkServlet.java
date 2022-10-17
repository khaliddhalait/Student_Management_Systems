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
import com.dao.MarkDAO;

/**
 * Servlet implementation class AddMarkServlet
 */
public class AddMarkServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String roll = req.getParameter("roll");
		int sid = Integer.parseInt(req.getParameter("sid"));
		String name = req.getParameter("sname");
		String course = req.getParameter("course");
		String sem = req.getParameter("sem");
		String sub = req.getParameter("subject");
		int mark = Integer.parseInt(req.getParameter("mark"));
		try {

			Connection conn = DBConnect.getConn();
			MarkDAO mdao = new MarkDAO(conn);
			if (mdao.validateAddMarks(sid, sub)) {
				res.sendRedirect("teacher/add_mark.jsp?fmsg=marks added already &&sid=" + sid);
			} else {
				PreparedStatement ps = conn.prepareStatement(
						"insert into mark(stuid,roll,name,course,semestar,subject,smark) values(?,?,?,?,?,?,?)");
				ps.setInt(1, sid);
				ps.setString(2, roll);
				ps.setString(3, name);
				ps.setString(4, course);
				ps.setString(5, sem);
				ps.setString(6, sub);
				ps.setInt(7, mark);
				int i = ps.executeUpdate();
				if (i == 1) {
					res.sendRedirect("teacher/add_mark.jsp?smsg=marks added successfully &&sid=" + sid);
				} else {
					res.sendRedirect("teacher/add_mark.jsp?fmsg=marks not added &&sid=" + sid);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("teacher/add_mark.jsp?fmsg=Something went wrong, please try later &&sid=" + sid);
		}
	}

}
