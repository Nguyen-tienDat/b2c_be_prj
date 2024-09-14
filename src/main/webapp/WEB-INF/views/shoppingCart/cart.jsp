<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h1>Shopping Cart</h1>
        <table class="table">
        <thead>
        <tr>
            <th scope="col">Product</th>
            <th scope="col">Price</th>
            <th scope="col">Quantity</th>
            <th scope="col">Total</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach var="cartItem" items="${cart}">
            <tr>
                <td>${cartItem.getProduct().getName()}</td>
                <td><fmt:formatNumber value = "${cartItem.getProduct().getPrice()}" type ="currency"/>
                <td>
                <a href="<c:url value="update_quantity"/>?id=${cartItem.getProduct().getId()}&quantity=-1">-</a>
                ${cartItem.getQuantity()}
                <a href="<c:url value="/update_quantity"/>?id=${cartItem.getProduct().getId()}&quantity=1">+</a>
            </td>
                <td>
                    <fmt:formatNumber value="${cartItem.getQuantity()*cartItem.getProduct().getPrice()}" type="currency"/>
                </td>
                <td>
                    <fmt:formatNumber value="${cartItem.getQuantity() * cartItem.getProduct().getPrice()}" type="currency"/>
                </td>
                <td>
                    <a href="<c:url value="/remove_from_cart"/>?id=${cartItem.getProduct().getId()}">Remove</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <h3>
        SubTotal: <fmt:formatNumber value="${subTotal}" type="currency"/>
    </h3>
    <h3>Tax: 10%</h3>
    <h3>Total: <fmt:formatNumber value="${total}" type="currency"/></h3>
    <a href="<c:url value ="/checkout"/>">Checkout</a>
</div>

</body>
</html>