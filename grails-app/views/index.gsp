<!doctype html>
<html>
<head>
    <title>Media Inventory</title>
    <g:render template="/templates/commonHead"/>
</head>

<body>
<header>
    <g:render template="/templates/topNavbar"/>
</header>

<div class="container">
    <g:link class="btn btn-lg btn-block btn-primary" controller="user">Log In</g:link>

    <h1>Not a user yet?</h1>

    <form action="/signup" method="post">
        <label>Username:</label><g:textField name="username"/>
        <label>E-Mail:</label><g:textField name="emailAddress"/>
        <label>Password:</label><g:passwordField name="password"/>
        <button class="btn btn-lg btn-block btn-default">Sign Up</button>
    </form>
</div>
<!--<footer>
    <g:render template="/templates/footer"/>
</footer>-->
</body>
</html>
