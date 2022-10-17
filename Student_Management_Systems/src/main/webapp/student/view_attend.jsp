
<!DOCTYPE html>
<%@page import="java.util.List"%>
<%@page import="com.entity.Student"%>
<%@page import="com.dao.StudentDAO"%>
<%@page import="com.entity.Attendance"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.AttendanceDAO"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<%@include file="all_css.jsp"%>
</head>
<body>

<%
	int sid= (int)session.getAttribute("sid");
	StudentDAO sdao= new StudentDAO(DBConnect.getConn());
	Student s = sdao.getStudentById(sid);
%>
<div> <%@include file="navbar.jsp" %></div>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10">
				<div class="container-fluid">
					<center><h3>Attendance</h3></center>
				</div>
				
				<div class="card">
					<div class="card-body">
						
				
               <!--**************************************  card body started *************************** -->
					
					<table class="table table-bordered text-center">
								<thead class="bg-primary text-white">
									<tr>
										<th scope="col">Year</th>
										<th scope="col">Month</th>
										<th scope="col">No Of Days</th>
									</tr>
								</thead>
								<tbody>
									<%
									AttendanceDAO dao = new AttendanceDAO(DBConnect.getConn());
									List<Attendance> list = dao.getAttance(sid);
									for (Attendance a : list) {
									%>
									<tr>
										<td><%=a.getYear()%></td>
										<td><%=a.getMonth()%></td>
										<td><%=a.getDays()%></td>
									</tr>
									<%
									}
									%>


								</tbody>
							</table>
					
				<!--**************************************  card body ended *************************** -->		
				
					
					</div>
				</div>
				
				
			</div>
		</div>
	</div>
	
</body>
</html>