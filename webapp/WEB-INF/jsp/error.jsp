<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>眠活アプリ</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">

</head>
<body>
	
	<div id="pagebody">
		<div id="header">
			night routine
	    </div>
		<div id="main">
			<c:out value="${errorMsg }" /><br>
			<br>
			<a href="/MainServlet" >戻る</a>
		</div>
	</div>
</body>
</html>