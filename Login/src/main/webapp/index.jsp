<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>






<%
    // Prevent direct access without login
    String username = (String) session.getAttribute("name");
    if (username == null) {
        response.sendRedirect("login.jsp");
    }
%>




<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>Welcome</title>
<!-- <link rel="stylesheet" href="css/style.css">  -->
<style>
.welcome-box {
	text-align: center;
	background: #fff;
	padding: 40px;
	border-radius: 12px;
	box-shadow: 0px 6px 15px rgba(0, 0, 0, 0.2);
	width: 400px;
	margin: 100px auto;
}

.welcome-box h2 {
	color: #333;
	margin-bottom: 15px;
}

.btn-logout {
	display: inline-block;
	margin-top: 20px;
	padding: 10px 18px;
	background: #ff4b5c;
	color: white;
	border-radius: 8px;
	text-decoration: none;
	font-weight: bold;
	transition: background 0.3s;
}

.btn-logout:hover {
	background: #ff1e38;
}
</style>
</head>
<body>
	<div class="welcome-box">
		<h2>Congrats 🎉</h2>
		<p>You logged into your account successfully!</p>
		<h3>
			Welcome,
			<%= username %>
			👋
		</h3>
		<a href="logout.jsp" class="btn-logout">Logout</a>
	</div>
</body>
</html>
