<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<nav class="navbar navbar-expand-lg navbar-dark bg-color sticky-top">
	<a class="navbar-brand" href="#">Student Management System</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarSupportedContent"
		aria-controls="navbarSupportedContent" aria-expanded="false"
		aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">

		</ul>
		<form class="form-inline my-2 my-lg-0">
			<!-- Example single danger button -->
<%
						String sname = (String) session.getAttribute("sname");
String roll = (String) session.getAttribute("roll");
						%>

			
				<div class="btn-group">
					<button type="button"
						class="btn btn-light text-dark "
						 aria-haspopup="true" aria-expanded="false">
						<i class="fas fa-user-circle"></i> <%=sname%>
					</button>
					&nbsp;
					<button type="button"
						class="btn btn-light text-dark "
						 aria-haspopup="true" aria-expanded="false">
						<i class="fas fa-user-circle"></i> <%=roll%>
					</button>
					
				</div>
				<a href="../StudentLogoutServlet" class="btn btn-light my-2 my-sm-0 ml-2" type="submit">
					<i class="fas fa-sign-out-alt"></i>Logout
				</a>

		

		</form>
	</div>
</nav>
<div><%if((session.getAttribute("sname"))==null || (session.getAttribute("sid"))==null || (session.getAttribute("semail")==null) || (session.getAttribute("roll")==null)){
		response.sendRedirect("../slogin.jsp?msg=Please login first");	
	}%><div>

