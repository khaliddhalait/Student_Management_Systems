package com.staff;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;

/**
 * Servlet implementation class DeleteMarkServlet
 */
public class DeleteMarkServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String sem=req.getParameter("sem");
		int sid=Integer.parseInt(req.getParameter("sid"));
		try {
			Connection conn= DBConnect.getConn();
			PreparedStatement ps= conn.prepareStatement("delete from mark where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if(i==1) {
				res.sendRedirect("teacher/view_result.jsp?smsg=Marks deleted successfully &&sid="+sid+"&&sem="+sem);
			}else {
				res.sendRedirect("teacher/view_result.jsp?fmsg=Marks not deleted &&sid="+sid+"&&sem="+sem);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("teacher/view_result.jsp?fmsg=Something went wrong, please try later &&sid="+sid+"&&sem="+sem);
		}
	}
}
