<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Insert title here</title>
</head>
<body onload="처음으로()">
	<div class="container">
		<br />
		<button onclick="처음으로()" class="btn btn-primary pull-left">처음으로</button>
		<button onclick="가격순()" class="btn btn-primary pull-center">가격순</button>
		<button onclick="판매순()" class="btn btn-primary pull-right">판매순</button>
		<br />
		<br />
		<table class="table table-striped">
			<thead>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>종류</th>
					<th>가격</th>
					<th>판매수</th>
					<th></th>
				</tr>
			</thead>
			<tbody id="item__list">

			</tbody>
		</table>
	</div>

	<script src="/product/js/product.js"></script>
</body>
</html>
