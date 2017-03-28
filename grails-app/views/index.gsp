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
    <sec:ifLoggedIn>
        <a class="btn btn-lg btn-block btn-primary" href="/user">Log In</a>
    </sec:ifLoggedIn>
    <sec:ifNotLoggedIn>
        <g:link controller="login" action="auth" class="btn btn-lg btn-block btn-primary">Log In</g:link>
    </sec:ifNotLoggedIn>
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
