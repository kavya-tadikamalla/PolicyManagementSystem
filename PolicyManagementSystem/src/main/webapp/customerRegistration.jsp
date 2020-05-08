<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy Management-Customer</title>
<link rel="stylesheet" type="text/css" href="/style.css">
<script src='https://kit.fontawesome.com/a076d05399.js'></script>
<style type="text/css">
tr,td{
text-align: left;
}

</style>
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
 <form:form action="/customer/customerregistration" method="post" modelAttribute="customerreg" style="margin-top:50px;margin-left:30px;" onsubmit="return validate();" >
	<table align="center" class="tables back">
	<tr align="center"><td colspan="4" style="text-align: center;text-decoration-line: underline;">Registration Form</td></tr>
		<tr>
			<td>UserId<label style="color: red">*</label>:</td>
			<td><form:input path="userId" class="form-control" required="required" /></td>
			<td>First Name<label style="color: red">*</label>:</td>
			<td><form:input path="firstName" required="required" oninvalid="namevalidate(this)" /></td>
		</tr>
		
		<tr>
			<td>Last Name<label style="color: red">*</label>:</td>
			<td><form:input path="lastName" required="required" oninvalid="lnamevalidate(this)"/></td>
			<td>Contact Number<label style="color: red">*</label>:</td>
			<td><form:input path="contactNumber" type="tel"  pattern="[6-9]{1}[0-9]{9}" required="required"  title="Enter a 10 digit contact number starting with [6 or 7 or 8 or 9]. e.g. 7895236419" oninvalid="contactnum(this)"/></td>
		</tr>
		
		<tr>
			<td>DateOfBirth<label style="color: red">*</label>:</td>
			<td><form:input path="dateOfBirth" type="date" required="required" oninvalid="return dob(this)"/></td>
			<td>Email<label style="color: red">*</label>:</td>
			<td><form:input path="email" type="email" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" title="email should contain '@' and '.' eg. abcd@xyz.com" required="required" oninvalid="return emailid(this)" /></td>
		</tr>
		<tr>
		<td>Password<label style="color: red">*</label>:</td>
			<td><form:password path="password" id="pwd" required="required" oninvalid="return passwordv(this)"/></td>
		<td>Confirm Password<label style="color: red">*</label>:</td>
			<td><input type="password" id="cpwd" required="required" oninvalid="return cpasswordv(this)"></td>
		</tr>
		<tr>
			<td>Gender<label style="color: red">*</label>:</td>
			<td> <form:radiobutton path="gender" value="Male" required="required" oninvalid="return genderv(this)"/>Male  
				<form:radiobutton path="gender" value="Female" required="required" oninvalid="return genderv(this)"/>Female<br></td>
				
		</tr>
		<td>Secret Question 1:</td>
<td>
<form:select path="secretquestion1" id="secretquestion1" class="select-box" required="required">
<option  selected="selected" value="What is your Birthdate?">What is your Birthdate?</option>
  <option value="In which school you have studied first?">In which school have you studied first?</option>
  <option value="What is your favourite color?">What is your favourite color?</option>
</form:select>

</td>
<td colspan="2" align="right">
<form:input path="answer1" id="answer1" placeholder="Answer" width="170px" required="required"/></td>
</tr>

<tr>
<td>Secret Question 2:</td>
<td>
<form:select path="secretquestion2" id="secretquestion2" class="select-box" required="required" >
<option  selected="selected" value="What is your favourite place?">What is your favourite place?</option>
  <option value="What is your parent's anniversary?">What is your parent's anniversary?</option>
  <option value="What is your highest education?">What is your highest education?</option>
</form:select>
</td>
<td colspan="2" align="right">
<form:input path="answer2" id="answer2" placeholder="Answer" width="170px" required="required"/>
</td>
</tr>
<tr>

</tr>
<tr>
<td>Secret Question 3:</td>
<td>
<form:select path="secretquestion3" id="secretquestion3" class="select-box" required="required" >
<option  selected="selected" value="What is your favourite comic?">What is your favourite comic?</option>
  <option value="What is your hometown?">What is your hometown?</option>
  <option value="In what town or city did you meet your spouse/partner?">In what town or city did you meet your spouse/partner?</option>
</form:select>
</td>
<td colspan="2" align="right">
<form:input path="answer3" id="answer3" placeholder="Answer" width="170px" required="required" />
</td>
</tr>
		<tr align="center">
		<td colspan="4" style="text-align: center;"><input type="submit" value="Register" />
		<label style="font-size: 15px;">Existing Customer?</label><a href="/customer/" style="color:white;"> SignIn</a></td>
		</tr>
	</table>
 </form:form>
 
</div>

<script type="text/javascript">
function validate(){
	var c=document.getElementById("cpwd").value;
	var p=document.getElementById("pwd").value;
	if(p!=c)
		{
			alert("Password and Confirm Password are not same");
			return false;
		}
	
}
function namevalidate(textbox)
{

	if(textbox.value=='')
		{
		
		textbox.setCustomValidity("Name field should not be emplty") 
		textbox.style.border="3px solid red";
		
		}
	else {  
		textbox.style.border="white"; 
        textbox.setCustomValidity(""); 
    } 
	
}
function lnamevalidate(textbox)
{

	if(textbox.value=='')
		{
		
		textbox.setCustomValidity("Name field should not be emplty")
		textbox.style.border="3px solid red";
		}
	else {  
		textbox.style.border="white"; 
        textbox.setCustomValidity("");
    } 
	
}
function contactnum(textbox)
{

	if(textbox.value=='')
		{
		
		/* textbox.setCustomValidity("Contact Number should not be emplty") */
		textbox.style.border="3px solid red";
		}
	else {  
		textbox.style.border="white"; 
        textbox.setCustomValidity("");
    } 
		
}
function dob(textbox)
{

	if(textbox.value=='')
		{
		
		/* textbox.setCustomValidity("Contact Number should not be emplty") */
		textbox.style.border="3px solid red";
		}
	else {  
		textbox.style.border="white"; 
        textbox.setCustomValidity("");
    } 
		
}
function emailid(textbox)
{

	if(textbox.value=='')
		{
		
		/* textbox.setCustomValidity("Contact Number should not be emplty") */
		textbox.style.border="3px solid red";
		}
	else {  
		textbox.style.border="white"; 
        textbox.setCustomValidity("");
    } 
		
}
function passwordv(textbox)
{

	if(textbox.value=='')
		{
		
		/* textbox.setCustomValidity("Contact Number should not be emplty") */
		textbox.style.border="3px solid red";
		}
	else {  
		textbox.style.border="white"; 
        textbox.setCustomValidity("");
    } 
		
}
function cpasswordv(textbox)
{

	if(textbox.value=='')
		{
		
		/* textbox.setCustomValidity("Contact Number should not be emplty") */
		textbox.style.border="3px solid red";
		}
	else {  
		textbox.style.border="white"; 
        textbox.setCustomValidity(""); 
    } 
		
}
function genderv(textbox)
{

	if(textbox.value=='')
		{
		
		/* textbox.setCustomValidity("Contact Number should not be emplty") */
		textbox.style.border="3px solid red";
		}
	else {  
		textbox.style.border="white"; 
        textbox.setCustomValidity(""); 
    } 
		
}

</script>


<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved
</div> 
</footer>
</body>
</html>