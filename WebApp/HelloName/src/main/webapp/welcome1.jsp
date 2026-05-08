<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <%
    String firstName = request.getParameter("txtFirstName");
    String lastName = request.getParameter("txtLastName");
    String fullName =  lastName.toUpperCase() + " " + firstName.toUpperCase();
  %>
  <h2>Hello <%= fullName %></h2>
</body>
</html>