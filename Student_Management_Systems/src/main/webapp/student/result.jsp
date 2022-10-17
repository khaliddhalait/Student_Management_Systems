<%@page import="com.entity.Mark"%>
<%@page import="com.dao.MarkDAO"%>
<%@page import="com.entity.Student"%>
<%@page import="com.dao.StudentDAO"%>
<%@page import="com.entity.Course"%>
<%@page import="java.util.List"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.CourseDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Student: Result-Details</title>
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
					<h3 class="text-center">Result</h3>

					<div class="card">
						<div class="card-body">
							<form id="myform" onsubmit="return validate()" action="../GetResultServlet" method="post">

								<div class="form-row">

									<input type="hidden" name="sid"
										value="<%=session.getAttribute("sid")%>">
									<div class="form-group col-md-5">
										<input type="text" name="name" class="form-control"
											value="<%=session.getAttribute("sname")%>" readonly>
									</div>

									<div class="form-group col-md-5">
										<select class="custom-select " id="inlineFormCustomSelectPref"
											name="semestar">
											<option selected>Semestar</option>
											<option value="1st Sem">1st Sem</option>
											<option value="2nd Sem">2nd Sem</option>
											<option value="3rd Sem">3rd Sem</option>
											<option value="4th Sem">4th Sem</option>
											<option value="5th Sem">5th Sem</option>
											<option value="6th Sem">6th Sem</option>
											<option value="7th Sem">7th Sem</option>
											<option value="8th Sem">8th Sem</option>
										</select>
									</div>
									<div class="form-group col-md-2">
										<button class="btn btn-success">View</button>
									</div>

								</div>

							</form>
						</div>
					</div>




				</div>
			</div>



		</div>
	</div>

<script type="text/javascript">
	function validate(){
		
		 var Semestar= document.forms["myform"]["semestar"].value;
	        if (Semestar == "Semestar") {
	            alert("Please select valid semestar");
	            return false;
	        }
		return true;
	}
</script>
</body>
</html>