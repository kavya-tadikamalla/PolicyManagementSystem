<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy Management-Admin</title>
<link rel="stylesheet" type="text/css" href="/style.css">
<script type="text/javascript" src='https://kit.fontawesome.com/a076d05399.js'>
function validate(textbox)
{

	if(textbox.value=='')
		{
		
		textbox.setCustomValidity("Address field should not be emplty")
		textbox.style.border="2px solid red";
		} 

}

</script>
</head>
<body>
<div class="topnav">
  <b class="heading">Policy Management</b>
  
  <a href="/policyvendor/" class="fas fa-user-plus back">  Policy Vendor</a>
  <a href="/customer/" class="fas fa-user-alt back">  Customer</a>
  <a href="/admin/" class="fas fa-user-circle back">  Admin</a>
   </div>
<div class="card">
<h2>Registration Form</h2>
 <form:form action="/policyvendor/policyvendorreg" method="post" modelAttribute="policyvendorreg" style="margin-top:50px;margin-left:30px;">

<table align="center" class="tables back" >
<tr>
<td>VendorId<label style="color: red">*</label>:</td>
<td>

<form:input path="vendorId" class="form-control"/>

</td>
</tr>

<tr>
<td>Policy Vendor Name<label style="color: red">*</label>:</td>
<td>

<form:input path="policyvendorname" class="form-control" required="required" oninvalid="setCustomValidity('Name should not be empty');"/>

</td>
</tr>

<tr>
<td>Policy Vendor Reg. No<label style="color: red">*</label>:</td>
<td>

<form:input path="policyvendorregno" class="form-control" required="required"/>

</td>
</tr>


<tr>
<td>Policy Type<label style="color: red">*</label>:</td>
<td>

<form:select path="policytype" class="form-control">
<form:option value="LifeInsurance" label="LifeInsurance"/>
<form:option value="MedicalInsurance" label="MedicalInsurance"/>
<form:option value="VehicleInsurance" label="VehicleInsurance"/>
</form:select>

</td>
</tr>

<tr>
<td>Address<label style="color: red">*</label>:</td>
<td>

<form:input path="address" class="form-control" required="required" oninvalid="validate(this)"/>
</td>
</tr>
<tr>
<td>Country<label style="color: red">*</label>:</td>
<td>
<form:select path="country" class="form-control">
<form:option value="US" label="US"/>
<form:option value="India" label="India"/>
<form:option value="UK" label="UK"/>
</form:select>

</td>
</tr>
<tr>
<td>State<label style="color: red">*</label>:</td>
<td>
<form:select path="State" class="form-control">
<form:option value="Telangana" label="Telangana"/>
<form:option value="AP" label="AP"/>
<form:option value="TN" label="TN"/>
</form:select>
</td></tr>
<tr>
<td>Zipcode<label style="color: red">*</label>:</td>
<td>

<form:input path="zipcode" class="form-control"/>
</td>
</tr>
<tr>
<td>DateOfBirth<label style="color: red">*</label>:</td>
<td><form:input path="dateOfBirth" /><br>

</tr>
<tr>
<td>Email address<label style="color: red">*</label>:</td>
<td>
<form:input type="email" path="emailaddress" class="form-control" required="required"  />
</td>
</tr>
<tr>
<td>Contact Number<label style="color: red">*</label>:</td>
<td>
<form:input path="contactnumber" class="form-control"/>

</td>
</tr>
<tr>
<td>Web Site<label style="color: red">*</label>:</td>
<td>
<form:input path="website" class="form-control"/>

</td>
</tr>
<tr>
<td>Certificate Issued Date<label style="color: red">*</label>:</td>
<td>
<form:input path="certificateissueddate" class="form-control"/>

</td>
</tr>
<tr>
<td>Certificate Validity Date<label style="color: red">*</label>:</td>
<td>
<form:input path="certificatevaliditydate" class="form-control"/>

</td>
</tr>
<tr>
<td>Year of Establishment<label style="color: red">*</label>:</td>
<td>
<form:input path="yearofestablishment" class="form-control"/>

</td>
</tr>
<tr>
<td>Password<label style="color: red">*</label>:</td>
<td><form:password path="password" class="form-control" />

</td>
</tr>

<tr>
<td colspan="2" align="center"><input type="submit" value="Register" class="formsubmitbutton" />

</tr>
</table>
</form:form>
Existing PolicyVendor<a href="/policyvendor/" style="color:slateblue;"> SignIn</a>
</div>
<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved
</div> 
</footer>
</body>
</html>