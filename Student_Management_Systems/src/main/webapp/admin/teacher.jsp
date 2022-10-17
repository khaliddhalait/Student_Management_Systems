<%@page import="java.util.Iterator"%>
<%@page import="com.entity.Teacher"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.TeacherDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Teacher-Details</title>
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

				<div class="container-fluid">
					
					<div class="card">
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
						<h3 class="text-center text-success">Staff Details</h3>
						<div class="card-header">Staff Details</div>

						<div class="card-body">

							<table class="table table-bordered mt-2 table-striped">
								<thead class="bg-primary text-white">
									<tr>
										<th scope="col">Name</th>
										<th scope="col">Email</th>
										<th scope="col">DOB</th>
										<th scope="col">Gender</th>
										<th scope="col">Qualification</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody>
									<%
									TeacherDAO dao = new TeacherDAO(DBConnect.getConn());
									List<Teacher> teach = dao.getTeacher();
									//for (Teacher t : teach) {
									Iterator i = teach.iterator();
									while (i.hasNext()) {
										Teacher t = (Teacher) i.next();
									%>
									<tr>
										<td><%=t.getName()%></td>
										<td><%=t.getEmail()%></td>
										<td><%=t.getDob()%></td>
										<td><%=t.getGender()%></td>
										<td><%=t.getQualification()%></td>
										<td class="text-center"><a
											href="edit_teacher.jsp?id=<%=t.getId()%>"
											class="btn btn-sm btn-success text-white"><i
												class="fas fa-edit"></i> Edit</a> <a
											href="../DeleteTeacherServlet?id=<%=t.getId()%>"
											class="btn btn-sm btn-danger text-white"><i
												class="fas fa-trash-alt"></i> Delete</a></td>
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

	</div>
</body>
</html>