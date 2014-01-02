<%@ page import="pcrecipes.server.Recipe"%>
<%@page import="dbManager.DataBaseManager"%>
<%@page import="java.util.List;"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
﻿
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="style/stylesheet.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->
<meta http-equiv="Content-Language" content="he" />
<title>PC-Recipes - RecipePage</title>
</head>
<body>
	<%
		List<Recipe> list;
		if (session.getAttribute("nameRecipe") == null) {
			list = DataBaseManager.getInstance().getAllRecipes();
		} else {
			list = DataBaseManager.getInstance().getRecipeByName(
					session.getAttribute("nameRecipe").toString());
		}
	%>
	<%
		for (Recipe item : list) {
	%>
	<div id="header">
		<div id="headerRight">
			<div id="menu1">
				<ul>

					<li><%=item.get_nameRecipe()%></li>
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
	<div id="mainFrame">
		<p>קטגוריות:</p>
		<p>	<%=item.CategoryStr()%></p>

		<p>מצרכים:</p>
		<table>
			<%
				for (int i = 0; i < item._products.length; i++) {
			%>
			<tr>
				<td><%=i + 1%>.</td>
				<td><%=item._products[i]%></td>
				<td><%=item._unit[i]%></td>
			</tr>
			<%
				}
			%>
		</table>

		<p>הערות למצרכים חלופיים:</p>
		<p>
			<%=item.get_swapProd()%>
		</p>

		<p>אופן ההכנה:</p>
		<p>
			<%=item.get_instruction().getValue()%>
		</p>
	</div>

	<%
		break;
		}
	%>
	<a href="Main">חזרה לעמוד הראשי</a>
	<div id="footer2"></div>
	<div id="footer"></div>
</body>
</html>

