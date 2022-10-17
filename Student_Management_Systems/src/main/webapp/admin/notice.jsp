<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin: Notice-Details</title>
<%@include file="all_css.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>

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
					<h3 class="text-center text-success">Notice</h3>
					<hr>
					<div class="col-md-6 offset-md-3">
						<form action="../AddNoticeServlet" method="post">
						<input type="hidden" name="name" value="Admin">
						<div class="form-group">
							<label>Enter Notice</label>
							<textarea rows="5" cols="" class="form-control" name="message" required></textarea>
						</div>
						<br>
						<center><button class="btn btn-success">Publish</button></center>
					</form>
					<div><br><center>
						<a class="btn btn-success" href="view_notice.jsp" role="button">View All</a></center>
					</div>
					</div>
<br>
					
				</div>
			</div>

		</div>
	</div>
</body>
</html>