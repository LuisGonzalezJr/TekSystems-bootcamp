<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="<c:url value="../../../pub/product.css"/>" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <title>Sign up | Retro Console Gamers</title>

</head>

<h1>Product</h1>

<form action="/product/productSubmit" method="POST">


    Name : <input type="text" name="productName" value="${form.productName}">
    <br>
    Description : <input type="text" name="description" value="${form.description}">
    <br>
    Image URL : <input type="text" name="imageURL" value="${form.imageURL}">
    <br>
    Price : <input type="text" name="price" value="${form.price}">

    <button type="submit">Submit</button>
</form>

<c:if test="${bindingResult.hasErrors()}">
    <br>
    <c:forEach items="${bindingResult.getAllErrors()}" var="error">
        <div style="color:red;">${error.getDefaultMessage()}</div>
    </c:forEach>
</c:if>


<jsp:include page="../include/footer.jsp" />
