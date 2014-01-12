<%@ page import="pcrecipes.server.Recipe"%>
<%@ page import="pcrecipes.server.Questions"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Random"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

﻿
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="style/stylesheet.css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> -->
<meta http-equiv="Content-Language" content="he" />
<title>PC-Recipes</title>
</head>
<script>
    $(document).ready( function() {
    	hideAns();
    	$('#endOfQuestion').hide(); 
    });
    </script>
<body>
	<%
		Random r = new Random();

		int[] qFinish = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0 };
		Questions q = new Questions();
		int i = 0, flag = 0;
		Questions questionsArray[] = q.inputQuest();
		String[] arrayAnswer = q.inputAnswer();
		arrayAnswer = q.inputAnswer();
		//Search searchArr = new Search();	
		//	q.inputQuest(questionsArray);
	%>


	<script type="text/javascript" language="javascript"
		src="script/script.js"></script>
	<%@ include file="/WEB-INF/header.jsp"%>
	<div id="addProduct">
		<h2 align=center>הוסף מרכיב</h2>
		<!-- <form action = "FilterProd" method="get">-->

		<input type="text" name="addItem" value="כתוב כאן"
			onfocus="if(this.value == 'כתוב כאן') { this.value = ''; }"
			onblur="if(this.value == '') { this.value = 'כתוב כאן'; }">
		<!--</form>-->
		<button id="addProd">הוסף</button>
		<button id="clearProds">נקה</button>
		<br />
		<div class="listProd">
			<div id=ProdsView></div>
		</div>
	</div>
	<div class="FrameQuestion">
		<div id="mainFrameQuestion">
			<h2 id="question" align=center>
				<%=questionsArray[0].getQuestion()%>
			</h2>
			<ul id="answer">
				<li><div id="endOfQuestion">סוף מאגר השאלות</div></li>
				<li><div id="ansr1"><%=arrayAnswer[questionsArray[0].getAnswerID()[0]]%></div></li>
				<li><div id="ansr2"><%=arrayAnswer[questionsArray[0].getAnswerID()[1]]%></div></li>
				<li><div id="ansr3"><%=arrayAnswer[questionsArray[0].getAnswerID()[2]]%></div></li>
				<li><div id="ansr4"><%=arrayAnswer[questionsArray[0].getAnswerID()[3]]%></div></li>
				<li><div id="ansr5"><%=arrayAnswer[questionsArray[0].getAnswerID()[4]]%></div></li>
			</ul>

		</div>
	</div>

	<div id="mainFrameResults" class="listRecipe">
		<h2 align=center id="titleResult">תוצאות חיפוש:</h2>
		<div id=RecipesView></div>
	</div>
	<div id="footer2"></div>
	<div id="footer"></div>
</body>
</html>