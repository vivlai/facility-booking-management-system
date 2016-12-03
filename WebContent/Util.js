/**
 * 
 */

function checkPW(){
	var email = document.getElementById("email").value;
	var server = email.split("@");
	if (server[1] != "colorado.edu") {
		window.alert("Need colorado.edu");
		return false;
	}
	var pw1 = document.getElementById("password").value;
	var pw2 = document.getElementById("confirmPassword").value;
	if (pw1 != pw2){
		window.alert("Password you entered should be the same.")		
		return false;
	}
	
	return true;
}