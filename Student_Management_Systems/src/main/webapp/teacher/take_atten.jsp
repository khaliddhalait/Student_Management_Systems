<%@page import="com.entity.Student"%>
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
<title>Take Attendance</title>
<%@include file="all_css.jsp"%>

</head>
<body class="bg-card-color">
	<div>
		<%@include file="navbar.jsp"%></div>

	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>


			<div class="col-md-10">
				<div class="container-fluid">
					<h3 class="text-center">Take Attendance</h3>
					<div class="card">
						<div class="card-body">
							<%
							StudentDAO dao = new StudentDAO(DBConnect.getConn());
							Student s = dao.getStudentById(Integer.parseInt(request.getParameter("sid")));
							%>

							<form action="../AttendanceServlet" method="post">

								<input type="hidden" name="sid" value="<%=s.getId()%>"> 

								<div class="form-row">
									<div class="form-group col-md-4">
										<label>Full Name</label> <input type="text" name="sname"
											class="form-control" value="<%=s.getName()%>" readonly>
									</div>

									<div class="form-group col-md-4">
										<label>Course</label> <input type="text" name="course"
											class="form-control" value="<%=s.getCourse()%>" readonly>
									</div>

									<div class="form-group col-md-4">
										<label>Semestar</label> <input type="text" name="sem"
											class="form-control" value="<%=s.getSemestar()%>" readonly>
									</div>

									<div class="form-group col-md-4">
										<label>Year</label> <select class="custom-select " id=""
											name="year">
											<option value="2022">2022</option>
											<option value="2021">2021</option>
											<option value="2020">2020</option>
											<option value="2019">2019</option>
											<option value="2018">2018</option>
										</select>


									</div>

									<div class="form-group col-md-4">
										<label>Month</label> 
										 <select class="custom-select "
											id="" name="month">
											<option value="Jan">January</option>
											<option value="Feb">February</option>
											<option value="Mar">March</option>
											<option value="Apr">April</option>
											<option value="May">May</option>
											<option value="Jun">June</option>
											<option value="Jul">July</option>
											<option value="Aug">August</option>
											<option value="Sep">September</option>
											<option value="Oct">October</option>
											<option value="Nov">November</option>
											<option value="Dec">December</option>
										</select>
									</div>
									
									<div class="form-group col-md-4">
										<label>No of Days</label> <input type="number" name="days" min="0" max="31" 
											class="form-control">
									</div>
								</div>
								<button class="btn btn-success">Submit</button>
							</form>
						</div>
					</div>


				</div>
			</div>
		</div>
	</div>