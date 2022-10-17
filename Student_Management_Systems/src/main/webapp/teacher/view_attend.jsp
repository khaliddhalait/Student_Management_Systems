
<%@page import="com.entity.Attendance"%>
<%@page import="com.dao.AttendanceDAO"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Attendance</title>
<%@include file="all_css.jsp"%>
</head>
<body>
	<div>
		<%@include file="navbar.jsp"%></div>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10">
				<div class="container-fluid text-center">
					
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
					</div >
					<h3>
						Attendance of &nbsp<%=request.getParameter("sname")%></h3>
				</div>

				<div class="card">
					<div class="card-body">

						<table class="table table-bordered mt-2 bg-light text-center">
							<thead class="bg-primary text-white">
								<tr>
									<th scope="col">Year</th>
									<th scope="col">Month</th>
									<th scope="col">No Of Days</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								AttendanceDAO adao = new AttendanceDAO(DBConnect.getConn());
								int sid = Integer.parseInt(request.getParameter("sid"));
								List<Attendance> list = adao.getAttance(sid);

								for (Attendance a : list) {
								%>
								<tr>
									<td><%=a.getYear()%></td>
									<td><%=a.getMonth()%></td>
									<td><%=a.getDays()%></td>
									<td><a href="edit_attend.jsp?aid=<%=a.getId()%>"
										class="btn btn-sm btn-success"><i class="fas fa-edit"></i>
											Edit</a> <a
										href="../DeleteAttendanceServlet?aid=<%=a.getId()%>&&sid=<%=a.getStuId()%>&&sname=<%=request.getParameter("sname")%>"
										class="btn btn-sm btn-danger"><i class="fas fa-trash-alt"></i>
											Delete</a></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>


			</div>
		</div>
	</div>

</body>
</html>