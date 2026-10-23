<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.entity.Student"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UPADTE BOOK FORM</title>
<link rel="stylesheet" type="text/css" href="css/form.css">
</head>
<body>

	<%
	Student student = (Student) request.getAttribute("book");
	%>

	<h2>BOOK UPDATE FORM</h2>

	<form action="updateBook" method="post">
		<label>ID</label><br> <input type="text" name="id" value="<%=student.getId()%>" readonly><br> 
		
		<label>NAME</label><br>
		<input type="text" name="title" value="<%=student.getName()%>"><br>

		<label>MARKS</label><br>
		<input type="text" name="author" value="<%=student.getMarks()%>"><br> 
		<input type="submit" value="UPDATE">
	</form>

</body>
</html>