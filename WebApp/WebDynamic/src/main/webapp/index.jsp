<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h2>Hello Dynamic Web Page</h2>
  <% java.util.Date now = new java.util.Date(); %>
  <p>The current date and time is: <%= now %></p>
</body>
</html>