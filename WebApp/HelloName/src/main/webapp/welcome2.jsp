<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>Hello <%= request.getAttribute("fullName") %></h2><!-- Scriptlet -->
  <h2>Hello ${requestScope.fullName}</h2><!-- Expression Language -->
</body>
</html>