<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet" href="style/stylesheet.css" />
<script src="http://code.jquery.com/jquery-1.9.1.js"></script>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->
<meta http-equiv="Content-Language" content="he" />
<title>PC-Recipes - Help</title>
</head>
<script>
    $(document).ready( function() {
    	$('#search').hide(); 
    });
    </script>
<body>
	<%@ include file="/WEB-INF/header.jsp"%>

	<div id="mainFrame">
		<iframe width="640" height="360"
			src="//www.youtube.com/embed/WhtAJmgd7_M?rel=0" frameborder="0"
			allowfullscreen></iframe>
	</div>

	<div id="footer2"></div>
	<div id="footer"></div>
</body>
</html>