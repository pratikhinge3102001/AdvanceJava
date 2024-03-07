<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Topics</title>
</head>
<body>
<ol>
   <c:forEach var="topic" items= "${applicationScope.topiclist}">
      <li>
          <a href=""></a>
  
   
   </c:forEach>
</ol>
        


</body>
</html>