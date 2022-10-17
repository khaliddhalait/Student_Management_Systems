package com.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;
import com.dao.CourseDAO;

/**
 * Servlet implementation class CourseAddServlet
 */
public class CourseAddServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		PrintWriter pw = res.getWriter();
		String course=req.getParameter("course");
		
		CourseDAO cdao = new CourseDAO(DBConnect.getConn());
		if(cdao.validateAddCourse(course)) {
			res.sendRedirect("admin/add_info.jsp?fmsg=course added already");
		}else {
			boolean f = cdao.addCourse(course);
			if(f)
			{
				res.sendRedirect("admin/add_info.jsp?smsg=course added successfully");
			}else {
				res.sendRedirect("admin/add_info.jsp?fmsg=course not added");
			}
		}
		
	}

}
