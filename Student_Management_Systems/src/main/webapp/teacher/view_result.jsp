<%@page import="com.entity.Mark"%>
<%@page import="java.util.List"%>
<%@page import="com.entity.Student"%>
<%@page import="com.dao.StudentDAO"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.MarkDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher: View Result</title>

<%@include file="all_css.jsp"%>
</head>
<body class="bg-card-color">

	<%@include file="navbar.jsp"%>

	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10">
				<div class="container-fluid">
					<div class="col-md-8 offset-md-2">

						<%
						int sid = Integer.parseInt(request.getParameter("sid"));
						String sem = request.getParameter("sem");
						MarkDAO dao = new MarkDAO(DBConnect.getConn());
						StudentDAO sdao = new StudentDAO(DBConnect.getConn());
						Student s = sdao.getStudentById(sid);
						List<Mark> list = dao.getMark(sid, sem);
						%>
						<br>
						<div class="card">
							<div class="card-body">
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
								<h4 class="text-center">Result</h4>
								<hr>
								<div class="mt-2">
									<h6>
										Name :
										<%=s.getName()%></h6>
									<h6>
										Roll No :
										<%=s.getRoll()%></h6>
									<h6>
										Course :
										<%=s.getCourse()%></h6>
									<h6>
										Semestar :
										<%=s.getSemestar()%></h6>
								</div>
								<hr>
								<div class="mt-2">
									<table class="table table-bordered text-center">
										<thead class="bg-light">
											<tr>
												<th>Subject</th>
												<th>Total Mark</th>
												<th>Mark</th>
												<th>Action</th>
											</tr>
										</thead>
										<tbody>
											<%
											int tmark = 0;
											for (Mark ma : list) {
												tmark += ma.getMark();
											%>
											<tr>
												<td><%=ma.getSubject()%></td>
												<td>100</td>
												<td><%=ma.getMark()%></td>
												<td><a class="btn btn-success"
															href="edit_mark.jsp?id=<%=ma.getId()%>&&sem=<%=s.getSemestar()%>&&sid=<%=ma.getStuid()%>&&mark=<%=ma.getMark() %>"
															role="button">Edit</a>
														<a class="btn btn-danger"
															href="../DeleteMarkServlet?id=<%=ma.getId()%>&&sem=<%=s.getSemestar()%>&&sid=<%=ma.getStuid()%>"
															role="button">Delete</a>
												</td>
											</tr>
											<%
											}
											%>
											<tr>
												<th>Total Mark</th>
												<th>
													<%
													int toma = list.size() * 100;
													out.print(toma);
													%>
												</th>
												<th><%=tmark%></th>
											</tr>

											<tr>
												<th>Percentage</th>
												<th colspan="2">
													<%
													float d = ((float) tmark / (float) toma) * 100;
													out.print((int) d);
													%>%
												</th>
											</tr>
											<tr>
												<th>Division</th>
												<th colspan="2">
													<%
													boolean b = true;
													for (Mark ma : list) {
														if (ma.getMark() < 40) {
															b = false;
														}
													}
													if (b) {
														if ((int) d >= 60)
															out.print("1st Divison");
														else if ((int) d < 60 && (int) d >= 50)
															out.print("2nd Divison");
														else if ((int) d < 50 && (int) d >= 40)
															out.print("3rd Divison");
														else
															out.print("Fail");
													} else {
														out.print("Fail");
													}
													%>
												</th>
											</tr>

										</tbody>
									</table>
								</div>


							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	>
</body>
</html>