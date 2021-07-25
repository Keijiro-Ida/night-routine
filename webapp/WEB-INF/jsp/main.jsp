<%@ page import="java.time.format.DateTimeFormatter,model.Sleep"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% Sleep sleep = (Sleep)session.getAttribute("sleep");
   DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm");
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
		<input type="button" class="btn_left" onclick="location.href='/LogoutServlet'" value="Logout">
			night routine
		<input type="button" class="btn_right" onclick="location.href='/UpdateUsersServlet'" value="Setting">
	 	</div>
		
		<% if(sleep == null) { %>
			<div id="main_index">
				<h2>ようこそ</h2>
				<p>最高の睡眠のための準備</p>
				<table>
				<tr><th>①就寝3時間前に夕食</th></tr>
				<tr><th>②90分前にお風呂</th></tr>
				<tr><th>③60分前からリラックスタイム</th></tr>
				</table>
				<p>就寝時刻に合わせて、深部体温を下げる。</p>
				<p>脳をスイッチオフにする。そのために</p>
				<p>就寝時刻から逆算して、ナイトルーティンを実行しましょう。</p>
				<p>こちらから就寝時刻の設定をしてください。</p>
				<input type="button" class="btn_sleep" onclick="location.href='/SleepSettingServlet'" value="就寝時刻設定">
				</div>
		<% } else { %>
				
			<div id="main">		
				<table>
					<tr id="sleepTime">
						<th>就寝時刻</th>
						<th><%= fmt.format(sleep.getSleepTime()) %></th>
					</tr>
					<tr><th>　</th><th>　</th></tr>
					<tr>
						<th>夕飯</th>
						<th><%= fmt.format(sleep.getSleepTime().minusMinutes(180)) %></th>
					</tr>
					<tr>
						<th>お風呂</th>
						<th><%= fmt.format(sleep.getSleepTime().minusMinutes(90)) %></th>
					</tr>
					<tr>
					<th>読書(スマホ禁止)</th>
					<th><%= fmt.format(sleep.getSleepTime().minusHours(1)) %></th>
					</tr>
				</table>
				<p>リマインド設定:
				<% if(sleep.getRemindSetting() == false){ %>
					OFF
			     <% } else { %>
					ON
				<% } %>
					</p>
				<input type="button" class="btn_sleep" onclick="location.href='/SleepSettingServlet'" value="就寝時刻設定">
			</div>
		<% } %>
		
	</div>
</body>
</html>