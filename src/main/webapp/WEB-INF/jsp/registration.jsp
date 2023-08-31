<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en" xmlns:form="http://www.w3.org/1999/html">
<head>
  <meta charset="UTF-8">
  <title>Registration!</title>
</head>
<body>
  <h1>${message}</h1>
  <form>
    <table>
      <tr>
        <td>
          Name:
        </td>
        <td>
          <form:input path="name" />
        </td>
      </tr>
      <tr>
        <td colspan="2">
          <input type="submit" value="Add Registration">
        </td>
      </tr>
    </table>
  </form>
</body>
</html>