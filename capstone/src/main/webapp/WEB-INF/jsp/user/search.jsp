<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:include page="../include/header.jsp" />

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="<c:url value="../../../pub/search.css"/>" rel="stylesheet" type="text/css"/>

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <title>Sign up | Retro Console Gamers</title>

</head>


<h1>Search</h1>

<br>
<form action="/user/search" method="GET">
    First Name : <input type="text" name="firstName" value="${firstName}">
    <button type="submit">Submit</button>
</form>

<br>

<c:if test="${not empty firstName}">
    <h5>Search Results Found ${usersModelKey.size()}</h5>
    <br>
</c:if>



<table class="table">
    <tr scope="row">
        <th>Email</th>
        <th>First Name</th>
        <th>Last Name</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>


    <c:forEach items="${usersModelKey}" var="user">
        <tr scope="row">
            <td>${user.email}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td><a href="/user/edit/${user.id}">Edit</a></td>
            <td><a href="/user/delete/${user.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>

<jsp:include page="../include/footer.jsp" />