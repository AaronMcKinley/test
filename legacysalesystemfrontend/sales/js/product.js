function getProdByID(){
	var product_id = window.location.hash.substring(1);
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			var response = JSON.parse(xhttp.responseText);
			var output = "";
			var div = document.createElement("div");
			var par = document.createElement("p");
			var listing = response.name + "<br>€" + response.price + "<br>" +response.description;
			console.log(response.name + " " + response.price+ "<br>" +response.description);
			console.log(response.description);
			par.innerHTML = listing;
			div.appendChild(par);
			document.getElementById("main").appendChild(div);
			createPurchaseForm(response);
		}
	}
	xhttp.open("GET", "http://localhost:8080/products/"+product_id+"", true);
	xhttp.send();
}
function createPurchaseForm(product){
	var form = document.createElement("form");
	form.name = "purchases";
	var input = document.createElement("input");
	input.type = "number";
	input.name = "quantity";
	input.min = "1";
	input.max = product.stockLevel;
	product.stockLevel=product.stockLevel-input;
	var button = document.createElement("button");
	var text = document.createTextNode("Purchase");
	button.appendChild(text);
	button.type = "button";
	button.addEventListener("click", sendPurchaseRequest);
	form.appendChild(input);
	form.appendChild(button);
	document.getElementById("main").appendChild(form);
}
function sendPurchaseRequest(){
	var quantity = document.forms['purchases']['quantity'].value;
	var productId = window.location.hash.substring(1);
	var xhttp = new XMLHttpRequest();
	var url = "http://localhost:8080/baskets?customerId=1&productId=" + productId + "&quantity=" + quantity;
	xhttp.open("GET", url, true);
	xhttp.send();
	
}
function goBack() {
	window.history.back();
}