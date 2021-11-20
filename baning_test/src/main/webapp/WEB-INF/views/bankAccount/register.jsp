<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta charset="UTF-8">
<title>Register</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div>
<c:forEach var="acct" items="${sessionScope.bankAccount_details}">
<form method="post"  >
  <div class="form-group col-xs-3">
    <label >Account Number</label> 
    <input type="text" class="form-control input-sm" name="accountNumber"  placeholder="Enter Account Num"/>
   
    
  </div>
  <div class="form-group col-xs-3">
    <label >Account Type</label> 
<input type="radio" id="SAVING" name="type" value="SAVING">
<label for="html">SAVING</label><br>
<input type="radio" id="FIXED" name="type" value="FIXED">
<label for="css">FIXED</label><br>
<input type="radio" id="CURRENT" name="type" value="CURRENT">
<label for="javascript">CURRENT</label><br>
<input type="radio" id="DMART" name="type" value="CURRENT">
<label for="javascript">DMART</label>
    
  </div>
  <div class="form-group col-xs-2">
    <label >Opening Balanace</label>
    <input type="number" class="form-control input-sm" name="balance" placeholder="Enter balance"/>
    
  </div>
  <div class="form-group col-xs-2">
    <label >Email </label>
    <input type="email" class="form-control input-sm" name="email" <%-- value="${acct.email}"  readonly --%> placeholder="Enter email"/>
    
    
  </div>
  <div class="form-group col-xs-2">
    <label >Account Holder Name</label>
    <input type="text" class="form-control input-sm" name="name"<%-- value="${acct.name}"  readonly --%> placeholder="Enter name"/>
    
    
  </div>
  <div class="form-group col-xs-2">
    <label >Password</label>
    <input type="password" class="form-control input-sm" name="password" <%-- value="${acct.password}" readonly --%> placeholder="Enter password"/>
  </div>
  
  <button type="submit" class="btn btn-primary">Create Account</button>
</form>
</c:forEach>
</div>
</body>
</html>