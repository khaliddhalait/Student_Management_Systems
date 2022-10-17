function validateCourse() {
	var course = document.forms["coform"]["course"].value;
	if (!isNaN(course)) {
		alert("numbers are not allowed");
		return false;
	}
	return true;
}

function validateSubject() {
	var course = document.forms["subform"]["course"].value;
	if (course == "Choose...") {
		alert("Please select valid course");
		return false;
	}
	var Semestar = document.forms["subform"]["sem"].value;
	if (Semestar == "Choose...") {
		alert("Please select valid semestar");
		return false;
	} 
	var subject = document.forms["subform"]["subject"].value;
	if (!isNaN(subject)) {
		alert("numbers are not allowed");
		return false;
	}
	return true;
}

function validateTeacher() {
	var name = document.forms["atform"]["name"].value;
    if (name.length < 3) {
        alert("Name lenght must be greater than 3");
        return false;
    }
    if (!isNaN(name)) {
		alert("numbers are not allowed for name");
		return false;
	}
	var gender = document.forms["atform"]["gender"].value;
    if (gender == "Choose...") {
        alert("Please select valid gender");
        return false;
    }
    var qua = document.forms["atform"]["qua"].value;
    if (qua.length == 1) {
        alert("Qualification lenght must be greater than 1");
        return false;
    }
    if (!isNaN(qua)) {
		alert("numbers are not allowed for qualification");
		return false;
	}
	var email = document.forms["atform"]["email"].value;
	if (!isNaN(email)) {
		alert("numbers are not allowed for email");
		return false;
	}
	
    var password = document.forms["atform"]["password"].value;
    var cpassword = document.forms["atform"]["cpassword"].value;
    if (password !== cpassword) {
        alert("confirm password missmatch");
        return false;
    }

    if (password.length < 8) {
        alert("password lenght should not be less than 8");
        return false;
    }
	
	return true;
}


function validateStudent() {
	var name = document.forms["myform"]["name"].value;
    if (name.length < 3) {
        alert("Name lenght must be greater than 3");
        return false;
    }
    if (!isNaN(name)) {
		alert("numbers are not allowed for name");
		return false;
	}
	var gender = document.forms["myform"]["gender"].value;
    if (gender == "Choose...") {
        alert("Please select valid gender");
        return false;
    }
    
	var email = document.forms["myform"]["email"].value;
	if (!isNaN(email)) {
		alert("numbers are not allowed for email");
		return false;
	}
	
    var password = document.forms["myform"]["password"].value;
    var cpassword = document.forms["myform"]["cpassword"].value;
    if (password !== cpassword) {
        alert("confirm password missmatch");
        return false;
    }

    if (password.length < 8) {
        alert("password lenght should not be less than 8");
        return false;
    }
	
	var roll = document.forms["myform"]["roll"].value;
	 if (roll.length != 12) {
        alert("Roll number must be 12 digit");
        return false;
    }
    if (isNaN(roll)) {
		alert("Invalid Roll number");
		return false;
	}
	var course = document.forms["myform"]["course"].value;
	if (course == "Choose...") {
		alert("Please select valid course");
		return false;
	}
	var Semestar = document.forms["myform"]["sem"].value;
	if (Semestar == "Choose...") {
		alert("Please select valid semestar");
		return false;
	} 
	return true;
}