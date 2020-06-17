function 처음으로(){
	$.ajax({
		type : "get",
	   	url: `/product/productController?cmd=처음으로`,
	   	dataType: "json"
	}).done(function (result){
		$("#item__list").empty();
		renderTableList(result);
	}).fail(function(){
		alert("실패");
	})
	
}

function 가격순(){
	$.ajax({
		type : "get",
	   	url: `/product/productController?cmd=가격순`,
	   	dataType: "json"
	}).done(function (result){
		$("#item__list").empty();
		renderTableList(result);
	}).fail(function(){
		alert("실패");
	})

}

function 판매순(){
	$.ajax({
		type : "get",
	   	url: `/product/productController?cmd=판매순`,
	   	dataType: "json"
	}).done(function (result){
		$("#item__list").empty();
		renderTableList(result);
	}).fail(function(){
		alert("실패");
	})
	
}

function renderTableList(products) {
		
	for (var product of products) {
		$("#item__list").append(makeTableItem(product));
	}
	
	
	
}

function makeTableItem(product) {
	var tableItem =  `<tr id="item-${product.id}">`;	
	tableItem += `<td>${product.id}</td>`;
	tableItem += `<td>${product.name}</td>`;
	tableItem += `<td>${product.type}</td>`;
	tableItem += `<td>${product.price}</td>`;
	tableItem += `<td>${product.count}</td>`;
	tableItem += `<td><i onclick="deleteById(${product.id})" class="material-icons i__btn" style="cursor: pointer;">delete</i></td>`;
	tableItem += `</tr>`;	
	
		
return 	tableItem;
}

function deleteById(id){
	$.ajax({
		type: "post",
		url: "/MVC/productController?cmd=deleteProc",
		data: "id="+id,
		contentType: "application/x-www-form-urlencoded; charset=utf-8",
		dataType: "text"
	}).done(function(result){
		if(result =="1"){
			alert("아이템 삭제 성공");
			var item = $("#item-"+id);
			item.remove();
		} else{
			alert("아이템 삭제 실패");
		}
		
	}).fail(function(error){
		alert("아이템 삭제 실패2");
	});
}
