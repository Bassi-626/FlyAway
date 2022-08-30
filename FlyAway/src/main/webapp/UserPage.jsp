<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href=HomePage.jsp >FlyAway</a>
<br><br>

<h2>User Login</h2>

<form action=UserLogin method=post >
    
   Email :-<input type="email" name=email id=Email /><br>
   Password :-<input type="password" name=password id=Password /><br>
    <input type=submit value=submit type=reset /><br>
 </form>

<br><br>
<i>New User-Create account</i>
<h4><a href=UserRegistration.jsp >Create Account</a></h4>

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