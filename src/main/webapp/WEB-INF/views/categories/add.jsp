<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 9/2/2024
  Time: 10:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="models.Categories" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
</head>
<body>

<div class="container">
    <h1>
        Add New Category!
    </h1>
    <form method ="post">
        <div class="mb-3">
            <label for="inputName" class="form-label">New Category Name</label>

            <input type="text" name="name" class="form-control" id="inputName" placeholder="Name it here!(Example:Peach)">
        </div>
        <button class="btn btn-primary" type="submit">SUBMIT</button>
    </form>
</div>

</body>
</html>
