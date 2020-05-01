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
  <a href="/adminHome.jsp" class="fas fa-home back">  My Home</a>
  <a href="/admin/listvendors" class="fas fa-user-plus back"> List PolicyVendors</a>
  <a href="/admin/helpreq" class="fas fa-user-alt back">  Help</a>
  <a href="/admin/logout/" class="fas fa-power-off back" style="float: right;" >  Logout</a>
  <a href="/adminHome.jsp" style="float: right;">Welcome <%=username %>(<%=userid %>)</a>
   </div>
  
</div>
    <div class="card">     
      <table align="center" class="tables back" border="1px solid" >
       <c:if test="${vendorlist!=null}">
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
</c:if>
<c:if test="${helpList!=null }">
<tr>
<td>UserId</td>
<td>Issue</td>
<td>Description</td>
<td>Status</td>
<td>Action</td>
</tr>
<c:forEach items="${helpList}" var="u">
<tr>
<td>${u.userId}</td>
<td>${u.issue}</td>
<td>${u.description}</td>
<td>${u.status}</td>
<td>
<c:choose>
<c:when test="${u.status =='solved' }">

<button><a  style="color:black;" disabled="disabled" title="link disabled">Respond</a></button>
</c:when>
<c:otherwise>
<button><a href="/admin/respondhelp?helpid=${u.hid}" style="color:black;">Respond</a></button>
</c:otherwise>
</c:choose>
</td>
</tr>
</c:forEach>
</c:if>
      </table>
  <script type="text/javascript"></script>
  <label style="color:white;font-size:large;"><c:out value="${message}"></c:out></label>  
    
 <c:if test="${message!=null }">  
   <script>alert('<c:out value="${message}"/>');
	            
				</script> </c:if>
</div>
<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved

 
</div> </footer>

</body>
</html>