<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body style='background-color:#ccffff'>


	<h1>${requestScope.message}</h1>
	<div class="container">
		<table class="table table-bordered table-primary">
			<thead>
			<caption>Account Holder details</caption>
			<tr>
				<th>Account No.</th>
				<th>Account Type</th>
				<th>Balance</th>
				<th>Email</th>
				<th>Name</th>

				<th>Delete</th>
			</tr>
			</thead>
			<c:forEach var="acct" items="${sessionScope.BankAccount_details}">
				<tbody>
					<tr>
						<td>${acct.accountNumber}</td>
						<td>${acct.type}</td>
						<td>${acct.balance}</td>
						<td>${acct.email}</td>
						<td>${acct.name}</td>

						<td><a
							href="<spring:url value='/bankAccount/delete?aid=${acct.id}'/>"><button
									type="button" class="btn btn-danger">Delete Account</button></a></td>
					</tr>
				</tbody>
		</table>
		<table>

			<form method="Get" action="../bankAccount/withdrawl">
				<input type="hidden" name="aid" value="${acct.id}" />
				<tr>
					<td>Enter Amount to withdraw</td>
					<td><input type="number" name="balance"
						placeholder="Enter withdraw Amount" /></td>
					<td><button type="submit" class="btn btn-primary">Withdraw</button></td>
			</form>


			<form method="Get" action="../bankAccount/deposit">
				<input type="hidden" name="aid" value="${acct.id}" />

				<td>Enter Amount to deposit</td>
				<td><input type="number" name="balance"
					placeholder="Enter Deposit Amount" /></td>
				<td><button type="submit" class="btn btn-primary">Deposit</button></td>
				</tr>
			</form>


			<tr>
				<th><h5>
						<a href="<spring:url value='/bankAccount/register'/>"><button
								type="button" class="btn btn-success">Create New
								Account</button></a>
					</h5></th>
				<th></th>

				<th><h5>
						<a href="<spring:url value='/bankAccount/logout'/>"><button
								type="button" class="btn btn-danger">Logout</button></a>
					</h5></th>
			</tr>

		</table>

		</c:forEach>
	</div>
</body>
</html>
