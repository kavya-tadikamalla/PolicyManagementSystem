<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<title> Home</title>
<link rel="stylesheet" type="text/css" href="/style.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<style type="text/css">
table {
  table-layout: fixed ;
  width: 100% ;
}
td {
  width: 30% ;
  word-break:break-all; 
}
</style>
</head>
<body>
<%
String username =(String) session.getAttribute("username");
int userid=(Integer)session.getAttribute("userId");
if(username==null || userid==0)
{
	response.sendRedirect("/policyvendorlogin/");
}
%><div class="header"><header><b class="heading">Policy Management</b></header></div>
  <div class="topnav">
  <a href="/home/" class="fas fa fa-home back" >Home</a>
  <a href="/admin/listvendors" class="fas fa-user-plus back"> List PolicyVendors</a>
  <a href="/customer/" class="fas fa-user-alt back">  Customer</a>
  <a href="/admin/" class="fas fa-user-circle back">  Admin</a>
  <a href="/admin/logout/" class="fas fa-power-off back" >  Logout</a>
  
   </div>
  <label text-align="left">Welcome <%=username %>(<%=userid %>)</label>
</div>
    <div class="card">     
      <h2>Display</h2>
      
       <table align="center" class="tables back" border="1px solid" >
       <tr>
       <td>Id</td><td>Name</td><td>Reg_No.</td><td>PolicyType</td>
       <td>email</td><td>Mobile</td>
       <td>website</td><td>certificateissue</td><td>certificateValidity</td>
       <td>Yearofestablishment</td><td>activate</td><td>Deactivate</td><td>sfc</td>
       
       </tr>
      <!--  JSTL Core Tag -->
     <c:forEach items="${vendorlist}" var="vendors">
      
    <tr style="font-size: 18px; " >
      <td>${vendors.vendorId}</td>
       <td>${vendors.policyvendorname}</td>
        <td>${vendors.policyvendorregno}</td>
         <td>${vendors.policytype}</td>
           <td>${vendors.emailaddress}</td>
           <td>${vendors.contactnumber }</td>
           <td>${vendors.website }</td>
           <td>${vendors.certificateissueddate}</td>
           <td>${vendors.certificatevaliditydate }</td>
           <td>${vendors.yearofestablishment }</td>
           <td> <button><a href="/admin/activate?vendorid=${vendors.vendorId}" style="color: black;">Activate</a></button> </td>
           <td> <button><a href="/admin/deactivate?vendorid=${vendors.vendorId}" style="color: black;">Deactivate</a></button> </td>
           <td><button> <a href="/admin/sendforcorrection?vendorid=${vendors.vendorId}" style="color: black;">Send for Correction</a></button> </td>
    </tr>

</c:forEach>

      </table>
  <script type="text/javascript"></script>
  ${message}  
    
  
</div>
<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved

 
</div> </footer>

</body>
</html>