<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix ="c" uri ="http://java.sun.com/jsp/jstl/core" %>
<meta charset="UTF-8">
<title>View Jobs</title>
</head>
<body>
<table>
<tr>
	<td>Job Name</td>
	<td>Job Message</td>
	<td>Job Poster</td>
	<td>Contact Phone</td>
</tr>
<c:forEach items = "${jobs}" var="job">
<tr>
	<td>${job.jobName}</td>
	<td>${job.messageBody}</td>
	<td>${job.posterName}</td>
	<td>${job.contactPhone}</td>
</tr>
</c:forEach>
</table>
</body>
</html>