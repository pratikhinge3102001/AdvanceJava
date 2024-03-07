<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action="controller" >
   	Uid : <input type="text" name="uid" />
   	<br/>
   	Pwd : <input type="text" name="pwd" />
   	<br/>
   	Fname : <input type="text" name="fname" />
   	<br/>
   	Lname : <input type="text" name="lname" />
   	<br/>
   	Email : <input type="text" name="email" />
   	<br/>
   	Contact : <input type="text" name="contact" />
   	<br/>
   	Age : <input type="text" name="age" />
   	<br/>
   	Area : <input type="text" name="area" />
   	<br/>
   	City : <input type="text" name="city" />
   	<br/>
   	Pincode : <input type="text" name="pincode" />
   	<br/>
   	Hobbies : <select name="hobbies" multiple>
   				<option value="Music">Music</option>
   				<option value="Art">Art</option>
   				<option value="Literature">Literature</option>
   				<option value="Dance">Dance</option>
   				<option value="Surfing">Surfing</option>
   				<option value="Gaming">Gaming</option>
   				<option value="Blogging">Blogging</option>
   			  </select>
   	<br/>
   	
   	<input type="submit" value="REGISTER" />
   	 
   </form>
</body>
</html>