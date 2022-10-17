
<!DOCTYPE html>
<%@page import="com.entity.Student"%>
<%@page import="com.dao.StudentDAO"%>
<%@page import="com.entity.Attendance"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.AttendanceDAO"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Profile</title>
<%@include file="all_css.jsp"%>
</head>
<script type="text/javascript">
	function validatePassword(e) {
		e.preventDefault();

	}
</script>
<body>

	<%
	int sid = (int) session.getAttribute("sid");
	StudentDAO sdao = new StudentDAO(DBConnect.getConn());
	Student s = sdao.getStudentById(sid);
	%>
	<div>
		<%@include file="navbar.jsp"%></div>
	<div class="container-fluid" style="margin: 0%; padding: 0px;">
		<div class="row">
			<div class="col-md-2">
				<%@include file="left-navbar.jsp"%>
			</div>

			<div class="col-md-10">
				<div class="container-fluid">
					<h3>Profile</h3>
				</div>

				<div class="card">
					<div class="card-body">
						<div>
							<form id="myform" onsubmit="return validate()"
								action="../UpdateStudentServlet" method="post">
								<!--**************************************  card body started *************************** -->
								<input type="hidden" name="sid" value=<%=s.getId()%>>
								<div class="row">
									<div class="form-group col-md-6">
										<label for=""> DOB</label> <input type="date" name="dob"
											required id="" class="form-control" value="<%=s.getDob()%>">
									</div>
									<div class="form-group col-md-6">
										<label for=""> Name</label> <input type="text" name="name"
											id="" class="form-control" value="<%=s.getName()%>" required>
									</div>

								</div>

								<div class="row">
									<div class="form-group col-md-6">
										<label for="">Gender</label> <select name="gender"
											class="custom-select my-1 mr-sm-2"
											id="inlineFormCustomSelectPref" required>
											<option selected>Choose...</option>
											<option value="Male">Male</option>
											<option value="Female">Female</option>
										</select>
									</div>

									<div class="form-group col-md-6">
										<label for="">Address</label>
										<textarea name="address" id="" cols="" rows="2"
											class="form-control" required><%=s.getAddress()%></textarea>
									</div>

								</div>

								<br>
								<center>
									<button class="btn btn-success">Update</button>
								</center>
								<br>
								<!--**************************************  card body ended *************************** -->
							</form>
						</div>
						<!--  update password modal -->
						<div>
							<!-- Button trigger modal -->
							<center>
								<button class="btn btn-success" data-toggle="modal"
									data-target="#updatepassword">Update Password</button>
							</center>

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
														action="../UpdateStudentPasswordServlet" method="post">
														<div class="form-group">
															<label for="">Enter current Password</label> <input
																type="password" name="cpassword" required id=""
																class="form-control"> <label for="">Enter
																new Password</label> <input type="password" name="npassword"
																required id="" class="form-control"> <label
																for="">Enter confirm Password</label> <input
																type="password" name="cnfpassword" required id=""
																class="form-control"> <input type="hidden"
																value="<%=s.getId()%>" name="sid"> <br>
															<button class="btn btn-success">Update password</button>
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














							<!--  update password modal end -->
						</div>

					</div>
				</div>


			</div>
		</div>
	</div>
	<script type="text/javascript">
		function validate() {
			var name = document.forms["myform"]["name"].value;
			if (name.length < 3) {
				alert("Name lenght must be greater than 3");
				return false;
			}
			var gender = document.forms["myform"]["gender"].value;
			if (gender == "Choose...") {
				alert("Please select valid gender");
				return false;
			}
			return true;
		}

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