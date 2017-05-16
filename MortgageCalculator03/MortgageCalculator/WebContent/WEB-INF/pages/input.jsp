<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input Data</title>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		$("#signin").on("click", display);	
	});
	
	function display(){
		var principal = $("#principal").val();
		var type = $("#type").val();
		var state = $("#state").val();
		var extraPayment = $("#extraPayment").val();
		var extraMonth = $("#extraMonth").val();
		window.open("http://localhost:8080/MortgageCalculator/json/" + principal + "/" + type + "/" + state + "/" + extraPayment + "/" + extraMonth + ".html");
		//alert("http://localhost:8080/MortgageCalculator/json/" + principal + "/" + type + "/" +
		//					   state + "/" + extraPayment + "/" + extraMonth + ".html");
	}
</script>
</head>
<body>
<!-- Login Form -->	
<form name="f" method="POST" id="input-form">
	<table>
		<tr>
			<td>Principal: </td>
			<td><input type="text" name="principal" id="principal"/></td>
		</tr>
		<tr>
			<td>Type: </td>
			<td><input type="text" name="type" id="type"/></td>
		</tr>
		<tr>
			<td>State: </td>
			<td><input type="text" name="state" id="state"/></td>
		</tr>
		<tr>
			<td>Extra Payment: </td>
			<td><input type="text" name="extraPayment" id="extraPayment"/></td>
		</tr>
		<tr>
			<td>Extra Month: </td>
			<td><input type="text" name="extraMonth" id="extraMonth"/></td>
		</tr>
		<tr>
			<td></td>
			<td>
				<button type="reset">Clear</button>
				<button id="signin" type="submit">Submit</button>
			</td>
		</tr>
	</table>		
</form>
</body>
</html>