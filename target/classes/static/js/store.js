function getProducts(type, firstLoad){
		var xhttp = new XMLHttpRequest();
		xhttp.onreadystatechange = function(){
			if(xhttp.readyState == 4 && xhttp.status == 200){
				document.getElementById("main").innerHTML = "";
				var productList = JSON.parse(xhttp.responseText);
				var listing = "";
				for(i in productList){
					if(productList[i].category == type || type == 'all'){
						var div = document.createElement("div");
						var par = document.createElement("p");
						var btn = document.createElement("BUTTON");
						var listing = productList[i].id + " " + productList[i].name;
						var listing = productList[i].name + "<br>€" + productList[i].price;
						par.innerHTML = listing;
						btn.innerHTML = "View Product";
						div.appendChild(par);
						div.appendChild(btn);
						document.getElementById("main").appendChild(div);
						btn.addEventListener("click", linktoProductPage.bind(this, productList[i].id));
					}
				}
				if(firstLoad == true){
					makeMenu(productList);
				}
			}
		}
		xhttp.open("GET", "http://localhost:8080/products", true);
		xhttp.send();
	}
	function getFilteredProducts(){
		var type = document.forms["selector"]["type"].value;
		getProducts(type, false);
	}
	function makeMenu(list){
		var categories = [];
		for(i in list){
			if(!categories.includes(list[i].category)){
				categories.push(list[i].category);
				var entry = document.createElement("option");
				entry.value = list[i].category;
				var text = document.createTextNode(list[i].category);
				entry.appendChild(text);
				document.forms["selector"]["type"].appendChild(entry);
			}
		}
	}
	function linktoProductPage(id){
		idParam = id - 1;
		window.location.href = "/sales/product.html" + '#' + idParam;
	}