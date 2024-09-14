<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/2/2024
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">

</head>
<body>
<div class="container">
    <h1>Our Categories, please have a look !</h1>
    <table  class = "table">
        <thead>
        <tr>
            <th scope="col">Number</th>
            <th scope="col">Name</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="category" items="${categories}">
            <tr>
                <th scope="row">
                    <c:out value="${category.getId()}"/>
                </th>

                <td>
                    <c:out value="${category.getName()}"/>
                </td>

                <td>
                    <a href="<%=request.getContextPath()%>/categories_edit?id=<c:out value="${category.getId()}"/>" class="btn btn-primary">Edit</a>
                    <a onclick="return confirm('It cannot recover. Are you sure ?')" href="<%=request.getContextPath()%>/categories_delete?id=<c:out value="${category.getId()}"/>" class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
