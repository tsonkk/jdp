<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<html>
<head></head>
<body>
  <table>
    <tr>
      <td>
        <h2 align="center">ADD EMPLOYEE</h2>
      </td>
    </tr>
    <tr>
      <td>
        <form method="POST">
          <table>
            <tr>
              <td>Fullname</td>
              <td><input type="text" name="txtFullname" required /></td>
            </tr>
            <tr>
              <td>Gen</td>
              <td>
                <input type="radio" name="rdbGen" value="true" checked>Nam
                <input type="radio" name="rdbGen" value="false">Nữ
              </td>
            </tr>
            <tr>
              <td>Project</td>
              <td>
                <select name="cmbProjID">
                  <c:forEach var="proj" items="${projs}">
                    <option value="${proj.id}">${proj.name}</option>
                  </c:forEach>
                </select>
              </td>
            </tr>
            <tr>
              <td></td>
              <td><input type="submit" formaction="EmployeeServlet?action=add" value="ADD" /></td>
            </tr>
          </table>
        </form>
      </td>
    </tr>
    <tr>
      <td>
        <table style="text-align:center" border="1">
          <caption><b>LIST EMPLOYEES</b></caption>
          <tr>
            <th>ID</th>
            <th>Fullname</th>
            <th>Gen</th>
            <th>Project name</th>
            <th>Action</th>
          </tr>
          <c:forEach var="emp" items="${emps}">
            <tr ${emp.gen==false ? "bgcolor='lightgrey'" : ""}>
              <td>${emp.id}</td>
              <td>${emp.fullname}</td>
              <td>${emp.gen==true ? "Nam" : "Nữ"}</td>
              <td>${emp.project.name}</td>
              <td><a href="EmployeeServlet?action=delete&id=${emp.id}" onclick="return confirm('ARE YOU SURE?')">Delete</a></td>
            </tr>
          </c:forEach>
        </table>
      </td>
    </tr>
  </table>
</body>
</html>