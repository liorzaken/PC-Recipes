<%@page import="pcrecipes.server.Search"%>
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
<link type="text/css" rel="stylesheet" href="stylesheet.css" />
<script src="http://code.jquery.com/jquery-1.10.2.js"></script>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" /> -->
<meta http-equiv="Content-Language" content="he" />
<title>PC-Recipes</title>
</head>
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
		

	<script type="text/javascript" language="javascript" src="script.js"></script>
	<%@ include file="/WEB-INF/header.jsp"%>
	<div id="addProduct">
		<h2 align=center>הוסף מרכיב</h2>
		<!-- <form action = "FilterProd" method="get">-->
		
			<input type="text" name="addItem" value="כתוב כאן">
		<!--</form>-->
		<button id="addProd">הוסף</button>
		<br/>
		<div class="listProd"></div>
	</div>
	<div id="mainFrameQuestion">

		<!-- <div id="questions">-->
		<%
	while (flag != 16) {
			i = r.nextInt(17);
			if (qFinish[i] == 0) {
				qFinish[i]++;
				flag++;
	%>
		<h2 id="question" align=center>
			<%=i%>.<%=questionsArray[i].getQuestion()%>
		</h2>
		<ul id="answer">
			<li class="ans_choice"><div id="ans1"><%=arrayAnswer[questionsArray[i].getAnswerID()[0]]%></div></li>
			<li class="ans_choice"><div id="ans2"><%=arrayAnswer[questionsArray[i].getAnswerID()[1]]%></div></li>
			<li class="ans_choice"><div id="ans3"><%=arrayAnswer[questionsArray[i].getAnswerID()[2]]%></div></li>
			<li class="ans_choice"><div id="ans4"><%=arrayAnswer[questionsArray[i].getAnswerID()[3]]%></div></li>
			<li class="ans_choice"><div id="ans5"><%=arrayAnswer[questionsArray[i].getAnswerID()[4]]%></div></li>
		</ul>
		<%
		}
		}
	%>
	</div>
	
	<div id="mainFrameResults" class= "listRecipe">
		<h2 align=center>תוצאות חיפוש</h2>
	</div>
	<div id="footer2"></div>
	<div id="footer"></div>
</body>
</html>