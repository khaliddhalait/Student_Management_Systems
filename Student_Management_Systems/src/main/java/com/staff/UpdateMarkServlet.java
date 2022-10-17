package com.staff;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;
import com.dao.MarkDAO;

/**
 * Servlet implementation class UpdateMarkServlet
 */
public class UpdateMarkServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			int sid = Integer.parseInt(req.getParameter("sid"));
			int id = Integer.parseInt(req.getParameter("id"));
			String sem = req.getParameter("sem");
			int mark = Integer.parseInt(req.getParameter("mark"));

			Connection conn = DBConnect.getConn();
			PreparedStatement ps = conn.prepareStatement(
					"update mark set smark=? where id=?");
			ps.setInt(1, mark);
			ps.setInt(2, id);
			int i = ps.executeUpdate();
			if(i==1) {
				res.sendRedirect("teacher/view_result.jsp?smsg=Marks updated successfully &&sid="+sid+"&&sem="+sem);
			}else {
				res.sendRedirect("teacher/view_result.jsp?fmsg=Marks not updated &&sid="+sid+"&&sem="+sem);
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("teacher/view_result.jsp?fmsg=Something went wrong, please try later &&sid="+Integer.parseInt(req.getParameter("sid"))+"&&sem="+req.getParameter("sem"));
		}
	}

}
