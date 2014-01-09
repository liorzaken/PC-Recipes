<%@ page import="pcrecipes.server.Recipe"%>
<%@page import="java.util.List;"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link type="text/css" rel="stylesheet" href="style/recipeStyle.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<meta http-equiv="Content-Language" content="he" />
<title>Recipe Manager</title>
</head>
<body>
<div id="header">
		<div id="headerRight">
			<div id="menu1">
				<ul>

					<li>הוסף מתכון</li>
				</ul>
			</div>
		</div>
		<div id="headerLeft">
			<a href="Main"><img
				src="https://raw.github.com/liorzaken/PC-Recipes/master/Images/PC-Recipes-B-small.jpg"></a>
		</div>
	</div>
	<div id="header2"></div>


	<div id="headerLeft">
		<p>
			<img width="380" height="260"
				src="https://github.com/liorzaken/PC-Recipes/blob/master/Images/images%20(1).jpg?raw=true">
		</p>
	</div>
	<form action="AddRecipe" method="post">
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
		<textarea name="Instruction" rows="20" cols="65" maxlength="2000"></textarea>
		<p>שליחה</p>
		<input type="submit" name="Submit" value="submit" /> <input
			type="reset" value="reset" />
	</form>
</body>
</html>