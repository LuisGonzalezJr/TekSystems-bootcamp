<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="<c:url value="../../../pub/checkout.css"/>" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <title>Sign up | Retro Console Gamers</title>

</head>


<h1>Checkout</h1>

<form action="/checkoutSubmit" method="POST">


     <input type="text" name="creditCard" value="${form.creditCard}" placeholder="Credit Card...">
    <br>

    <button type="submit">Place your order</button>
</form>

<jsp:include page="../include/footer.jsp" />