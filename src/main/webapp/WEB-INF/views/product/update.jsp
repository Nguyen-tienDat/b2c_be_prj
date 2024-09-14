<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/2/2024
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class ="container">
    <h1> Update Product</h1>
    <form method = 'post'>
        <div class="mb-3">
            <label for="inputName" class="form-label">Product Name</label>
            <input value="${product.getName()}" type="text" name="name" class="form-control" id="inputName">
        </div>

        <div class="mb-3">
            <label for="inputPrice" class="form-label">Product Price</label>
            <input value="${product.getPrice()}" type="text" name="price" class="form-control" id="inputPrice">
        </div>

        <div class="mb-3">
            <label for="inputCategory" class="form-label">Categories Name</label>
            <select id="inputCategory" name="categoryId" class="form-control">
                <c:forEach var="category" items="${categories}">
                    <option value="${category.getId()}"/>
                    <c:out value="${category.getName()}"/>
                    </option>
                </c:forEach>
            </select>
        </div>

        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>
