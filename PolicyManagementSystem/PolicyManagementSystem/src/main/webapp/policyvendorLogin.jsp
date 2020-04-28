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
  <a href="/home/" class="fas fa fa-home back" >Home</a>
  <a href="/admin/" class="fas fa-user-circle back" >Admin</a>
 <a href="/policyvendor/" class="fas fa-user-plus back" >Policy Vendor</a>
 <a href="/customer/" class="fas fa-user-alt back" >Customer</a>

   </div>
${message}
<div class="card">
<h2>Login Form</h2>
 <form:form action="/policyvendor/policyvendorlogin" method="post" modelAttribute="policyvendor" style="margin-top:50px;">

<table align="center" class="tables back" >
<tr>
<td>User ID<label style="color: red">*</label>:</td>
<td>

<form:input path="vendorId" class="form-control" />
<br>
 <form:errors path="vendorId" cssClass="errors"></form:errors> 
</td>
</tr>

<tr>
<td>Password<label style="color: red">*</label>:</td>
<td><form:password path="password" class="form-control"/>
<br>
<form:errors path="password" cssClass="errors"></form:errors>
</td>
</tr>






<tr>

<td colspan="2" align="center"><input type="submit" value="Login" class="formsubmitbutton" />

</tr>
</table>



</form:form>


New User Policy<a href="/policyvendor/policyvendorreg" style="color:slateblue;"> Register</a>
</div>
<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved
</div> 
</footer>

</body>
</html>