<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1><%=request.getParameter("id") %>様は既に登録されています</h1>
<a href="http://localhost:8080/Login2/jsp/login.jsp">ログインページに戻る</a>
</body>
</html>