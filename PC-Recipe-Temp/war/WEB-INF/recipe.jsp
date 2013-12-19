<%@ page import="pcrecipes.server.Products"%>
<%@ page import="pcrecipes.server.ProductExtend"%>
<%@ page import="pcrecipes.server.Recipe"%>
<%@page import="dbManager.DataBaseManager"%>
<%@page import="java.util.List;"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

﻿
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="stylesheet.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->
<meta http-equiv="Content-Language" content="he" />
<title>PC-Recipes - RecipePage</title>
</head>
<body>
<%
List<Recipe> r;%>
	
	<% r  = DataBaseManager.getInstance().getRecipe(
			session.getAttribute("recipeName").toString()); %>
	<div id="header">
		<div id="headerRight">
			<div id="menu1">
				<ul>
					<li><a>
							<%
								r.get(0).get_nameRecipe();
							%>
					</a></li>
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


		}
		<%
		ProductExtend[] p = r.get(0).get_Products();
	%>

		<p>מצרכים:</p>

		<ul>
			<%
				for (ProductExtend item : p) {
			%>
			<li>
				<%
					item.get_prod().get_nameProd();
						item.get_amountUnit();
				%>
			</li>
			<%
				}
			%>
		</ul>
	</div>
	<div id="mainFrame">
		<p>אופן ההכנה:</p>
		<ol>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
			<li></li>
		</ol>
	</div>


	<div id="footer2"></div>
	<div id="footer"></div>
</body>
</html>

