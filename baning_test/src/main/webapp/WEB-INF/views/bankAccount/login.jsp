<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- jQuery library -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<!-- javascript -->
<link rel="stylesheet" src="style.css" />
   <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
   <script src="https://apis.google.com/js/client.js"></script>
</head>
<body style='background-color:#99ccff'>

<h4 align = "center" style="color: red;">${requestScope.message}
</h4>
<div class="container">
<form method="post">
<table class="table table-bordered table-primary">
<tr style='background-color:lightgrey'>
<td>
Enter Your Email
</td>
<td><input type = "text" name= "email" placeholder = "abc@gmail.com" /> </td>

</tr>
<tr style='background-color:lightgrey'>
<td>
Enter Your password
</td>
<td><input type = "password" name= "password" placeholder="Enter Password"/> </td>

</tr>
<tr>

<td><input id="tv" type = "submit" name= "btn btn-primary" value="Login" style="background-color: lightblue"/> </td>

</tr>


</table>
<spring:url value="/bankAccount/newaccount" var="bankAccount" 
		htmlEscape="true"/><a href="${bankAccount}">
 		<button type="button" class="btn btn-success">Create New Account</button></a>
</form>
</div>

</body>
</html>