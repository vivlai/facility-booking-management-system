/**
 * 
 */

function checkPW(){
	var pw1 = document.getElementById("password").value;
	var pw2 = document.getElementById("confirmPassword").value;
	if (pw1 != pw2){
		window.alert("Password you entered should be the same.")		
		return false;
	}
	return true;
}