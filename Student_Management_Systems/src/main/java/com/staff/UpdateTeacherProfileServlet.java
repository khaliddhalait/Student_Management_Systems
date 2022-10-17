package com.staff;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.admin.UpdateTeacherServlet;
import com.conn.DBConnect;
import com.dao.TeacherDAO;

/**
 * Servlet implementation class UpdateTeacherProfileServlet
 */
public class UpdateTeacherProfileServlet extends UpdateTeacherServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		try {
			String cpassword = req.getParameter("cpassword");
			Encoder encoder = Base64.getEncoder();
			cpassword = encoder.encodeToString(cpassword.getBytes());
			
			String npassword = req.getParameter("npassword");
			npassword = encoder.encodeToString(npassword.getBytes());
			
			String cnfpassword = req.getParameter("cnfpassword");
			cnfpassword = encoder.encodeToString(cnfpassword.getBytes());
			
			int tid= Integer.parseInt(req.getParameter("tid"));
			Connection conn=DBConnect.getConn();
			TeacherDAO tdao = new TeacherDAO(conn);
			
			boolean b=tdao.validatePassword(cpassword, tid);
			if (b) {
				if (npassword.equals(cnfpassword)) {
					try {
						PreparedStatement ps = conn.prepareStatement("update teacher set password=? where id=?");
						ps.setString(1, npassword);
						ps.setInt(2, tid);
						int i= ps.executeUpdate();
						
						if (i==1) {
							res.sendRedirect("teacher/view_profile.jsp?smsg=password updated");
						}else {
							res.sendRedirect("teacher/view_profile.jsp?fmsg=password not updated");
						}
					} catch (Exception e) {
						e.printStackTrace();
						res.sendRedirect("teacher/view_profile.jsp?fmsg=server error, please try later");
					}
					
				} else {
					res.sendRedirect("teacher/view_profile.jsp?fmsg=new and confirm password missmatch...");
				}
			}else {
				res.sendRedirect("teacher/view_profile.jsp?fmsg=wrong current password");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("teacher/view_profile.jsp?fmsg=Something went wrong, please try later");
		}
	}

}
