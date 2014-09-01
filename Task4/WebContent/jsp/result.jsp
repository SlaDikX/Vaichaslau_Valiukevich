<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head>
<title>Result Page</title>
<style type="text/css">
</style>
</head>
<body>
Был выбран парсер ${parser}
	<table border=1>
		<tr>
			<td>Container Type</td>
			<td>Coffee Name</td>
			<td>Price per Gram</td>
			<td>Coffee State</td>
			<td>Coffee Density</td>
			<td>Volume (ml)</td>
			<td>Weight (gram)</td>
			<td>Relation Price/Weight</td>
			<td>Total Price</td>
		</tr>
		<c:forEach var="current" items="${res.listOfGoods}">
			<tr>
				<td>${current.containerType}</td>
				<td>${current.coffee.name}</td>
				<td>${current.coffee.pricePerGram}$</td>
				<td>${current.coffee.state}</td>
				<td>${current.coffee.state.density}</td>
				<td>${current.volume}</td>
				<td>${current.weight}</td>
				<td>${current.relationPriceToWeight}</td>
				<td>${current.price}$</td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<table border=1>
		<tr>
			<td>Total Wagon Capacity</td>
			<td>Total Wagon Price</td>
			<td>Free Wagon Money</td>
			<td>Free Wagon Space</td>
		</tr>
		<tr>
			<td>${res.wagonCapacity}</td>
			<td>${res.wagonPrice}$</td>
			<td>${res.freeMoney}$</td>
			<td>${res.freeSpace}</td>
		</tr>
	</table>
</body>
</html>