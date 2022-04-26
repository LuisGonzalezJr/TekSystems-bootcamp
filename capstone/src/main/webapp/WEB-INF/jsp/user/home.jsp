<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>

<jsp:include page="../include/header.jsp" />


<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="<c:url value="../pub/home.css"/>" rel="stylesheet" type="text/css"/>


    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" />
    <title>Main Menu | Retro Console Gamers</title>

</head>

<body>
<div class="grid-container">
    <main>
        <div>Welcome Gamers</div>
    </main>
        <section id="Signup">

        </section>
    </a>
        <section id="Login">

        </section>
    </a>
    <section id="Featured">
        <table style="width:75%">
            <tr>
                <th>Company</th>
                <th>Console</th>
            </tr>
            <tr>
                <td>Sony</td>
                <td>PS1</td>
            </tr>
            <tr>
                <td>Microsoft</td>
                <td>Xbox</td>
            </tr>
            <tr>
                <td>Nintendo</td>
                <td>N64</td>
            </tr>
        </table>
    </section>
    <header>
        <div class="wrapper">
            <ul>
                <li>
                    Buy
                    <ul>
                        <li id="Playstation">Playstation</li>
                        <li id="Xbox">Xbox</li>
                        <li id="Nintendo">Nintendo</li>
                        <li>
                            Misc.
                            <ul>
                                <li>Add-ons</li>
                                <li>Controllers</li>
                                <li>Cables</li>
                            </ul>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>
    </header>
    <footer>
        <div class="Socials">
            <p id="footerP">Copyright &copy 2020-2022 RetroConsoleGamers, inc. -All rights reserved.</p>
            <strong>Follow us on: </strong>
            <a href="https://facebook.com" class="fa fa-facebook"></a>
            <a href="https://twitter.com" class="fa fa-twitter"></a>
            <a href="https://linkedin.com" class="fa fa-linkedin"></a>
        </div>
    </footer>
</div>
</body>

</html>

<jsp:include page="../include/footer.jsp" />