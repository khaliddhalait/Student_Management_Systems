package com.staff;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TeacherSerchStudentServlet
 */
public class TeacherSerchStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String course = req.getParameter("course");
		String sem = req.getParameter("semestar");
		String viewtype = req.getParameter("viewtype");
		try {
			if (course != null && sem != null && viewtype != null) {
				res.sendRedirect("teacher/view_student.jsp?co=" + course + "&&sem=" + sem + "&&type=" + viewtype);
			}else {
				res.sendRedirect("teacher/student.jsp?co=" + course + "&&sem=" + sem + "&&type=" + viewtype);
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("teacher/student.jsp?co=" + course + "&&sem=" + sem + "&&type=" + viewtype);
		}
	}

}
