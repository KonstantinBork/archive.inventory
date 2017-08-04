<!DOCTYPE html>
<html>
<head>
    <g:render template="/templates/commonHead"/>
</head>

<body>
<g:render template="/templates/topNavbar"/>
<g:if test="params.signup">
    Success!
</g:if>
<g:else>
    Fail!
</g:else>
</body>
</html>