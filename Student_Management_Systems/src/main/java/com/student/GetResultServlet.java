package com.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;
import com.dao.MarkDAO;
import com.entity.Mark;

/**
 * Servlet implementation class GetResultServlet
 */
public class GetResultServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String sid = req.getParameter("sid");
		String sem = req.getParameter("semestar");
		try {
			MarkDAO mdao = new MarkDAO(DBConnect.getConn());
			Mark m = mdao.getMarkByID(sid, sem);

			if (m == null) {
				res.sendRedirect("student/result.jsp?fmsg=result not found for semestar " + sem);
			} else {
				res.sendRedirect("student/view_result.jsp?sid=" + sid + "&&semestar=" + sem);
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("student/result.jsp?fmsg=Something went wrong, please try later " + sem);
		}
	}

}
