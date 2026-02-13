<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<html>
<head>
<script type="text/javascript">
  function details(id, name, age) {
    document.getElementById("txtID").value = id;
    document.getElementById("txtName").value = name;
    document.getElementById("txtAge").value = age;
  }
</script>
</head>
<body>
  <table>
    <tr>
      <td>
        <h2 align="center">CUSTOMER LIST</h2>
      </td>
    </tr>
    <tr>
      <td>
        <form method="POST">
          <table>
            <tr>
              <td>ID</td>
              <td><input type="text" id="txtID" name="txtID" required /></td>
              <td><input type="submit" formaction="?action=add" value="ADD" /></td>
            </tr>
            <tr>
              <td>Name</td>
              <td><input type="text" id="txtName" name="txtName" required /></td>
              <td><input type="submit" formaction="?action=update" value="UPDATE" /></td>
            </tr>
            <tr>
              <td>Age</td>
              <td><input type="text" id="txtAge" name="txtAge" required /></td>
              <td><input type="submit" formaction="?action=delete" value="DELETE" onclick="return confirm('ARE YOU SURE?')" /></td>
            </tr>
          </table>
        </form>
      </td>
    </tr>
    <tr>
      <td>
        <table style="width:100%" border="1">
          <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Age</th>
          </tr>
          <c:forEach var="cust" items="${custs}">
            <tr onclick="details(${cust.id}, '${cust.name}', ${cust.age})" style="cursor: pointer">
              <td>${cust.id}</td>
              <td>${cust.name}</td>
              <td>${cust.age}</td>
            </tr>
          </c:forEach>
        </table>
      </td>
    </tr>
  </table>
</body>
</html>