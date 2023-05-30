<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h1>会員登録ページ</h1>
IDとパスワードを設定してください。

<form action="../jp.co.aforce/registration" method="post">
ログインID<br>
<p><input type="text" name="id" required="required"></p>
パスワード
<p><input type="text" name="password" required="required"></p>
<input type="submit" value="登録">
</form>

</body>
</html>