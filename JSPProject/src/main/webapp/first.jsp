<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.Calendar"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>JSP el</title>
</head>
<body>
	<h1> Welcome to world of JSP </h1>
	<br/>
	This is template text which is without tag
	<br/>
	<!--  This is comment in HTML -->
	<%-- This is comment in JSP --%>
	<%
	   int n=0;
	   n++;
	   out.println("Value of n : "+n);
	%>
	<br/>
	<%=  Calendar.getInstance().getTime()   %>
	<br/>
	<%! int count; %>
	<%= "Count : "+(++count) %>
</body>
</html>




