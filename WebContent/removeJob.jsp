<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>Remove a Job</title>
</head>
<body>
<h3>Remove a job</h3>
<c:if test="${error != null"><p>Incorrect Password.</c:if>
<form action ="/JobPortal/RemoveJob" method ="post">
	Job ID: <input type="text" name="id"/><br/>
	Password: <input type ="text" name ="password"/><br/>
	<input type="submit" name="submit" value="Submit"/>
</form>
</body>
</html>