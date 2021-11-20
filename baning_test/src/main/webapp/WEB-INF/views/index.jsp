<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SBI</title>

</head>
<body style='background-color:  #aa3c75' >
<div id="left">
<img src="images/sbi.jpg" width="150" height="100" align="right"/>
</div>
<div id="right">
<img src="images/sbi.jpg" width="150" height="100"/>
</div>
<h1 align="center">
Welcome to SBI, Please <a href="<spring:url value='/bankAccount/login'/>">Click Here</a> to Login
</h1>
<tr>
<td><iframe width="560" height="315" src="https://www.youtube.com/embed/rx_YDAa7t4Y" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></td>
<td><iframe width="560" height="315" src="https://www.youtube.com/embed/F0GwXwnY5SQ" title="YouTube video player" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe></td>
</tr>

</body>
</html>
