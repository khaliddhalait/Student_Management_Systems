
<!DOCTYPE html>
<%@page import="com.entity.Attendance"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.AttendanceDAO"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>blank</title>
<%@include file="all_css.jsp"%>
</head>
<body>
<div> <%@include file="navbar.jsp" %></div>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10">
				<div class="container-fluid">
					<h3>Edit Attendance</h3>
				</div>
				<%
					AttendanceDAO dao = new AttendanceDAO(DBConnect.getConn());
					Attendance a = dao.getAttanceById(Integer.parseInt(request.getParameter("aid")));
					%>
				<div class="card">
					<div class="card-body">
						<form action="../UpdateAttendanceServlet" method="post">

								<input type="hidden" name="aid" value="<%=a.getId()%>">
								<input type="hidden" name="sid" value="<%=a.getStuId()%>">

								<div class="form-row">
									<div class="form-group col-md-4">
										<label>Full Name</label> <input type="text" name="sname"
											class="form-control" value="<%=a.getName()%>" readonly>
									</div>

									<div class="form-group col-md-4">
										<label>Course</label> <input type="text" name="course"
											class="form-control" value="<%=a.getCourse()%>" readonly>
									</div>

									<div class="form-group col-md-4">
										<label>Semestar</label> <input type="text" name="sem"
											class="form-control" value="<%=a.getSemestar()%>" readonly>
									</div>

									<div class="form-group col-md-4">
										<label>Year</label> <input type="text" name="year"
											class="form-control" value="<%=a.getYear()%>" readonly>


									</div>

									<div class="form-group col-md-4">
										<label>Month</label> <input type="text" name="month"
											class="form-control" value="<%=a.getMonth()%>" readonly>
									</div>
									 
									<div class="form-group col-md-4">
										<label>No of Days</label> <input type="number" name="days"
											class="form-control" min="0" max="31" value="<%=a.getDays()%>">
									</div>
								</div>
								<button class="btn btn-success">Submit</button>
							</form>
					
					</div>
				</div>
				
				
			</div>
		</div>
	</div>
	
</body>
</html>