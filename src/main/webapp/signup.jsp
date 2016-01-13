<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sign up</title>
</head>
<body>
<form action="/kickstarter/signup" method="post">
  Login:
  <br>
  <input type="text" name = "login">
  <br>
  Password:
  <br>
  <input type="password" name = "password">
  <br>
  Repeat password:
  <br>
  <input type="password" name = "repeat_password">
  <br>
  Name:
  <br>
  <input type="text" name = "name">
  <br>
  Email:
  <br>
  <input type="email" name="email">
  <br>
  <input type="submit" value="ok">
</form>
</body>
</html>
