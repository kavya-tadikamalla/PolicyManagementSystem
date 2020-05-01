<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Policy Management-Admin</title>
<link rel="stylesheet" type="text/css" href="/style.css">
<script type="text/javascript" src='https://kit.fontawesome.com/a076d05399.js'></script>
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

 <form:form action="/policyvendor/policyvendorreg" method="post" modelAttribute="policyvendorreg" style="margin-top:50px;margin-left:30px;">

<table align="center" class="tables back" >
<tr>
<td></td>

<tr align="center">
<td colspan="4"  align="center"style="text-align: center;text-decoration-line: underline; ">
Registration Form</td></tr>
</tr>
<tr>
<td>VendorId<label style="color: red">*</label>:</td>
<td>

<form:input path="vendorId" class="form-control"/>

</td>
<td>Policy Vendor Name<label style="color: red">*</label>:</td>
<td>

<form:input path="policyvendorname" class="form-control" required="required" />

</td>
</tr>

<tr>

</tr>

<tr>
<td>Policy Vendor Reg. No<label style="color: red">*</label>:</td>
<td>

<form:input path="policyvendorregno" class="form-control" required="required" />

</td>
<td>Policy Type<label style="color: red">*</label>:</td>
<td>

<form:select path="policytype" class="form-control" required="required">
<form:option value="" label="--Select Policy Type--"/>
<form:option value="LifeInsurance" label="LifeInsurance"/>
<form:option value="MedicalInsurance" label="MedicalInsurance"/>
<form:option value="VehicleInsurance" label="VehicleInsurance"/>
</form:select>

</td>
</tr>


<tr>

</tr>

<tr>
<td>Address<label style="color: red">*</label>:</td>
<td>

<form:input path="address" class="form-control" required="required" />
</td>
<td>Country<label style="color: red">*</label>:</td>
<td>
<form:select path="country" class="form-control" required="required">
<form:option value="" label="--Select Country--"/>
<form:option value="US" label="US"/>
<form:option value="India" label="India"/>
<form:option value="UK" label="UK"/>
</form:select>

</td>
</tr>
<tr>

</tr>
<tr>
<td>State<label style="color: red">*</label>:</td>
<td>
<form:select path="State" class="form-control" required="required">
<form:option value="" label="--Select Policy Type--"/>
<form:option value="Telangana" label="Telangana"/>
<form:option value="AP" label="AP"/>
<form:option value="TN" label="TN"/>
</form:select>
</td>
<td>Zipcode<label style="color: red">*</label>:</td>
<td>

<form:input path="zipcode" class="form-control" required="required"/>
</td>
</tr>
<tr>

</tr>
<tr>
<td>DateOfBirth<label style="color: red">*</label>:</td>
<td><form:input path="dateOfBirth" type="date"/><br>
<td>Email address<label style="color: red">*</label>:</td>
<td>
<form:input  path="emailaddress" class="form-control" required="required" />
</td>
</tr>
<tr>

</tr>
<tr>
<td>Contact Number<label style="color: red">*</label>:</td>
<td>
<form:input path="contactnumber" class="form-control" required="required" />

</td>
<td>Web Site<label style="color: red">*</label>:</td>
<td>
<form:input path="website" class="form-control" required="required" />

</td>
</tr>
<tr>

</tr>
<tr>
<td>Certificate Issued Date<label style="color: red">*</label>:</td>
<td>
<form:input path="certificateissueddate" type="date" class="form-control" required="required" />

</td>
<td>Certificate Validity Date<label style="color: red">*</label>:</td>
<td>
<form:input path="certificatevaliditydate" type="date" class="form-control" required="required" />

</td>
</tr>
<tr>

</tr>
<tr>
<td>Year of Establishment<label style="color: red">*</label>:</td>
<td>
<form:input path="yearofestablishment" class="form-control" required="required" />

</td>
<td>Password<label style="color: red">*</label>:</td>
<td><form:password path="password" class="form-control" required="required" />

</td>
</tr>
<tr>

</tr>

<tr><td></td>
<td colspan="2" align="center"> <input type="submit" value="Register" class="formsubmitbutton" /><!-- </td> -->
<label style="font-size: 15px;">Existing PolicyVendor?</label><a href="/policyvendor/" style="color:white;"> SignIn</a></td></tr>
</table>
</form:form>

</div>
<footer>
<div class="footer">
&copy; Copyright 2020, All Rights Reserved
</div> 
</footer>
</body>
</html>