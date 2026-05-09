<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt"%>
<html>
<head></head>
<body>
  <table>
    <tr>
      <td>
        <h2 align="center">ADD PROJECT</h2>
      </td>
    </tr>
    <tr>
      <td>
        <form method="POST">
          <table>
            <tr>
              <td>Name</td>
              <td><input type="text" name="txtName" required /></td>
            </tr>
            <tr>
              <td>Deadline</td>
              <td><input type="date" name="dtDeadline" /></td>
            </tr>
            <tr>
              <td></td>
              <td><input type="submit" formaction="ProjectServlet?action=add" value="ADD" /></td>
            </tr>
          </table>
        </form>
      </td>
    </tr>
    <tr>
      <td>
        <table style="text-align:center" border="1">
          <caption><b>LIST PROJECTS</b></caption>
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Deadline</th>
            <th>No.Employees</th>
            <th>Action</th>
          </tr>
          <c:forEach var="proj" items="${projs}">
            <tr>
              <td>${proj.id}</td>
              <td>${proj.name}</td>
              <td><fmt:formatDate value="${proj.deadline}" pattern="dd/MM/yyyy" /></td>
              <td>${proj.employees.size()}</td>
              <td>
                <c:if test="${proj.employees.size() > 0}">
                  <a href="ProjectServlet?action=listemp&projID=${proj.id}">view</a>
                </c:if>
              </td>
            </tr>
          </c:forEach>
        </table>
      </td>
    </tr>
  </table>
</body>
</html>