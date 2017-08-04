<!DOCTYPE html>
<html>
<head>
    <g:render template="/templates/commonHead"/>
</head>

<body>
<g:render template="/templates/topNavbar"/>
<div class="container">
    <form action="${postUrl ?: '/login/authenticate'}" method="POST" id="loginForm" class="cssform" autocomplete="off">
        <p>
            <!--<label for="username"><g:message code='springSecurity.login.username.label'/>:</label>-->
            <label for="username">Username:</label>
            <input type="text" class="text_" name="${usernameParameter ?: 'username'}" id="username"/>
        </p>

        <p>
            <!--<label for="password"><g:message code='springSecurity.login.password.label'/>:</label>-->
            <label for="password">Password:</label>
            <input type="password" class="text_" name="${passwordParameter ?: 'password'}" id="password"/>
        </p>

        <p id="remember_me_holder">
            <input type="checkbox" class="chk" name="${rememberMeParameter ?: 'remember-me'}" id="remember_me"
                   <g:if test='${hasCookie}'>checked="checked"</g:if>/>
            <!--<label for="remember_me"><g:message code='springSecurity.login.remember.me.label'/></label>-->
            <label for="remember_me">Remember me</label>
        </p>

        <p>
            <input type="submit" id="submit" value="${message(code: 'springSecurity.login.button')}"/>
        </p>
    </form>
</div>
</body>
</html>