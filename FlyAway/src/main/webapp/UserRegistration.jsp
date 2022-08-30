<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<a href=HomePage.jsp>FlyAway</a>
<br><br>


<form action=UserRegistration method=post>
	EMAIL :- <input type="email" name=email id=Email /><br><br>
	PASSWORD :- <input type="password" name=password id=Password /><br><br>
	NAME :- <input type="text" name=name id=Name /><br><br>
	PHONE NUMBER :- <input type="text" name=phno id=PhoneNumber /><br><br>
	AADHAR NUMBER :- <input type="text" name=adno id=AadharNumber /><br><br>
	<input type=submit value=submit /> <input type=reset />
</form>

</body>
</html>