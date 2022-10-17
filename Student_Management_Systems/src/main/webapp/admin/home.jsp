<%@page import="com.dao.TeacherDAO"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin home page</title>
<%@include file="all_css.jsp"%>
</head>
<body style="background-color: #f0f1f2;">

	<%@include file="navbar.jsp"%>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10 ">

				<h3 class="text-center text-primary">Welcome Admin</h3>

				<hr>


				<div class="row p-4">
					<div class="col-md-6">
						<div class="card bg-success text-white">
							<div class="card-body text-center">
								<i class="fas fa-chalkboard-teacher fa-2x"></i>
								<h4>Teacher</h4>
								<%
								TeacherDAO tdao = new TeacherDAO(DBConnect.getConn());
								int ct = tdao.teacherCount();
								%>
								<h5><%=ct%></h5>

							</div>
						</div>
					</div>

					<div class="col-md-6 ">
						<div class="card bg-primary text-white">
							<div class="card-body text-center">
								<i class="fas fa-users fa-2x"></i>
								<h4>Student</h4>
								<%
								StudentDAO sdao = new StudentDAO(DBConnect.getConn());
								int cs = sdao.studentCount();
								%>
								<h5><%=cs%></h5>
							</div>
						</div>
					</div>


				</div>
			</div>


		</div>
	</div>
</body>
</html>