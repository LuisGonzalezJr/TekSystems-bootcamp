<jsp:include page="../include/header.jsp" />

<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="../../../pub/login.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <title>Log in | Retro Console Gamers</title>
</head>

<form action="/login/loginSubmit" method="POST">

    Username : <input type="email" name="username">
    <br>
    Password : <input type="password" name="password">
    <br>
    <button type="submit">Submit</button>
</form>


<jsp:include page="../include/footer.jsp" />