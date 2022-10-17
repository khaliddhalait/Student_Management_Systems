<%@page import="java.util.List"%>
<%@page import="com.entity.Subject"%>
<%@page import="com.entity.Student"%>
<%@page import="com.dao.SubjectDAO"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Teacher: Add Mark</title>

<%@include file="all_css.jsp"%>
</head>
<body class="bg-card-color">
	<div><%@include file="navbar.jsp"%></div>

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
					<h3 class="text-center">Add Mark</h3>
					<div class="card">
						<%
						StudentDAO sdao = new StudentDAO(DBConnect.getConn());
						SubjectDAO sudao = new SubjectDAO(DBConnect.getConn());
						int sid = Integer.parseInt(request.getParameter("sid"));
						Student s = sdao.getStudentById(Integer.parseInt(request.getParameter("sid")));
						List<Subject> sub = sudao.getSubject(s.getCourse(), s.getSemestar());
						%>


						<div class="card-body">
							<form id="myform" onsubmit="return validate()" action="../AddMarkServlet" method="post">

								<input type="hidden" value="<%=sid%>" name="sid">

								<div class="form-row">
									<div class="form-group col-md-3">
										<label>Roll</label> <input type="text" class="form-control"
											readonly value="<%=s.getRoll()%>" name="roll">
									</div>
									<div class="form-group col-md-3">
										<label>Name</label> <input type="text" class="form-control"
											readonly value="<%=s.getName()%>" name="sname">
									</div>


									<div class="form-group col-md-3">
										<label>Course</label> <input type="text" class="form-control"
											readonly value="<%=s.getCourse()%>" name="course">
									</div>

									<div class="form-group col-md-3">
										<label>Semestar</label> <input type="text"
											class="form-control" readonly value="<%=s.getSemestar()%>"
											name="sem">
									</div>
								</div>

								<div class="form-row">
									<div class="form-group col-md-5">
										<label>Subject</label> <select name="subject"
											class="custom-select " id="inlineFormCustomSelectPref">
											<option selected>Choose...</option>
											<%
											for (Subject su : sub) {
											%>
											<option value="<%=su.getSubject()%>"><%=su.getSubject()%></option>
											<%
											}
											%>
										</select>
									</div>
									<div class="form-group col-md-5">
										<label>Mark</label> <input type="number" class="form-control"
											min=0 max=100 name="mark">
									</div>

								</div>

								<button class="btn btn-success">Submit</button>

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

<script type="text/javascript">
		function validate() {
			var subject = document.forms["myform"]["subject"].value;
			if (subject == "Choose...") {
				alert("Please select valid subject");
				return false;
			}
		}
	</script>
</body>
</html>