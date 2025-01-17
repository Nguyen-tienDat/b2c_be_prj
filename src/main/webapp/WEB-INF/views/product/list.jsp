<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Product List</h1>
    <table class="table">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Price</th>
            <th scope="col">Category Id</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="product" items="${products}">
            <tr>
                <th scope="row">
                    <c:out value="${product.getId()}"/>
                </th>
                <td>
                    <c:out value="${product.getName()}"/>
                </td>
                <td>
                    <c:out value="${product.getPrice()}"/>
                </td>
                <td>
                    <c:out value="${product.getCategoryId()}"/>
                </td>
                <td>
                    <a href="<%=request.getContextPath()%>/product_edit?id=<c:out value="${product.getId()}"/>"
                       class="btn btn-primary">Edit</a>
                    <a onclick="return confirm('Are you sure?')"
                       href="<%=request.getContextPath()%>/product_delete?id=<c:out value="${product.getId()}"/>"
                       class="btn btn-danger">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>