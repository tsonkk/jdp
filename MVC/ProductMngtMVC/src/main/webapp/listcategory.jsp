<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<html>
<head>
<script type="text/javascript">
  function details(id, name) {
    document.getElementById("txtID").value = id;
    document.getElementById("txtName").value = name;
  }
</script>
</head>
<body>
  <table>
    <tr>
      <td>Hello <b>${sessionScope.admin.username}</b> | <a href="AdminServlet?action=logout">Logout</a></td>
    </tr>
    <tr>
      <td>
        <h2 align="center">CATEGORY LIST</h2>
      </td>
    </tr>
    <tr>
      <td>
        <form method="POST">
          <table>
            <tr>
              <td>ID</td>
              <td><input type="text" id="txtID" name="txtID" required /></td>
            </tr>
            <tr>
              <td>Name</td>
              <td><input type="text" id="txtName" name="txtName" required /></td>
            </tr>
            <tr>
              <td colspan="2">
                <input type="submit" formaction="?action=add" value="ADD" />
                <input type="submit" formaction="?action=update" value="UPDATE" />
                <input type="submit" formaction="?action=delete" value="DELETE" onclick="return confirm('ARE YOU SURE?')" />
              </td>
            </tr>
          </table>
        </form>
      </td>
    </tr>
    <tr>
      <td>
        <table style="width:100%; text-align:center" border="1">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>No.Products</th>
            <th>Action</th>
          </tr>
          <c:forEach var="cat" items="${cats}">
            <tr onclick="details(${cat.id}, '${cat.name}')" style="cursor: pointer">
              <td>${cat.id}</td>
              <td>${cat.name}</td>
              <td>${cat.products.size()}</td>
              <td>
                <c:if test="${cat.products.size() > 0}">
                  <a href="ProductServlet?action=list&catID=${cat.id}">view</a>
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