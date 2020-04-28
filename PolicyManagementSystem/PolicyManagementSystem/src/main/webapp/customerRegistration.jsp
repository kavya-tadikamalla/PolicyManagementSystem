<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy Management-Customer</title>
<link rel="stylesheet" type="text/css" href="/style.css">
<script src='https://kit.fontawesome.com/a076d05399.js'>
function validation()
{
	var firstname=document.register.firstName.value;
	var lastname=document.register.lastName.value;
	var email=document.register.email.value;
	var number=document.register.contactNumber.value;
	var userid=document.register.userId.value;
	var password=document.register.password.value;
	if(firstname==""|| firstname==null)
	{
	alert("please update the highlighted mandatory fields");
	document.getElementById('firstName');
	return false;
	}
	if(lastname==""|| lastname==null)
	{
	  alert("Please update the highlighted mandatory field(s).");
	  document.getElementById('lastName');
	  return false;
	}
	if(email==null || email =="")
	{
		alert("Please update the highlighted mandatory field(s).");
		 document.getElementById('email');
		 return false;
	}
	if(number==""|| number==null)
	{
		 alert("Please update the highlighted mandatory field(s).");
		 document.getElementById('ContactNumber');
		 return false;
	}
	if(userid==""|| userid==null)
	{
		alert("Please update the highlighted mandatory field(s).");
		document.getElementById('UserId');
		return false;
		 
	}
	if(password==""|| password==null)
	{
		alert("Please update the highlighted mandatory field(s).");
		document.getElementById('password');
		return false;
	}
}

</script>
<style type="text/css">
tr,td{
text-align: left;
}
</style>
</head>
<body>
<div class="header"><header><b class="heading">Policy Management</b></header></div>
<div class="topnav">
  <a href="/home/" class="fas fa fa-home back" >Home</a>
  <a href="/admin/" class="fas fa-user-circle back" >Admin</a>
 <a href="/policyvendor/" class="fas fa-user-plus back" >Policy Vendor</a>
 <a href="/customer/" class="fas fa-user-alt back" >Customer</a>

   </div>
<div class="card">
<h2>Registration Form</h2>

 <form:form name="register" action="/customer/customerregistration" method="post" modelAttribute="customerreg" onsubmit="return validation()" style="margin-top:50px;margin-left:30px;">
	<table align="center" class="tables back">
		<tr>
			<td>UserId<label style="color: red">*</label>:</td>
			<td><form:input path="userId" id="UserId" class="form-control" /><br>
				<form:errors path="userId" ></form:errors></td>
		</tr>
		<tr>
			<td>First Name<label style="color: red">*</label>:</td>
			<td><form:input path="firstName" id="firstName"/><br>
				<form:errors path="firstName" ></form:errors></td>
		</tr>
		<tr>
			<td>Last Name<label style="color: red">*</label>:</td>
			<td><form:input path="lastName" id="lastName" /><br>
				<form:errors path="lastName" ></form:errors></td>
		</tr>
		<tr>
			<td>Contact Number<label style="color: red">*</label>:</td>
			<td><form:input path="contactNumber"  id="contactNumber" /><br>
				<form:errors path="contactNumber" ></form:errors></td>
		</tr>
		<tr>
			<td>DateOfBirth<label style="color: red">*</label>:</td>
			<td><form:input path="dateOfBirth" type="date"/><br>
				<form:errors path="dateOfBirth" ></form:errors></td>
		</tr>
		<tr>
			<td>Email<label style="color: red">*</label>:</td>
			<td><form:input path="email" id="email" /><br>
				<form:errors path="email" ></form:errors></td>
		</tr>
		<tr>
			<td>Password<label style="color: red">*</label>:</td>
			<td><form:password path="password" id="password"/><br>
				<form:errors path="password" ></form:errors></td>
		</tr>
		
		
		<tr>
			<td>Gender<label style="color: red">*</label>:</td>
			<td>Male <form:radiobutton path="gender" value="Male"/>  
				Female <form:radiobutton path="gender" value="Female"/><br></td>
		</tr>
		
		<tr>
		<td colspan="3" align="center"><input type="submit" value="Register" />
		</tr>
	</table>
 </form:form>
 Existing User<a href="/customer/"> SignIn</a>
</div>
<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved
</div> 
</footer>
</body>
</html>