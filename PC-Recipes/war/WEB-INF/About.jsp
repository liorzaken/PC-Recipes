<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="direction:rtl;">
	<head>
		<link type="text/css" rel="stylesheet" href="style/stylesheet.css"/>
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta http-equiv="Content-Language" content="he" />
		<title>PC-Recipes - About</title>
	</head>
    <script>
    $(document).ready( function() {
    	$('#search').hide(); 
    });
    </script>
	
	<body>
	<%@ include file="/WEB-INF/header.jsp" %>
		<div id="mainFrame">
				<h2>אודותינו</h2>
				<p>אנחנו קבוצה של סטודנטים בשנה שלישית ללמודי תואר בהנדסת תוכנה</p>
				<p>קצת על הצוות:</p>
				<p>טליה כהן בת 25 מירושלים </p>
				<p>ליאור זקן בן 27 מירושלים</p>
				<p>ברכה גולדשמידט בת 25  מגוש עציון </p>
				<p> יעל מובשוביץ בת 22 מהר חברון </p>
				<p> נועם סילבר בן 27 ממודיעין </p>
				
				<p>    אנחנו צוות של חמישה חברים שבמסגרת קורס הנדסת תוכנה פיתחנו אתר מתכונים מקורי וייחודי.<br />
				 אתר מכוון את המשתמש למתכון שהוא הכי צריך בעזרת מנגנון שאלות והוספת מרכיבים.<br />
				המנגנון פותח בעזרתם של ראובן ושחר, המרצים של הקורס.</p>
				
				<img src="https://raw.github.com/liorzaken/PC-Recipes/master/Images/ourGroup.jpg">
				
		</div>
		<div id="footer2"></div>
		<div id="footer"></div>
	</body>	
</html>