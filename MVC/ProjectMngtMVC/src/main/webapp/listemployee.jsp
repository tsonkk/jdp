<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<html>
<head></head>
<body>
  <h2>PROJECT: ${proj.name}</h2>
  <table style="text-align:center" border="1">
    <tr>
      <th>ID</th>
      <th>Fullname</th>
      <th>Gen</th>
    </tr>
    <c:forEach var="emp" items="${emps}">
      <tr ${emp.gen==false ? "bgcolor='lightgrey'" : ""}>
        <td>${emp.id}</td>
        <td>${emp.fullname}</td>
        <td>${emp.gen==true ? "Nam" : "Nữ"}</td>
      </tr>
    </c:forEach>
  </table>
  <br/>
  <a href="ProjectServlet?action=list">Home</a>
</body>
</html>