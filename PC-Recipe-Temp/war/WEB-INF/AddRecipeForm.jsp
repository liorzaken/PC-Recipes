<%@ page import="pcrecipes.server.Recipe"%>
<%@page import="java.util.List;"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Language" content="he" />
<title>Recipe Manager</title>
</head>
<body>
	<form action="AddRecipe" method="get">
		<p>שם מתכון:</p>
		<input type="text" name="recipeName">
		<p>מספרי תשובות:</p>
		<input type="text" name="category" size="100" maxlength="200" />
		<p>מצרכים:</p>
		<textarea name="products" rows="4" cols="65"></textarea>
		<p>כמויות ויחידות:</p>
		<textarea name="amountUnit" rows="4" cols="65"></textarea>
		<p>תחליפים:</p>
		<textarea name="productSwap" rows="4" cols="65"></textarea>
		<p>הוראות הכנה:</p>
		<textarea name="Instruction" rows="8" cols="65"></textarea>
		<p>שליחה</p>
		<input type="submit" name="Submit" value="submit"> <input
			type="reset" value="reset">
	</form>
</body>
</html>