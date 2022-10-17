package com.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;
import com.dao.NoticeDAO;

/**
 * Servlet implementation class DeleteNoticeServlet
 */
public class DeleteNoticeServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(req.getParameter("id"));
			Connection conn = DBConnect.getConn();
			NoticeDAO ndao = new NoticeDAO(conn);
			PreparedStatement ps = conn.prepareStatement("delete from notice where id=?");
			ps.setInt(1, id);
			int i = ps.executeUpdate();
			if (i == 1) {
				res.sendRedirect("admin/view_notice.jsp?smsg=notice deleted");
			} else {
				res.sendRedirect("admin/view_notice.jsp?fmsg=notice not deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("admin/view_notice.jsp?fmsg=Something went wrong, please try later");
		}
	}
}
