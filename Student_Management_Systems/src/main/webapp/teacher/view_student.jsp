<%@page import="com.entity.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student List</title>
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
					<%
					String cou = request.getParameter("co");
					String sem = request.getParameter("sem");
					String type = request.getParameter("type");
					String name = "";
					if ("attend".equals(type))
						name = "Attendance";
					else if ("view".equals(type))
						name = "Student Details";
					else if ("res".equals(type))
						name = "Result";
					%>
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
					<h3 class="text-center">Course :&nbsp;<%=cou%>&ensp;&ensp;&ensp;&ensp;Semester :&nbsp;<%=sem%>
					</h3><hr><h3 class="text-center"><%=name%></h3>
				</div>

				<div class="card">
					<div class="card-body">
					
					
						<table class="table table-bordered mt-2 bg-light">
							<thead class="bg-primary text-white">
								<tr>
									<th scope="col">Roll</th>
									<th scope="col">Name</th>
									<th scope="col">Course</th>
									<th scope="col">Semestar</th>
									<th scope="col">Gender</th>
									<th scope="col">Email</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>

								<%
								StudentDAO da = new StudentDAO(DBConnect.getConn());
								List<Student> list = da.getData(cou, sem);

								if (list != null) {
									for (Student s : list) {
								%>
								<tr>
									<td><%=s.getRoll()%></td>
									<td><%=s.getName()%></td>
									<td><%=s.getCourse()%></td>
									<td><%=s.getSemestar()%></td>
									<td><%=s.getGender()%></td>
									<td><%=s.getEmail()%></td>
				
									<%
									if (type.equals("attend")) {
									%>
									<td class="text-center"><a
										href="view_attend.jsp?sid=<%=s.getId()%>&&sname=<%=s.getName() %>"
										class="btn btn-sm btn-warning text-white"><i
											class="far fa-eye"></i> View</a>
									  <a
										href="take_atten.jsp?sid=<%=s.getId()%>"
										class="btn btn-sm btn-success text-white"><i
											class="fas fa-address-book"></i> Attend</a> </td>
									<%
									} else if (type.equals("view")) {
									%>
									<td class="text-center">
										</td>
									<%
									} else if (type.equals("res")) {
									%>
									<td><a href="add_mark.jsp?sid=<%=s.getId()%>"
										class="btn btn-sm btn-success"><i
											class="fas fa-plus-square"></i> Add Mark</a> <a
										href="view_result.jsp?sid=<%=s.getId()%>&&sem=<%=s.getSemestar()%>"
										class="btn btn-sm btn-success"><i class="fas fa-eye"></i>
											View</a></td>
									<%
									}
									%>				
								</tr>
								<%
								}
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