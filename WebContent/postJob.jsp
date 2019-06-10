<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Post a Job</title>
</head>
<body>
<h3>Post a Job</h3>
<form action="/JobPortal/PostJob" method="post" id ="postJobForm">
	Job Name: <input type ="text" name="jobname" /><br/>
	Poster Name: <input type ="text" name ="postername"/><br/>
	Password: <input type ="text" name ="password"/><br/>
	Contact Phone: <input type ="text"  name="contactphone"/><br/>
	Message Body: <textarea rows="10" name="messagebody">
	
	</textarea><br/>
	<input type="submit" name ="submit" value ="Submit"/>

</form>

</body>
</html>