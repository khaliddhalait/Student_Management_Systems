<%@page import="com.entity.Mark"%>
<%@page import="com.dao.MarkDAO"%>
<%@page import="com.entity.Subject"%>
<%@page import="com.dao.StudentDAO"%>
<%@page import="com.entity.Student"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.entity.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.CourseDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Student-Details</title>
<%@include file="all_css.jsp"%>
<link href="admin/style.css" rel="stylesheet">
</head>
<body class="bg-card-color">
<div> <%@include file="navbar.jsp" %></div>

	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>
			<%
				int mid=Integer.parseInt(request.getParameter("id"));
			int sid=Integer.parseInt(request.getParameter("sid"));
			int mark=Integer.parseInt(request.getParameter("mark"));
			String sem=request.getParameter("sem");
			
			MarkDAO mdao= new MarkDAO(DBConnect.getConn());
			Mark m=mdao.getMarkByID(mid); 
			%>

			<div class="col-md-10">
				<div class="container-fluid">
					<h3 class="text-center text-success">Student Details</h3>

					<div class="card">
						<div class="card-body">
							<form  action="../UpdateMarkServlet" method="post">
								<div class="form-row">
									<div class="form-group col-md-4">
										Mark :<input type="number" class="form-control"
											name="mark" min="0" max="100" value=<%=m.getMark() %>>
									</div>
									<input type="hidden" name="id" value="<%=m.getId()%>"><input type="hidden" name="sid" value="<%=m.getStuid() %>">
									<input type="hidden" name="sem" value="<%=m.getSemestar() %>"></div>
								<button class="btn btn-success col-2">Update</button>
								</div>
							</form>

						</div>
					</div>




				</div>
			</div>

		</div>
	</div>
</body>
</html>