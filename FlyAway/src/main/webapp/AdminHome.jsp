<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin Home</title>
</head>
<body >
<br>
<a href=HomePage.jsp >FlyAway</a>
<br><br>

<h1>Insert New Flight Details</h1>


<form action=InsertFlight method=post>
	NAME :- <input type="text" name=name id=Name /><br><br>
	SOURCE :- <input type="text" name=source id=Source /><br><br>
	DESTINATION :- <input type="text" name=destination id=Destination /><br><br>
	FLIGHT AVAILABLE :-  <input type="date" name=date id=Date /><br><br>
	TIME IN :- <input type="time" name=timein id=Time_In /><br><br>
	TIME OUT :- <input type="time" name=timeout id=Time_Out /><br><br>
	PRICE :- <input type="text" name=price id=Price /><br><br>
	<input type=submit value=submit /> <input type=reset />
</form>

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