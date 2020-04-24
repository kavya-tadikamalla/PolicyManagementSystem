<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title> Home</title>
<link rel="stylesheet" type="text/css" href="/style.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
</head>
<body>
<%
String username =(String) session.getAttribute("username");
int userid=(Integer)session.getAttribute("userId");
session.setAttribute("uservid", userid);
if(username==null || userid==0)
{
	response.sendRedirect("/policyvendorlogin/");
}
%>
 <div class="topnav">
  <b class="heading">Policy Management</b>
  <a href="/policyvendor/logout/" class="fas fa-power-off back">  Logout</a>
  
  <a href="/policyvendor/addpolicy1" class="fas fa-user-plus back">Add Policy</a>
  <a href="/customer/" class="fas fa-user-alt back">  Customer</a>
  <a href="/admin/" class="fas fa-user-circle back">  Admin</a>
   </div>
  <div><lable text-align="left">Welcome <%=username %>(<%=userid %>)</lable></div>
    <div class="card">
      <h2>Insurance</h2>
      <table align="center" class="tables back" >
      <tr><td></td></tr>
      </table>
 </div>
${message}
<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved
</div> </footer>
</body>
</html>