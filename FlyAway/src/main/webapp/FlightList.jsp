<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ page import="java.util.*" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight List</title>
</head>
<body >
<br>
<a href=HomePage.jsp>FlyAway</a>
<br><br>
<%
	@SuppressWarnings("unchecked")
	List<String[]> flights=(List<String[]>)session.getAttribute("flights");
	if(flights!=null){
%>

<h1>Available Flights</h1>

<%
	for(String[] flight:flights){
%>
NAME :
<%=flight[0]%><br>

TIME OF TAKEOFF :
<%=flight[1]%><br>

TIME OF LANDING :
<%=flight[2]%><br>

PRICE :
<%=flight[3] %><br>
<br><br>


 

<h3>IF LOGGED IN CLICK TO PAY NOW</h3>
<a href=BookFlight.jsp>Pay Now</a>
<%
	}
%>

<%
	}
	else{
%>
<h1>There are no available flights</h1>
<%
	}
%>
</body>
</html>