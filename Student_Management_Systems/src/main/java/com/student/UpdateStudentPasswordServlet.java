package com.student;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;
import com.dao.StudentDAO;

/**
 * Servlet implementation class UpdateStudentPasswordServlet
 */
public class UpdateStudentPasswordServlet extends HttpServlet {
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
			
			int sid= Integer.parseInt(req.getParameter("sid"));

			Connection conn=DBConnect.getConn();
			StudentDAO dao= new StudentDAO(conn);
			boolean b=dao.validatePassword(cpassword, sid);
			if (b) {
				if (npassword.equals(cnfpassword)) {
					try {
						PreparedStatement ps = conn.prepareStatement("update student set password=? where id=?");
						ps.setString(1, npassword);
						ps.setInt(2, sid);
						int i= ps.executeUpdate();
						
						if (i==1) {
							res.sendRedirect("student/view_profile.jsp?smsg=password updated");
						}else {
							res.sendRedirect("student/view_profile.jsp?fmsg=password not updated");
						}
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				} else {
					res.sendRedirect("student/view_profile.jsp?fmsg=new and confirm password missmatch...");
				}
			}else {
				res.sendRedirect("student/view_profile.jsp?fmsg=wrong current password");
			}
		} catch (Exception e) {
			e.printStackTrace();
			res.sendRedirect("student/view_profile.jsp?fmsg=Something went wrong, please try later");
		}
	}

}
