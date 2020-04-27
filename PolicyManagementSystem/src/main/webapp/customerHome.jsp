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
<div class="header"><header><b class="heading">Policy Management</b></header></div>
 <div class="topnav">
  <a href="/home/" class="fas fa fa-home back" >Home</a>
  <a href="/customer/listofpolicies" class="fas fa-user-plus back">  List of Policies</a>
  
  <a href="/admin/" class="fas fa-user-circle back">  Admin</a>
  <a href="/customer/logout/" class="fas fa-power-off back" style="float: right;">  Logout</a>
   <a href="/customer/searchp" class="fas fa fa-search" style="float: right;"></a>
   </div>
   <div><lable text-align="left">Welcome <%=username %>(<%=userid %>)</lable></div>
    <div class="card">     
      <table align="center" class="tables back" border="1px solid" >
      <!--  JSTL Core Tag    
-->
	<c:if test="${policylist!=null}">
	
	<tr>
       <td>PolicyId</td><td>PolicyName</td><td>DurationOfPolicy</td>
       <td>Premium_Amount</td><td>PolicyType</td><td>Buy Policy</td>
       </tr>
     <c:forEach items="${policylist}" var="policylist1">
    <tr style="font-size: 18px; " >
      <td><c:out value="${policylist1.policyId}"></c:out></td>
       <td><c:out value="${policylist1.policyName }"></c:out></td>
       <td><c:out value="${policylist1.durationOfPolicy }"></c:out></td>
       <td><c:out value="${policylist1.premiumAmount }"></c:out></td>
       <td><c:out value="${policylist1.policytype }"></c:out></td>
       <td style="text-align: center;"> <button><a href="/customer/buypolicy?policyid=${policylist1.policyId}" style="color: black;">Buy Policy</a></button> </td>
    </tr>
    </c:forEach>
    </c:if>
    <c:if test="${searchlist!=null}">
    
      
      
      
    <tr><td>Search Category</td>
       <td>PolicyId</td><td>PolicyName</td><td>DurationOfPolicy</td>
       <td>Premium_Amount</td><td>PolicyType</td><td>Buy Policy</td>
       </tr>
<tr style="font-size: 18px; " >

		<td>${searchli}</td>
      <td><c:out value="${searchlist.policyId}"></c:out></td>
       <td><c:out value="${searchlist.policyName }"></c:out></td>
       <td><c:out value="${searchlist.durationOfPolicy }"></c:out></td>
       <td><c:out value="${searchlist.premiumAmount }"></c:out></td>
       <td><c:out value="${searchlist.policytype }"></c:out></td>
       <td> <button><a href="#" style="color: black;">Buy Policy</a></button> </td>
    </tr>
 </c:if>


      </table>

    
  
</div>
<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved

 
</div> </footer>

</body>
</html>