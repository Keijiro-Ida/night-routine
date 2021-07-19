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
			<input type="button" class="btn_left" onclick="location.href='/MainServlet'" value="return">
			<input type="button" class="btn_right_blank" value="">
	    </div>
		<div id="main">
			<form action="/UpdateUsersServlet" method="post">
				<table>
				<tr>
				<th>メールアドレス:</th>
				<th><input type="email" value="${users.mail}" name="mail"></th>
				</tr>
				<tr>
				<th>パスワード(8文字):</th>
				<th><input type="password" name="pass"></th>
				</tr>
				<tr>
				<th>パスワード(確認):</th>
				<th><input type="password" name="pass2"></th>
				</tr>
				</table>
				<br>
				<input type="submit" class="btn_center" value="登録"  onClick="return Check()">
			</form>
		</div>
	</div>
	
	
	
	<script>
		function Check(){
			var check = confirm('ユーザー情報を変更します。よろしいでしょうか？');
			if(check == true ) {
				return true;
			} else {
				return false;
			}
		}
	
	</script>
		
</body>
</html>