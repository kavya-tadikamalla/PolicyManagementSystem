<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<h2>Policy Payment Form</h2>
 <form:form action="#" method="post" modelAttribute="payment" style="margin-top:50px;margin-left:30px;">

<table align="center" class="tables back" >

<tr>
<td>PolicyId  :</td>
<td>

<form:input path="policyId"  class="form-control"/>
<br>
 <form:errors path="policyId" cssClass="errors"></form:errors> 
</td>
</tr>
<tr>
<td>My Id  :</td>
<td>

<form:input path="userId" class="form-control"/>
<br>
 <form:errors path="userId" cssClass="errors"></form:errors> 
</td>
</tr>
<tr>
<td>Amount:</td>
<td>

<form:input path="amount" class="form-control"/>
<br>
 <form:errors path="amount" cssClass="errors"></form:errors> 
</td>
</tr>

<tr>
<td>renewalmonths :</td>
<td>

<form:input path="renewalmonths" class="form-control"/>
<br>
 <form:errors path="renewalmonths" cssClass="errors"></form:errors> 
</td>
</tr>
<tr>
<td>finePerday:</td>
<td>

<form:input path="fineperday" class="form-control"/>
<br>
 <form:errors path="fineperday" cssClass="errors"></form:errors> 
</td>
</tr>
<tr>
<td>fineamount:</td>
<td>

<form:input path="fineamount"  class="form-control"/>
<br>
 <form:errors path="fineamount" cssClass="errors"></form:errors> 
</td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" value="SelectPaymentMethod" class="formsubmitbutton" />
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