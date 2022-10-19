package com.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Base64;
import java.util.Base64.Encoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		res.setContentType("text/html");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		Encoder encoder = Base64.getEncoder();
		password = encoder.encodeToString(password.getBytes());

		if (email.equals("admin@gmail.com") && password.equals("YWRtaW4xMjM=")) {
			HttpSession hs = req.getSession();
			hs.setAttribute("email", email);
			hs.setAttribute("adname", "admin");
			res.sendRedirect("admin/home.jsp");
		} else {
			res.sendRedirect("alogin.jsp?fmsg=Please enter correct email id and password");
		}

	}

}
