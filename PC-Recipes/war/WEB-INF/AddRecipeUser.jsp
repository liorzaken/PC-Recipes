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
<title>User Recipe Manager</title>
</head>
<body>
<script type="text/javascript" language="javascript"
		src="script/script.js"></script>
<div id="header">
		<div id="headerRight">
			<div id="menu1">
				<ul>
					<li>הוסף מתכון</li>
					<li><a href="Main">דף הבית</a></li>
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
	<form action="RecipeUser" method="post" onsubmit="return validate();">
		<p>*שם מתכון:</p>
		<input type="text" name="recipeName" class="requiredAttr" />
		<p>*מצרכים: יש להפריד בין מצרך למצרך ע"י פסיק</p>
		<textarea name="products" rows="4" cols="65" class="requiredAttr" ></textarea>
		<p>*כמויות ויחידות: יש להפריד בין כמות לכמות ע"י פסיק, חובה להתאים לכל מצרך כמות עפ"י סדר כתיבת המצרכים.</p>
		<textarea name="amountUnit" rows="4" cols="65" class="requiredAttr"></textarea>
		<p>*תחליפים:</p>
		<textarea name="productSwap" rows="4" cols="65" class="requiredAttr"></textarea>
		<p>*הוראות הכנה:</p>
		<textarea name="Instruction" rows="20" cols="65" maxlength="2000" class="requiredAttr"></textarea>
		<p>שליחה</p>
		<input type="submit" name="Submit" value="submit"/><!--  onclick="alert('המתכון התקבל'); window.location='AddRecipeUser'" style="cursor: pointer; " />--> <input
			type="reset" value="reset" />
	</form>
</body>
</html>