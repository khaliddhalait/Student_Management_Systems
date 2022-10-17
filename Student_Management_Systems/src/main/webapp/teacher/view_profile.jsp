<%@page import="com.conn.DBConnect"%>
<%@page import="com.entity.Teacher"%>
<%@page import="com.dao.TeacherDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit teacher</title>
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
			<%
			TeacherDAO tdao = new TeacherDAO(DBConnect.getConn());
			int i = (int) session.getAttribute("tid");
			Teacher t = tdao.getTeacherByid(i);
			%>

			<div class="col-md-10  p-5">

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
						<div class="card-title">
							<h3 class="text-center">Profile</h3>
						</div>
						<hr>
						<div>
							<input type="hidden" value="<%=t.getId()%>" name="id">
							<table class="table table-bordered text-center">
								<thead class="bg-light">
									<tr>
										<th colspan="2">Profile of <%=t.getName()%></th>
									</tr>
								</thead>
								<tbody>

									<tr>
										<td>Name</td>
										<td><%=t.getName()%></td>
									</tr>
									<tr>
										<td>Gender</td>
										<td><%=t.getGender()%></td>
									</tr>
									<tr>
										<td>Birth date</td>
										<td><%=t.getDob()%></td>
									</tr>
									<tr>
										<td>Qualification</td>
										<td><%=t.getQualification()%></td>
									</tr>
									<tr>
										<td>Email</td>
										<td><%=t.getEmail()%></td>
									</tr>

								</tbody>
							</table>

						</div>
						<!-- Button trigger modal -->

						<div>
							<button class="btn btn-success" data-toggle="modal"
								data-target="#updatepassword">Update Password</button>


							<!-- Modal -->
							<div class="modal fade" id="updatepassword" tabindex="-1"
								role="dialog" aria-labelledby="exampleModalLabel"
								aria-hidden="true">
								<div class="modal-dialog" role="document">
									<div class="modal-content">
										<div class="modal-header">
											<h5 class="modal-title" id="exampleModalLabel">Update
												Passsword</h5>
											<button type="button" class="close" data-dismiss="modal"
												aria-label="Close">
												<span aria-hidden="true">&times;</span>
											</button>
										</div>
										<div class="modal-body bg-card-color">
											<div class="card">
												<div class="card-body">
													<form id="cpform" onsubmit="return validatePassword()"
													 action="../UpdateTeacherProfileServlet" method="post">
														<div class="form-group">
															<label for="">Enter current Password</label> <input
																type="password" name="cpassword" required id=""
																class="form-control"> <label for="">Enter
																new Password</label> <input type="password" name="npassword"
																required id="" class="form-control"> <label
																for="">Enter confirm Password</label> <input
																type="password" name="cnfpassword" required id=""
																class="form-control"> <input type="hidden"
																value="<%=t.getId()%>" name="tid"> <br>
															<button class="btn btn-success"
																onClick="validatePassword()">Update password</button>
														</div>
													</form>



												</div>
											</div>
										</div>
										<div class="modal-footer">
											<button type="button" class="btn btn-secondary"
												data-dismiss="modal">Close</button>
										</div>
									</div>
								</div>
							</div>
							<!-- Button trigger modal end -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<script type="text/javascript">
	function validatePassword() {
	    var cpassword = document.forms["cpform"]["cpassword"].value;
	    var npassword = document.forms["cpform"]["npassword"].value;
	    var cnfpassword = document.forms["cpform"]["cnfpassword"].value;
	    if (npassword !== cnfpassword) {
	        alert("confirm password missmatch");
	        return false;
	    }

	    if (cpassword.length < 8 || npassword.length < 8) {
	        alert("password lenght should not be less than 8");
	        return false;
	    }
	    return true;
	}
	</script>
</body>
</html>