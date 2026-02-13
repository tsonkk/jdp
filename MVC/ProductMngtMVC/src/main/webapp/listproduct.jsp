<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<html>
<head>
<script type="text/javascript">
  function details(id, name, price) {
    document.getElementById("txtID").value = id;
    document.getElementById("txtName").value = name;
    document.getElementById("txtPrice").value = price;
  }
</script>
</head>
<body>
  <table>
    <tr>
      <td>
        <h2 align="center">PRODUCT LIST</h2>
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
              <td>Price</td>
              <td><input type="text" id="txtPrice" name="txtPrice" required /></td>
            </tr>
            <tr>
              <td colspan="2">
                <input type="submit" formaction="?action=add&catID=${param.catID}" value="ADD" />
                <input type="submit" formaction="?action=update&catID=${param.catID}" value="UPDATE" />
                <input type="submit" formaction="?action=delete&catID=${param.catID}" value="DELETE" onclick="return confirm('ARE YOU SURE?')" />
                <input type="button" onclick="window.location.href='CategoryServlet?action=list'" value="BACK" />
               </td>
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
            <th>Price</th>
            <th>Category</th>
          </tr>
          <c:forEach var="prod" items="${prods}">
            <tr onclick="details(${prod.id}, '${prod.name}', ${prod.price})" style="cursor: pointer">
              <td>${prod.id}</td>
              <td>${prod.name}</td>
              <td>${prod.price}</td>
              <td>${prod.catName}</td>
            </tr>
          </c:forEach>
        </table>
      </td>
    </tr>
  </table>
</body>
</html>