<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Page</title>
</head>
<body >
<br>
<a href=HomePage.jsp >FlyAway</a>
<br><br>

<h2>Admin Login</h2>

<form action=AdminLogin method=post>
	Email :-<input type="email" name=email id=Email /><br><br>
	Password :- <input type="password" name=password id=Password /><br><br>
	<input type=submit value=submit /> <input type=reset />
</form>

<a href=ForgotPassword.jsp >Forgot Password</a>

<%
	String message=(String)session.getAttribute("message");
	if(message!=null){
%>
<%=message %>
<%
		session.setAttribute("message", null);
	}
%>
</body>
</html>