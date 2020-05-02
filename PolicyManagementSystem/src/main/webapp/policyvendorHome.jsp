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
String type=(String) session.getAttribute("ptype");
int userid=(Integer)session.getAttribute("userId");
session.setAttribute("policyty",type);
session.setAttribute("uservid", userid);
if(username==null || userid==0)
{
	response.sendRedirect("/policyvendorlogin/");
}
%>
<div class="header"><header><b class="heading">Policy Management</b>

</header>

</div>
 <div class="topnav">
  <a href="/policyvendorHome.jsp" class="fas fa-home back">  My Home</a>
  <a href="/policyvendor/addpolicy1" class="fas fa fa-plus-square back"> Add Policy</a>
  <a href="/policyvendor/listpolicies" class="fas fa-user-alt back">  MyPolicies</a>
  <a href="/policyvendor/claims" class="fas fa-user-alt back">  SeeClaims</a>
  
  <a href="/policyvendor/logout/" class="fas fa-power-off back" style="float: right;">  Logout</a>
 <a href="/policyvendorHome.jsp" style="float: right;"> Welcome <%=username %>(<%=userid %>)</a>
   </div>
  
    <div class="card">
      <table align="center" class="tables back" border="1px solid">
      <c:if test="${policyl !=null}">
      <tr>
       <td>PolicyId</td><td>PolicyName</td><td>DurationOfPolicy</td>
       <td>Premium_Amount</td><td>PolicyType</td><td>Edit the Policy</td>
       </tr>
           <tr style="font-size: 18px; " >
      <td><c:out value="${policyl.policyId}"></c:out></td>
       <td><c:out value="${policyl.policyName }"></c:out></td>
       <td><c:out value="${policyl.durationOfPolicy }"></c:out></td>
       <td><c:out value="${policyl.premiumAmount }"></c:out></td>
       <td><c:out value="${policyl.policytype }"></c:out></td>
       <td> <button><a href="/policyvendor/editpolicy?policyid=${policyl.policyId}" style="color: black;">Edit Policy</a></button> </td>
    </tr>
</c:if>

<c:if test="${claimlist!=null}">
<tr>
<td>PaymentId</td>
<td>CustomerId</td>
<td>PolicyName</td>
<td>Reason for Claim</td>
<td>Status</td>
</tr>
<tr>
<td><c:out value="${claimlist.payid}"></c:out></td>
<td><c:out value="${claimlist.userid}"></c:out></td>
<td><c:out value="${claimlist.policyname}"></c:out></td>
<td><c:out value="${claimlist.reasonbyc}"></c:out></td>
<td> <button><a href="/policyvendor/acceptclaim?cid=${claimlist.claimid }" style="color: black;">Approve</a></button>
<button><a href="/policyvendor/rejectclaim?cid=${claimlist.claimid }" style="color: black;">Reject</a></button> </td>
</tr>
 
</c:if>
      </table>
 </div>
<c:if test="${message!=null }">  
   <script>alert('<c:out value="${message}"/>');
	            
				</script>  
				</c:if>
<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved
</div> </footer>
</body>
</html>