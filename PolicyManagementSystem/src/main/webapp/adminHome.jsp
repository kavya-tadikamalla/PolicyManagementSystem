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
if(username==null || userid==0)
{
	response.sendRedirect("/policyvendorlogin/");
}
%>
  <div class="topnav">
  <b class="heading">Policy Management</b>
  <a href="/admin/logout/" class="fas fa-power-off back">  Logout</a>
  <a href="/policyvendor/" class="fas fa-user-plus back">  Policy Vendor</a>
  <a href="/customer/" class="fas fa-user-alt back">  Customer</a>
  <a href="/admin/" class="fas fa-user-circle back">  Admin</a>
   </div>
  <label text-align="left">Welcome <%=username %>(<%=userid %>)</label>
</div>
    <div class="card">     
      <h2>Display</h2>
       <table align="center" class="tables back" >
      <tr>
      <th>Headings</th>
      <th>Headings</th>
      <th>Headings</th>
      <th>Headings</th>
      </tr>
      <tr>
      <td>344</td>
      <td>344</td>
      <td>344</td>
      <td>344</td>
      </tr>
      <tr>
      <td>344</td>
      <td>344</td>
      <td>344</td>
      <td>344</td>
      </tr>
      <tr>
      <td>344</td>
      <td>344</td>
      <td>344</td>
      <td>344</td>
      </tr>
      <tr>
      <td>344</td>
      <td>344</td>
      <td>344</td>
      <td>344</td>
      </tr>
      <tr>
      <td>344</td>
      <td>344</td>
      <td>344</td>
      <td>344</td>
      </tr>
      </table>
     
    
  
</div>
<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved

 
</div> </footer>

</body>
</html>