<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%String failureMessage = (String)request.getAttribute("loginFailure"); %>
<% if (failureMessage != null) {%>
    <%=failureMessage %>
<%}%>
<form action="../jp.co.aforce/login" method="post">
ログインID<br>
<p><input type="text" name="id" required="required" value="${param.id}"></p>
パスワード
<p><input type="password" name="password" required="required"></p>
<input type="submit" value="ログイン">

</form>

<a href="http://localhost:8080/Login2/jsp/registration.jsp">会員登録が済んでいない人はこちら</a>
</body>
</html>