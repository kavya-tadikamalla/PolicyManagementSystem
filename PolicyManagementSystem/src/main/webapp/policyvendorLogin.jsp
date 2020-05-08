<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
  <a href="/" class="fas fa fa-home back" >Home</a>
  <a href="/admin/" class="fas fa-user-circle back" >Admin</a>
 <a href="/policyvendor/" class="fas fa-user-plus back" >Policy Vendor</a>
 <a href="/customer/" class="fas fa-user-alt back" >Customer</a>

   </div>
   

<div class="card">
<b style="color:white; background-color: black;">${message}</b>

 <form:form action="/policyvendor/policyvendorlogin" method="post" modelAttribute="policyvendor" style="margin-top:50px;">

<table align="center" class="tables back"  >
<row style="width:40%">
<tr align="center"><td colspan="2" style="text-align: center;text-decoration-line: underline;">Login Form</td></tr>
<tr>
<td><i class="fas fa fa-user back" title="UserId" style="border-spacing:10px;"> UserId</i></td>
<td>
<form:input path="vendorId" class="form-control" required="required" placeholder="Enter your userId" title="Enter UserId" oninvalid="return useridv(this)"/><br>
</td>
 <form:errors path="vendorId" cssClass="errors"></form:errors> 

</tr>

<tr>
<td><i class="fa fa-key" title="Password"> Password</i> </td>
<td colspan="3"><form:password path="password" class="form-control" required="required" placeholder="Enter your Password" title="Enter Password" oninvalid="return passwordv(this)"/>
<br>

<form:errors path="password" cssClass="errors"></form:errors>
</td>
</tr>
<tr align="center">

<td colspan="2" style="text-align:center;"><input type="submit" value="Login" class="formsubmitbutton" /></td></tr>
		<tr><td colspan="2" style="text-align: center;"><label style="font-size: 15px;">NewPolicyVendor?<a href="/policyvendor/policyvendorreg" style="color:white;"> Register</a></label></td>

</tr>
<tr>
<td colspan="2" style="text-align: center;"><a href="pforgotuid" style="font-size: 15px;color:white;">Forgot Userid?</a>
<a href="pforgotpswd" style="font-size: 15px;color:white;">Forgot Password?</a> </td>
</tr>


</table>
</form:form>

<script type="text/javascript">
	function passwordv(textbox)
	{

		if(textbox.value=='')
			{
			
			/* textbox.setCustomValidity("Contact Number should not be emplty") */
			textbox.style.border="3px solid red";
			}
		else {  
	        textbox.setCustomValidity(""); 
	        textbox.style.border=""; 
	    } 
			
	}
	function useridv(textbox)
	{

		if(textbox.value=='')
			{
			
			/* textbox.setCustomValidity("Contact Number should not be emplty") */
			textbox.style.border="3px solid red";
			}
		else {  
	        textbox.setCustomValidity(""); 
	        textbox.style.border=""; 
	    } 
			
	}
	</script>

</div>
<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved
</div> 
</footer>

</body>
</html>