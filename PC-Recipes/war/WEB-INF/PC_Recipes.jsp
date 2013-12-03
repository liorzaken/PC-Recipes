<%@ page import="pcrecipes.server.recipes" %>
<%@ page import="pcrecipes.server.recipe" %>
<%@page import="java.util.List;" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

﻿
<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
		<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
		<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> -->
		<meta http-equiv="Content-Language" content="he" />
		<title>PC-Recipes</title>
	</head>
	<body>
		<script type="text/javascript" language="javascript" src="jQuery.js"></script>
		<%@ include file="/WEB-INF/header.jsp" %>
		
		<div id="mainFrameQuestion">
			<div id="addProduct">
				<form>
					הוסף מרכיב: <input type="text" name="addItem" value="כתוב כאן">
				</form>
				<button>הוסף</button>
			</div>
			<div id="questions">
				<h2 id="question"> כאן תהיה שאלה </h2>
				<ul id="answer">
					<li class="ans_choice">תשובה 1</li>
					<li class="ans_choice">תשובה 2</li>
					<li class="ans_choice">תשובה 3</li>
					<li class="ans_choice">תשובה 4</li>
					<li class="ans_choice">תשובה 5</li>
				</ul>
			</div>
		</div>
		<div id="mainFrameResults">
		<h2>תוצאות</h2>
		</div>
		<div id="footer2"></div>
		<div id="footer"></div>
	</body>	
</html>