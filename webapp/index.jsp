<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>眠活</title>
<link rel="stylesheet" type="text/css" href="/css/style.css">
</head>
<body>
	<div id="pagebody">
		<div id="header">
			night routine
	 	</div>
		<div id="main_index">
			<h2>眠活アプリ</h2>
			<br>
			<form id="login" action="/LoginServlet" method="post">
				<table>
				<tr>
				<th>メールアドレス:</th><th><input type="email" name="mail"></th>
				</tr>
				<tr>
				<th>パスワード:</th><th><input type="password" name="pass"></th>
				<tr>
				</table>
				<input class="btn_center"type="submit" value="Login">
				<br>
			</form>
			<p>〜最高の睡眠を取れていますか〜</p>
			<p>理想の睡眠を得るために</p>
			<p>就寝時間から逆算し、最適な時刻に</p>
			<p>ナイトルーティンを行えるようにサポートします。</p>
			<br>
			<a href="/SignUpServlet">新規登録</a>
		</div>
	</div>
	
</body>
</html>