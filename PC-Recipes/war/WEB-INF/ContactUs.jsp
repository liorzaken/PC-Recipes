<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="he" lang="he" dir="rtl">
<head>
<link type="text/css" rel="stylesheet" href="style/stylesheet.css" />
<!-- <link href="style/style2.css" rel="stylesheet" type="text/css" />-->
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->
<meta http-equiv="Content-Language" content="he" />
<title>PC-Recipes - Contact Us</title>
</head>
<script>
	$(document).ready(function() {
		$('#search').hide();
	});
</script>
<body>
	<%@ include file="/WEB-INF/header.jsp"%>

	<div id="mainFrame"> 
		<div id="contact_us">
			<h3>צור קשר</h3>
			<form action="AddMessage" method="post">

				<p>
					שם: <input type="text" name="nameM" value="" size="25"
						maxlength="70" />
				</p>
				<p>
					דואר אלקטרוני: <input type="text" name="e-mail" value="" size="25"
						maxlength="70" />
				</p>
				<p>
					נושא: <input type="text" name="subjectM" value="" size="25"
						maxlength="70" />
				</p>
				<p>
					<textarea name="textM" rows="6" cols="50"></textarea>
				</p>
				<p>
					<input type="submit" name="submitM" value="שלח" 
					onclick="alert('הודעתך התקבלה'); window.location='ContactUs.jsp'" style="cursor: pointer; " />
					<input type="reset" value="נקה" />
				</p>
			</form>
		</div>
	</div>
	<div id="footer2"></div>
	<div id="footer"></div>
</body>
</html>
