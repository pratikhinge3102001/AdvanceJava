<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <%
    Cookie [] all = request.getCookies();
	if(all != null)
	{
		for(Cookie c : all)
		{
			if(c.getName().equals("loginerror"))
			{
				out.print(c.getValue());
			}
		}
	}     
    %>
    <!--<p>  ${cookie.loginerror.value} </p>-->
	<form action="logincheck" method="post">
		Uid : <input type="text" name="uid" />
		<br/>
		Password : <input type="password" name="pwd" />
		<br/>
		<input type="submit" value="LOGIN" />  
	</form>
	<br/>
	<a href="register.jsp"> New User? Register here </a>
</body>
</html>