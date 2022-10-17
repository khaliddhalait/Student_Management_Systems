<%@page  contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student: Home</title>
<%@include file="all_css.jsp"%>
<style type="text/css">
</style>
</head>
<body>
	


	<%@include file="navbar.jsp"%>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10 ">


				<h3 class="text-center text-primary">Welcome <%=(String)session.getAttribute("sname") %></h3>

				
				<hr>




			</div>


		</div>
	</div>
</body>
</html>