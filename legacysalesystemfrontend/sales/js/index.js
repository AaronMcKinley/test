var username;
var password;

function register(){
	var xhttp = new XMLHttpRequest();
	username = document.getElementById('uname').value;
	password = document.getElementById('psw').value;
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			var response = xhttp.responseText;
			console.log(response);
			
			if (response == "true"){
				window.location.assign('/sales/store.html');
				window.alert("Registered Successfully");
			} else {
				window.alert("Username already taken");
			}
		}}
	xhttp.open("POST", "http://localhost:8080/register?username=" + username + "&password=" + password, true);
	xhttp.open("GET", "http://localhost:8080/validateregister?username=" + username + "&password=" + password, true);
	xhttp.send();	
}

function login(){
	var xhttp = new XMLHttpRequest();
	username = document.getElementById('uname').value;
	password = document.getElementById('psw').value;
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			var response = xhttp.responseText;
			console.log(response);
			
			if (response == "true"){
				window.location.assign('/sales/store.html');
				window.alert("Login Successful");
			} else {
				window.alert("Incorrect details");
			}
		}}
	xhttp.open("POST", "http://localhost:8080/login?username=" + username + "&password=" + password, true);
	xhttp.open("GET", "http://localhost:8080/validatelogin?username=" + username + "&password=" + password, true);
	xhttp.send();	
}