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
 * Servlet implementation class AddNoticeServlet
 */
public class AddNoticeServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String name = req.getParameter("name");
			String message = req.getParameter("message");
			
			Connection conn= DBConnect.getConn();
			PreparedStatement ps = conn.prepareStatement("insert into notice(name,message) values(?,?)");
			ps.setString(1, name);
			ps.setString(2, message);

			int i = ps.executeUpdate();
			if (i == 1) {
				res.sendRedirect("admin/notice.jsp?smsg=Notice added successfully");
			}else {
				res.sendRedirect("admin/notice.jsp?fmsg=Notice not added");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("admin/notice.jsp?fmsg=Something went wrong, please try later");
		}
	}
}
