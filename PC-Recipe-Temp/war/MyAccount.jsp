<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->
		<meta http-equiv="Content-Language" content="he" />
		<title>PC-Recipes - MyAccount</title>
	</head>
	<body>
	<script type="text/javascript" language="javascript" src="jQuery.js"></script>		
	<%@ include file="/WEB-INF/header.jsp" %>
	
		<div id="mainFrame">
			<h2>החשבון שלי</h2>
			<p>הכניסה כרגע מתאפשרת רק באמצעות חשבון פייסבוק</p>
			<p>לכניסה לחץ על הכפתור</p>
			<p><img src="https://raw.github.com/liorzaken/PC-Recipes/master/Images/fb-register.png" alt="הרשם לאתר עם חשבון הפייסבוק שלך"  onclick="alert('בנתיים נרשום שנכנסת, לא משנה מי אתה'); window.location='MyAccount.jsp'" style="cursor: pointer; "/></a></p>
		</div>
		<div id="footer2"></div>
		<div id="footer"></div>
	</body>	
</html>
