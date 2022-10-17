
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student Login</title>
<%@include file="all_component/allCss_file.jsp"%>
</head>
<body style="background-color: #DCDCDC;">
	<%@include file="all_component/navbar.jsp"%>

	<div class="container-fluid">
		<div class="row p-2">
			<div class="col-md-4 offset-md-4">
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
						<form class="needs-validation" method="post"
							action="student_login">
							<h3 class="text-center">Student Login</h3>
							<div class="form-group">
								<label for="uname">Email:</label> <input type="text"
									class="form-control" id="uname" placeholder="Enter username"
									name="email" required>
								<div class="valid-feedback"></div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<div class="form-group">
								<label for="pwd">Password:</label> <input type="password"
									class="form-control" id="pwd" placeholder="Enter password"
									name="password" required>
									
								<div class="valid-feedback"></div>
								<div class="invalid-feedback">Please fill out this field.</div>
							</div>
							<input type="hidden" value="admin" name="type">
							<div class="text-center">
								<button type="submit" class="btn btn-primary btn-lg">Submit</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>


	<div style="margin-top: 80px;">
		<%@include file="all_component/footer.jsp"%>
	</div>
</body>
</html>