<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->
		<meta http-equiv="Content-Language" content="he" />
		<title>PC-Recipes - Tips</title>
	</head>
	<body>
	<script type="text/javascript" language="javascript" src="jQuery.js"></script>

		<!--  -->

<div id="header">
	<div id="headerRight">
		<div id="menu">
			<ul>
				<li><a href="Main">דף הבית</a></li>
				<li><a href="MyAccount.jsp">החשבון שלי</a></li>
				<li><a href="Tips.jsp">טיפים</a></li>
				<li><a href="ContactUs.jsp">צור קשר</a></li>
				<li><a href="Help.jsp">עזרה</a></li>
				<li><a href="About.jsp">אודות</a></li>
			</ul>	
		</div>
	</div>
	<div id="headerLeft">
		<a href="Main"><img src="https://raw.github.com/liorzaken/PC-Recipes/master/Images/PC-Recipes-B-small.jpg"></a>
	</div>
</div>
<div id="header2">
	<div id="search">
		<form action= "Search">
				חיפוש מתכון: <input type="text" name="SearchItem" value="כתוב כאן">
				<input type="submit" value="חפש">
			</form>
	</div>
</div>
		<div id="addProduct">
				<h2 align=center>הוסף מרכיב</h2>
				<form>
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

