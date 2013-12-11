<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
		<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
		<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
		<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->
		<meta http-equiv="Content-Language" content="he" />
		<title>PC-Recipes - Contact Us</title>
	</head>
	<body>
	<script type="text/javascript" language="javascript" src="jQuery.js"></script>		
	<%@ include file="/WEB-INF/header.jsp" %>
		<div id="mainFrame">
				<div id="contact_us">
				<h1>צור קשר</h1>
				<form>
				<p>
					שם: <input type="text" name="name" value="" size="25" maxlength="70" /> 
				</p>
				<p>
				דואר אלקטרוני: <input type="text" name="e-mail" value="" size="25" maxlength="70" /> 
				</p>
				<p>
				נושא: <input type="text_subject" name="subject" value="" size="25" maxlength="70" /> 
				</p>
				<p>
				<textarea name="text" rows="6" cols="50"></textarea>
				</p>
				<p>
				<input type="submit" name="submit" value="שלח" onclick="alert('הודעתך התקבלה'); window.location='ContactUs.jsp'" style="cursor: pointer; " /> 
				</p>
				</form>
			</div>
		</div>
		<div id="footer2"></div>
		<div id="footer"></div>
	</body>	
</html>
