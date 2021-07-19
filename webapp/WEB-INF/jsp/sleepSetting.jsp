<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.Sleep,java.time.format.DateTimeFormatter" %>
<%  Sleep sleep = (Sleep) session.getAttribute("sleep");
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
	String sleepTime = null;
	if(sleep != null) {
		 sleepTime = fmt.format(sleep.getSleepTime());
	} else {
	 	 sleepTime = "23:00";
	}
 %>
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
			<input type="button" class="btn_left" onclick="location.href='/MainServlet'" value="return">
			night routine
			<input type="button" class="btn_right_blank" value="">
	 	</div>
	 	<div id="main">
			<h3>就寝時刻設定</h3>
			<% if(sleep != null) { %>
				<form action="/MainServlet" method="post">
					<input type=time value="<%= sleepTime %>" name="sleepTime">
					<br>
					<p>リマインドメール設定</p>
					<div class="remind_switch_area" id="make_remind">
						<input type=radio name="remind_switch" value="true" checked>
						<label for="remind_on">ON</label>
						<input type=radio name="remind_switch" value="false">
					<label for="remind_off">OFF</label>
					</div>
					<p>ナイトルーティンの最適な時間に</p>
					<p>メールを送信します。</p>
					<input type=submit class="btn_center" value="設定">
				</form>
			<% } else { %>
				<form action="/MainServlet" method="post">
					<input type=time value="<%= sleepTime %>" name="sleepTime">
					<br>
					<p>リマインドメール設定</p>
					<div class="remind_switch_area" id="make_remind">
						<input type="radio" name="remind_switch" id="remind_on"  value="true" checked>
						<label for="remind_on">ON</label>
						<input type="radio" name="remind_switch" id="remind_off" value="false">
						<label for="remind_off">OFF</label>
					</div>
					<p>ナイトルーティンの最適な時間に</p>
					<p>メールを送信します。</p>
					<input class="btn_center" type=submit value="設定">
				</form>
			<% } %>
		</div>
	</div>
</body>

</html>