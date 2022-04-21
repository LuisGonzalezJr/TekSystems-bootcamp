<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>Main Menu | Retro Console Gamers</title>
</head>

<script src="https://code.jquery.com/jquery-3.6.0.js"
        integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>


<body>

    <div class="container">

        <a href="/home">Home</a> &nbsp; | &nbsp;
        <a href="/signup">Sign Up</a> &nbsp; | &nbsp;
        <a href="/login">Login</a> &nbsp; | &nbsp;
        <a href="/product">Product</a> &nbsp; | &nbsp;
        <a href="/cart">Cart</a> &nbsp; | &nbsp;
        <a href="/checkout">Checkout</a> &nbsp; | &nbsp;

        <sec:authorize access="hasAuthority('ADMIN')">
        &nbsp; | &nbsp;<a href="/user/search">Search</a>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
        &nbsp; | &nbsp; <a href="/login">Login</a>
        </sec:authorize>

        <sec:authorize access="isAuthenticated()">
        &nbsp; | &nbsp; <a href="/login/logout">Logout</a>
        &nbsp; &nbsp; <sec:authentication property="principal.username"/>
        </sec:authorize>

        <hr>
