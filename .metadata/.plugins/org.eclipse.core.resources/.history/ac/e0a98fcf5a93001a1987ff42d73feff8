<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Login</title>
<link rel="stylesheet" type="text/css" href="/style1.css"/>
<script type="text/javascript">
function validate(){
	var pwd=document.getElementById("password").value;
	 if(pwd==""){
			document.getElementById("password").style.borderColor = "red";
			alert("please update mandatory highlighted fields");
				return false;
			}
	 else if(pwd!=cpwd)
	 {
	 document.getElementById("password").style.borderColor = "red";
	 document.getElementById("cpassword").style.borderColor = "red";
		alert("Password and confirm password are not same");
			return false;
	 }
}

</script>
</head>
<body>
<div class="header">
<h1>Policy Management </h1>
</div>
<h2>Reset password</h2>
<div class="formdata">
<div align="center">
<form:form onsubmit="return validate()" action="updatepwd" method="post" modelAttribute="name1">
<table>
<tr>
<tr>
<td>
<form:hidden path="uid"/>
</td>
</tr>
<tr>
<td>Password:</td>
<td><form:input path="pwd" class="formcontrol" id="password" type="password"/></td>
</tr>
<tr>
<td>Confirm Password:</td>
<td><input type="password" id="cpassword"></td>
</tr>
</table>
<input type="submit" value="submit" class="formsubmitbutton"/>
</form:form>
Want to login?<a href="adminLogin">Click here</a>
<br>
<br>
${message}
</div>
</div>
</body>
<%

RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
rd.include(request, response);

%>
</html>