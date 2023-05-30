<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>ようこそ、<%=request.getAttribute("id") %>さん！</h1>

<form action="../jp.co.aforce/logout" method="post">
<input type="submit" value="logout" >
</form>
</body>
</html>