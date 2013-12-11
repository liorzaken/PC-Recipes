<%@ page import="pcrecipes.server.Recipes"%>
<%@ page import="pcrecipes.server.Recipe"%>
<%@page import="java.util.List;"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type"
	content="text/html; charset=windows-1255">
<title>Recipe Manager</title>
</head>
<body>
	<form action="AddRecipe" method="post">
		<p>שם מתכון:</p>
		<input type="text" name="recipeName">
		<p>קטגוריה:</p>
		<input type="text" name="category">
		<p>מצרכים:</p>
		<input type="text" name="products">
		<p>תחליפים:</p>
		<input type="text" name="productSwap">
		<p>הוראות הכנה:</p>
		<input type="text" name="Instruction">
		<p>שליחה</p>
		<input type="submit" name="Submit" value="submit">
	</form>
</body>
</html>