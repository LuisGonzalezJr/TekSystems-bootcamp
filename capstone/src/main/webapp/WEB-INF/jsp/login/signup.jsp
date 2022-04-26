<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="<c:url value="../../../pub/signup.css"/>" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <title>Sign up | Retro Console Gamers</title>

</head>



<c:if test="${empty form.id}">
    <h1>Sign Up</h1>
</c:if>

<c:if test="${not empty form.id}">
    <h1>Edit User</h1>
</c:if>

<form action="/login/signUpSubmit" method="POST">
    <input type="hidden" name="id" value="${form.id}">

    Email <input type="email" name="email" id="emailId" value="${form.email}">
    <c:forEach items='${bindingResult.getFieldErrors("email")}' var="error">
        <div style="color:red;">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    First Name <input type="text" name="firstName" id="firstNameId" value="${form.firstName}">
    <c:forEach items='${bindingResult.getFieldErrors("firstName")}' var="error">
        <div style="color:red;">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    Last Name <input type="text" name="lastName" id="lastNameId" value="${form.lastName}">
    <c:forEach items='${bindingResult.getFieldErrors("lastName")}' var="error">
        <div style="color:red;">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    Password <input type="text" name="password" id="passwordId" value="${form.password}">
    <c:forEach items='${bindingResult.getFieldErrors("password")}' var="error">
        <div style="color:red;">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    Confirm Password <input type="text" name="confirmPassword" id="confirmPasswordId" value="${form.confirmPassword}">
    <c:forEach items='${bindingResult.getFieldErrors("confirmPassword")}' var="error">
        <div style="color:red;">${error.getDefaultMessage()}</div>
    </c:forEach>
    <br>
    Accept Terms <input type="checkbox" name="checkbox">
    <br>
    <button type="submit">Submit</button>
</form>



<jsp:include page="../include/footer.jsp" />
