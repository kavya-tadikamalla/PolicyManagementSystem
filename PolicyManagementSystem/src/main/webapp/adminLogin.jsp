<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy Management-Admin</title>
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
<div class="card ">

 <form:form action="/admin/adminlogin" method="post" modelAttribute="adlogin" style="margin-top:50px;margin-left:30px;">
	<table align="center" class="tables back" >
	<tr align="center"><td colspan="2" style="text-align: center;text-decoration-line: underline;">Login Form</td></tr>
		
		<tr>
			<td><i class="fas fa fa-user back" title="UserId" style="border-spacing:10px;"> UserId</i></td>
			<td ><form:input path="adminId" required="required" placeholder="Enter your userId" title="Enter UserId"/><br>
			
			<form:errors path="adminId" ></form:errors>
			</td>
		</tr>
		<tr>
			<td><i class="fa fa-key" title="Password"> Password</i> </td>
			<td><form:password path="password" required="required" placeholder="Enter your Password" title="Enter Password"/><br>
			<i class="fa fa-key tablealign" title="Password"> Password</i> </td>
			<form:errors path="password" ></form:errors>
			</td>
		</tr>
		<tr align="center">
		<td colspan="2" style="text-align: center;"><input type="submit" value="Login" class="formsubmitbutton"/></td></tr>
		<tr><td colspan="2" style="text-align: center;"><label style="font-size: 15px;">New Admin?<a href="/admin/register/" style="color:white;"> Register</a></label></td>
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