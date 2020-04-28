<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy Management-PolicyVendor</title>
<link rel="stylesheet" type="text/css" href="/style.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>

<body>
  <!-- <div class="topnav">
  <b class="heading">Policy Management</b>
  <a href="/logout/" class="fas fa-power-off back">  Logout</a>
  <a href="/policyvendor/" class="fas fa-user-plus back">  Policy Vendor</a>
  <a href="/customer/" class="fas fa-user-alt back">  Customer</a>
  <a href="/admin/" class="fas fa-user-circle back">  Admin</a>
   </div> -->
<div class="card">

 <form:form action="/customer/searchpol" method="post" modelAttribute="searchpo" style="margin-top:50px;margin-left:30px;">

<table align="center" class="tables back" >
<h2> Search Policy</h2>
<tr>

<td>
<form:select path="category" class="form-control">
<form:option value="" label="--Select Category--"/>
<form:option value="Policytype" label="PolicyType"/>
<form:option value="PolicyName" label="PolicyName"/>

</form:select>
</td></tr>
<tr>

<td>

<form:input path="text" class="form-control" placeholder="enter text"/>
<br>
 <form:errors path="text" cssClass="errors"></form:errors> 
</td>
<td colspan="3" align="center"><button><i class="fas fa fa-search" style:"font-size:10px;"><input type="hidden"/>Search</i></button>
</tr>
<tr>
		
		</tr>
</table>
</form:form>

</div>
<%

RequestDispatcher rd = request.getRequestDispatcher("customerHome.jsp");
rd.include(request, response);

%>

<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved
</div> 
</footer>
</body>
</html>