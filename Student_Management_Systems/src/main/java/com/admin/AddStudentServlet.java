package com.admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;
import com.dao.StudentDAO;
import com.entity.Student;

/**
 * Servlet implementation class AddStudentServlet
 */
public class AddStudentServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String roll = req.getParameter("roll");
		String name = req.getParameter("name");
		String gen = req.getParameter("gender");
		String dob = req.getParameter("dob");
		String add = req.getParameter("address");
		String course = req.getParameter("course");
		String sem = req.getParameter("sem");
		String em = req.getParameter("email");
		String password = req.getParameter("password");
		Encoder encoder = Base64.getEncoder();
		password = encoder.encodeToString(password.getBytes());

		try {
			Connection conn = DBConnect.getConn();
			StudentDAO sdao = new StudentDAO(conn);
			if (sdao.validateEmail(em)) {
				res.sendRedirect("admin/add_info.jsp?fmsg=Student with email id already added");
			} else {
				PreparedStatement ps = conn.prepareStatement(
						"insert into student(roll,name,gender,dob,address,course,semestar,email,password) values(?,?,?,?,?,?,?,?,?)");
				ps.setString(1, roll);
				ps.setString(2, name);
				ps.setString(3, gen);
				ps.setString(4, dob);
				ps.setString(5, add);
				ps.setString(6, course);
				ps.setString(7, sem);
				ps.setString(8, em);
				ps.setString(9, password);

				int i = ps.executeUpdate();
				if (i == 1) {
					res.sendRedirect("admin/add_info.jsp?smsg=Student added succesfully");
				} else {
					res.sendRedirect("admin/add_info.jsp?fmsg=Student not added");
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("admin/add_info.jsp?fmsg=Something went wrong, please try later");
		}
	}

}
