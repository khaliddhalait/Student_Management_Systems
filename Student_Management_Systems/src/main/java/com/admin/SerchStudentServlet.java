package com.admin;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SerchStudentServlet
 */
public class SerchStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String course = req.getParameter("course");
			String sem = req.getParameter("semestar");
			String viewtype = req.getParameter("viewtype");
			if (course != null && sem != null && viewtype != null) {
				res.sendRedirect("admin/view_student.jsp?co=" + course + "&&sem=" + sem + "&&type=" + viewtype);
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("admin/view_student.jsp?co=" + req.getParameter("course") + "&&sem=" + req.getParameter("semestar") + "&&type=" + req.getParameter("viewtype"));
		}
	}

}
