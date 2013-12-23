<%@ page import="pcrecipes.server.Recipes" %>
<%@ page import="pcrecipes.server.Recipe" %>
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
		<div id="addProduct">
				<h2 align=center>הוסף מרכיב</h2>
				<form  action = "FilterProd"  method ="post" >
				
					<input type="text" name="addItem" value="כתוב כאן">
				</form>
				<button>הוסף</button>
			</div>
		<div id="mainFrameQuestion">
			
			<!-- <div id="questions">-->
				<h2 id="question" align=center> כאן תהיה שאלה </h2>
				<ul id="answer">
					<li class="ans_choice">תשובה 1</li>
					<li class="ans_choice">תשובה 2</li>
					<li class="ans_choice">תשובה 3</li>
					<li class="ans_choice">תשובה 4</li>
					<li class="ans_choice">תשובה 5</li>
				</ul>
			<!--</div>-->
		</div>
		<div id="mainFrameResults">
		<h2 align=center>תוצאות חיפוש</h2>
		</div>
		<div id="footer2"></div>
		<div id="footer"></div>
	</body>	
</html>