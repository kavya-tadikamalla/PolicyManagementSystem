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
  <a href="/customerHome.jsp" class="fas fa-home back">  My Home</a>
  <a href="/customer/listofpolicies" class="fas fa-user-plus back">  List of Policies</a>
  <a href="/customer/listofmypolicies" class="fas fa-user-circle back"> MyPolicies</a>
  <a href="/customer/notify" class="far fa-bell back">PaymentNotification </a>
  <a href="/customer/beforehelp" class="fas fa-user-alt back">Help</a>
  <a href="/customer/logout/" class="fas fa-power-off back" style="float: right;">  Logout</a>
  <a href="/customerHome.jsp" style="float: right;"> Welcome <%=username %>(<%=userid %>)</a>
   <a href="/customer/searchp" class="fas fa fa-search" style="float: right;"></a>
   </div>
   
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
    <tr>
       <td>PolicyId</td><td>PolicyName</td><td>DurationOfPolicy</td>
       <td>Premium_Amount</td><td>PolicyType</td><td>Buy Policy</td>
       </tr>
       <c:forEach items="${searchlist}" var="searchlist1">
<tr style="font-size: 18px; " >
      <td><c:out value="${searchlist1.policyId}"></c:out></td>
       <td><c:out value="${searchlist1.policyName }"></c:out></td>
       <td><c:out value="${searchlist1.durationOfPolicy }"></c:out></td>
       <td><c:out value="${searchlist1.premiumAmount }"></c:out></td>
       <td><c:out value="${searchlist1.policytype }"></c:out></td>
       <td> <button><a href="#" style="color: black;">Buy Policy</a></button> </td>
    </tr>
    </c:forEach>
 </c:if>
 <c:if test="${mypol!=null }">
 <c:if test="${mypol1!=null }">
 <tr>
       <td>PolicyId</td><td>PolicyName</td><td>DurationOfPolicy</td>
       <td>Premium_Amount</td><td>PolicyType</td><td>lastpaid date</td>
       <td>fine amount</td><td>Total Bill Amount</td><td>PayBill</td>
       </tr>
 <c:forEach items="${ mypol}" var="mypolicy">
 <td>${mypolicy.policyId}</td>
 <td>${mypolicy.policyName}</td>
 <td>${mypolicy.durationOfPolicy}</td>
 <td>${mypolicy.premiumAmount}</td>
 <td>${mypolicy.policytype}</td>
  </c:forEach>
 <c:forEach items="${mypol1}" var="mypolicy1">

 <td>${mypolicy1.lastpaid}</td>
 <td>${mypolicy1.fineamount}</td>
 <td>${mypolicy1.fineamount+mypolicy1.amount}</td>
 
 </c:forEach>
 <td> <button><a href="#" style="color: black;">Pay Bill</a></button> </td>
 </c:if>
 </c:if>
 
 <c:if test="${noofdays1!=null }">  
   <script>alert('<c:out value="${noofdays1}"/>');
	            window.location="/customerHome.jsp";
				</script>  
				</c:if>
 
<c:if test="${notify!=null }">
 <c:if test="${notify1!=null }">
 
  
 <tr>
       <td>PolicyId</td><td>PolicyName</td>
       <td>PolicyType</td><td>lastpaid date</td><td>nextpay date</td>
       <td>Total Bill Amount</td><td>PayBill</td>
       </tr>
 <c:forEach items="${ notify1}" var="notf1">
 <td>${notf1.policyId}</td>
 <td>${notf1.policyName}</td>
 <td>${notf1.policytype}</td>
  </c:forEach>
 <c:forEach items="${notify}" var="notf">

 <td>${notf.lastpaid}</td>
 <td>${notf.nextpayDate}</td>
 <td>${notf.fineamount+notf.amount}</td>
 
 </c:forEach>
 <td> <button><a href="#" style="color: black;">Pay Bill</a></button> </td>

 <button ><a href="#" class="far fa-bell back" style="color: black;text-decoration: none;">MonthlyPayments</a></button>&nbsp
  <button style="color: black;"><a href="#" class="far fa-bell back" style="color: black;text-decoration: none;"> QuaterlyPayments</a></button>&nbsp
  <button style="color: black;"><a href="#" class="far fa-bell back" style="color: black;text-decoration: none;"> HalfyearlyPayments</a></button>&nbsp
  <button style="color: black;"><a href="#" class="far fa-bell back" style="color: black;text-decoration: none;"> YealyrPayments</a></button>
 </c:if>
 </c:if>


      </table>
    <c:if test="${message!=null }">  
   <script>alert('<c:out value="${message}"/>');
	            
				</script>  
				</c:if>

</div>
<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved

 
</div> </footer>

</body>
</html>