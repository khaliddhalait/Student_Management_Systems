
<!DOCTYPE html>
<%@page import="com.entity.Student"%>
<%@page import="com.dao.StudentDAO"%>
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

	<%
	int sid = (int) session.getAttribute("sid");
	StudentDAO sdao = new StudentDAO(DBConnect.getConn());
	Student s = sdao.getStudentById(sid);
	%>
	<div>
		<%@include file="navbar.jsp"%></div>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10">
				<div class="container-fluid">
					<div>
						<%
						String smsg = request.getParameter("smsg");
						String fmsg = request.getParameter("fmsg");
						if (smsg != null) {
							out.println("<p class='text-center alert alert-success'>" + smsg + "</p>");
						} else if (fmsg != null) {
							out.println("<p class='text-center alert alert-danger'>" + fmsg + "</p>");
						}
						%>
					</div>
					<br><center>
					<h3>Profile</h3></center>
				</div>

				<div class="card">
					<div class="card-body">
						<table class="table table-bordered text-center">
								<thead class="bg-light">
									<tr>
										<th colspan="2">Profile of <%=s.getName()%></th>
									</tr>
								</thead>
								<tbody>

									<tr>
										<td>Name</td>
										<td><%=s.getName()%></td>
									</tr>
									<tr>
										<td>PRN</td>
										<td><%=s.getRoll()%></td>
									</tr>
									<tr>
										<td>Gender</td>
										<td><%=s.getGender()%></td>
									</tr>
									<tr>
										<td>Birth date</td>
										<td><%=s.getDob()%></td>
									</tr>
									<tr>
										<td>Course</td>
										<td><%=s.getCourse()%></td>
									</tr>
									<tr>
										<td>Semestar</td>
										<td><%=s.getSemestar()%></td>
									</tr>
									<tr>
										<td>Email</td>
										<td><%=s.getEmail()%></td>
									</tr>
									<tr>
										<td>Address</td>
										<td><%=s.getAddress()%></td>
									</tr>

								</tbody>
							</table>

						<!--**************************************  card body started *************************** -->


							
						</div>

						<!--**************************************  card body ended *************************** -->

					</div>
				</div>


			</div>
		</div>
	</div>

</body>
</html>