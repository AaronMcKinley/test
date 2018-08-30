function getBasket(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			var listings = JSON.parse(xhttp.responseText);
			var totalCost = 0;
			for(i in listings){
				var div = document.createElement("div");
				var p = document.createElement("p");
				var button = document.createElement("button");
				button.innerHTML = "Remove from Cart";
				button.addEventListener("click", function(element){return function(){removeItemFromCart(element);}} (listings[i].id));
				p.innerHTML = listings[i].productName + " " + listings[i].quantity + "<br>€" + listings[i].price;
				div.appendChild(p);
				div.appendChild(button);
				document.getElementById("main").appendChild(div);
				totalCost += listings[i].price;
			}
			var cost = document.createTextNode("Total Cost: €" + totalCost);
			document.getElementById("main").appendChild(cost);
		}
	}
	xhttp.open("GET", "http://localhost:8080/baskets/1", true);
	xhttp.send();
}
function removeItemFromCart(orderId){
	var xhttp = new XMLHttpRequest();
	xhttp.open("DELETE", "localhost:8080/removeListing/" + orderId, true);
	xhttp.send();
	window.location.assign("/sales/basket.html");
}
function submitOrder(){
	var xhttp = new XMLHttpRequest();
	xhttp.onreadystatechange = function(){
		if(xhttp.readyState == 4 && xhttp.status == 200){
			var response = xhttp.responseText;
			console.log(response);
			
			if (response == "false"){
				window.alert("Error: Basket is empty.");
				window.location.assign("/sales/basket.html");
			} else {
				cancelOrder();
				window.alert("Order Submitted Successfully. Click OK to return home.");
				window.location.assign("/sales/store.html");
			}
		}
	}
	xhttp.open("GET", "http://localhost:8080/orders?customerId=1", true);
	xhttp.send();
}
function cancelOrder(){
	var xhttp = new XMLHttpRequest();
	xhttp.open("DELETE", "http://localhost:8080/remove/1", true);
	xhttp.send();
	window.location.assign("/sales/basket.html");
}
function goBack() {
	window.history.back();
}