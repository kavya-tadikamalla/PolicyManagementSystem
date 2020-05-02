<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy Management-Customer</title>
<link rel="stylesheet" type="text/css" href="/style.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>	
</head>
<body>
<div class="header"><header><b class="heading">Policy Management</b></header></div>
<div class="topnav">
  <a href="/" class="fas fa fa-home back" >Home</a>
  <a href="/admin/" class="fas fa-user-circle back" >Admin</a>
 <a href="/policyvendor/" class="fas fa-user-plus back" >Policy Vendor</a>
 <a href="/customer/" class="fas fa-user-alt back" >Customer</a>

   </div>
 
<div class="card">
<c:if test="${message!=null }">  
   <script>alert('<c:out value="${message}"/>');
	            
				</script>  
				</c:if>

 <form:form action="/customer/customlogin" method="post" modelAttribute="custml" style="margin-top:50px;">
	<table align="center" class="tables back" >
		<tr align="center"><td colspan="2" style="text-align: center;text-decoration-line: underline;">Login Form</td></tr>
		<tr>
			<td><i class="fas fa fa-user back" title="UserId" style="border-spacing:10px;"> UserId</i></td>
			<td><form:input path="userId" required="required" placeholder="Enter your userId" title="Enter UserId"/><br>
				
				<form:errors path="userId" ></form:errors></td>
		</tr>
		<tr>
			<td><i class="fa fa-key" title="Password"> Password</i> </td>
			<td><form:password path="password" required="required" placeholder="Enter your Password" title="Enter Password"/><br>
			<form:errors path="password" style="color:red"></form:errors>
			
			</td>
		</tr>
		<tr align="center">
		<td colspan="2" style="text-align: center;"><input type="submit" value="Login" class="formsubmitbutton" /></td></tr>
		<tr><td colspan="2" style="text-align: center;"><label style="font-size: 15px;">New Customer?<a href="/customer/custregister" style="color:white;"> Register</a></label></td>
		</tr>
		<tr>
<td colspan="2" style="text-align: center;"><a href="cforgotuid" style="font-size: 15px;color:white;">Forgot Userid?</a>
<a href="cforgotpswd" style="font-size: 15px;color:white;">Forgot Password?</a> </td>
</tr>
		
	</table>
 </form:form>
 
</div>
<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved
</div> 
</footer>

</body>
</html>