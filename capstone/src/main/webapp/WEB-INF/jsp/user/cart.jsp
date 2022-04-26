<jsp:include page="../include/header.jsp" />
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="<c:url value="../../../pub/cart.css"/>" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <title>Sign up | Retro Console Gamers</title>

</head>

<table class="table">
    <tr class="glow">
        <th>Image</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Quantity</th>
    </tr>
    <c:forEach
            items="${orders}" var="order">
        <tr scope="row" class="glow">
            <td><img src="../../../pub/images/${order.product.imageURL}" style=" height: 100px; width: 100px;" alt=""></td>
            <td>${order.product.name}</td>
            <td>${order.product.price}</td>
            <td>${order.product.description}</td>
            <td>${order.quantity}</td>
            <td>
                <a href="/cart/delete/${order.id}">
                    <button class="button" style="font-size: 20px">Delete</button>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>


<jsp:include page="../include/footer.jsp" />